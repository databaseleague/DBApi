package com.gitee.freakchicken.dbapi.basic.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.gitee.freakchicken.dbapi.basic.executor.Executor;
import com.gitee.freakchicken.dbapi.basic.executor.SQLExecutor;
import com.gitee.freakchicken.dbapi.basic.service.ApiConfigService;
import com.gitee.freakchicken.dbapi.basic.service.ApiService;
import com.gitee.freakchicken.dbapi.basic.service.DataSourceService;
import com.gitee.freakchicken.dbapi.basic.util.Constants;
import com.gitee.freakchicken.dbapi.basic.util.ThreadUtils;
import com.gitee.freakchicken.dbapi.common.ApiConfig;
import com.gitee.freakchicken.dbapi.common.ApiPluginConfig;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import com.gitee.freakchicken.dbapi.plugin.AlarmPlugin;
import com.gitee.freakchicken.dbapi.plugin.CachePlugin;
import com.gitee.freakchicken.dbapi.plugin.GlobalTransformPlugin;
import com.gitee.freakchicken.dbapi.plugin.PluginManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class APIServlet extends HttpServlet {

    @Autowired
    ApiConfigService apiConfigService;
    @Autowired
    DataSourceService dataSourceService;
    @Autowired
    ApiService apiService;

    @Value("${dbapi.api.context}")
    String apiContext;

    @Autowired
    SQLExecutor SQLExecutor;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.debug("servlet execute");
        String servletPath = request.getRequestURI();
        servletPath = servletPath.substring(apiContext.length() + 2);
        PrintWriter out = null;
        try {
            out = response.getWriter();
            ResponseDto responseDto = process(servletPath, request, response);
            // 全局数据转换
            ApiConfig config = (ApiConfig) request.getAttribute("pathApiConfig");
            Object res = globalTransform(responseDto, config);
            out.append(JSON.toJSONString(res, SerializerFeature.WriteMapNullValue));
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            ResponseDto responseDto = ResponseDto.fail(e.toString());
            // 全局数据转换
            ApiConfig config = (ApiConfig) request.getAttribute("pathApiConfig");
            Object res = globalTransform(responseDto, config);
            out.append(JSON.toJSONString(res, SerializerFeature.WriteMapNullValue));
            log.error(e.toString(), e);
        } finally {
            if (out != null)
                out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public ResponseDto process(String path, HttpServletRequest request, HttpServletResponse response) {
        // // 校验接口是否存在
        ApiConfig config = apiConfigService.getConfig(path);
        if (config == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return ResponseDto.fail("Api not exists");
        }
        request.setAttribute("pathApiConfig", config);
        try {
            Map<String, Object> requestParam = getParams(request, config);
            ApiPluginConfig cache = config.getCachePlugin();
            // get data from cache
            if (cache != null) {
                CachePlugin cachePlugin = PluginManager.getCachePlugin(cache.getPluginName());
                Object o = cachePlugin.get(config, requestParam, cache.getPluginParam());
                if (o != null) {
                    return ResponseDto.apiSuccess(o); // 如果缓存有数据直接返回
                }
            }

            List<Object> executorResults = new ArrayList<>();

            JSONArray tasks = config.getTaskJson();
            for (int i = 0; i < tasks.size(); i++) {
                JSONObject task = tasks.getJSONObject(i);
                int type = task.getIntValue("taskType");
                Executor executor;

                if (type == Constants.API_EXECUTOR_SQL)
                    executor = SQLExecutor;
                else if (type == Constants.API_EXECUTOR_HTTP)
                    executor = SQLExecutor;
                else if (type == Constants.API_EXECUTOR_ES)
                    executor = SQLExecutor;
                else
                    throw new RuntimeException("Executor type unknown!");
                Object res = executor.execute(task, requestParam);
                executorResults.add(res);
            }
            // 如果只有一个执行器就不返回数组格式的数据，返回对象格式
            Object result = executorResults.size() == 1 ? executorResults.get(0) : executorResults;

            // set data to cache
            if (cache != null) {
                CachePlugin cachePlugin = PluginManager.getCachePlugin(cache.getPluginName());
                cachePlugin.set(config, requestParam, result, cache.getPluginParam());
            }

            return ResponseDto.apiSuccess(result);

        } catch (Exception e) {
            // alarm if error
            List<ApiPluginConfig> alarms = config.getAlarmPlugins();
            for (ApiPluginConfig alarm : alarms) {
                try {
                    String param = alarm.getPluginParam();
                    AlarmPlugin alarmPlugin = PluginManager.getAlarmPlugin(alarm.getPluginName());
                    ThreadUtils.submitAlarmTask(new Runnable() {
                        @Override
                        public void run() {
                            alarmPlugin.alarm(e, config, request, param);
                        }
                    });
                } catch (Exception error) {
                    log.error(alarm.getPluginName() + " error!", error);
                }
            }

            throw new RuntimeException(e.getMessage());
        }
    }

    private Map<String, Object> getParams(HttpServletRequest request, ApiConfig apiConfig) {
        /**
         * Content-Type格式说明:
         * {@see <a href=
         * "https://www.w3.org/Protocols/rfc1341/4_Content-Type.html">Content-Type</a>}
         * type/subtype(;parameter)? type
         */
        String unParseContentType = request.getContentType();

        // 如果是浏览器get请求过来，取出来的contentType是null
        if (unParseContentType == null) {
            unParseContentType = MediaType.APPLICATION_FORM_URLENCODED_VALUE;
        }
        // issues/I57ZG2
        // 解析contentType 格式: appliation/json;charset=utf-8
        String[] contentTypeArr = unParseContentType.split(";");
        String contentType = contentTypeArr[0];

        Map<String, Object> params = null;
        // 如果是application/json请求，不管接口规定的content-type是什么，接口都可以访问，且请求参数都以json body 为准
        if (contentType.equalsIgnoreCase(MediaType.APPLICATION_JSON_VALUE)) {
            JSONObject jo = getHttpJsonBody(request);
            params = JSONObject.parseObject(jo.toJSONString(), new TypeReference<Map<String, Object>>() {
            });
        }
        // 如果是application/x-www-form-urlencoded请求，先判断接口规定的content-type是不是确实是application/x-www-form-urlencoded
        else if (contentType.equalsIgnoreCase(MediaType.APPLICATION_FORM_URLENCODED_VALUE)) {
            if (MediaType.APPLICATION_FORM_URLENCODED_VALUE.equalsIgnoreCase(apiConfig.getContentType())) {
                params = apiService.getSqlParam(request, apiConfig);
            } else {
                throw new RuntimeException("This API only supports content-type: " + apiConfig.getContentType()
                        + ", but you use: " + contentType);
            }
        } else {
            throw new RuntimeException("Content-type not supported: " + contentType);
        }

        return params;
    }

    private JSONObject getHttpJsonBody(HttpServletRequest request) {
        try {
            InputStreamReader in = new InputStreamReader(request.getInputStream(), "utf-8");
            BufferedReader br = new BufferedReader(in);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            JSONObject jsonObject = JSON.parseObject(sb.toString());
            return jsonObject;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {

        }
        return null;
    }

    /**
     * 全局转换数据
     *
     * @param responseDto
     * @param config
     * @return
     */
    private Object globalTransform(ResponseDto responseDto, ApiConfig config) {
        if (config != null) {
            ApiPluginConfig globalTransformPlugin = config.getGlobalTransformPlugin();
            if (globalTransformPlugin != null) {
                GlobalTransformPlugin plugin = PluginManager
                        .getGlobalTransformPlugin(globalTransformPlugin.getPluginName());
                return plugin.transform(responseDto, globalTransformPlugin.getPluginParam());
            }
        }
        return responseDto;
    }
}
