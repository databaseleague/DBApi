package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.dbapi.C_1muQm9UY;
import com.gitee.freakchicken.dbapi.basic.domain.DataSource;
import com.gitee.freakchicken.dbapi.basic.domain.Group;
import com.gitee.freakchicken.dbapi.basic.service.C_rjya7LFN;
import com.gitee.freakchicken.dbapi.basic.service.C_ZkDf0MyS;
import com.gitee.freakchicken.dbapi.basic.service.C_dTOaI7qN;
import com.gitee.freakchicken.dbapi.basic.util.Constants;
import com.gitee.freakchicken.dbapi.basic.util.C_QQPsbS0G;
import com.gitee.freakchicken.dbapi.basic.util.C_KvmbqieE;
import com.gitee.freakchicken.dbapi.basic.util.C_q0JUjrIY;
import com.gitee.freakchicken.dbapi.basic.util.C_vudUmpvO;
import com.gitee.freakchicken.dbapi.basic.util.C_sVjkvqrJ;
import com.gitee.freakchicken.dbapi.common.ApiConfig;
import com.gitee.freakchicken.dbapi.common.ApiPluginConfig;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import com.github.freakchick.orange.SqlMeta;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/apiConfig")
public class C_TD32LvKr {

    @Value("${dbapi.mode}")
    String gf_4RGpLVUm;

    @Autowired
    C_rjya7LFN gf_YmnEAmmf;

    @Autowired
    C_ZkDf0MyS gf_2ytv18SM;

    @Autowired
    C_dTOaI7qN gf_2ypKAgz1;

    @Value("${dbapi.api.context}")
    String gf_o55oe91o;

    @RequestMapping("/context")
    public String m_krzhev26() {
        return gf_o55oe91o;
    }

    @RequestMapping("/add")
    public ResponseDto m_zPVuLsG4(@RequestBody JSONObject jo) {
        ApiConfig lf_jL4HP0Qx = new ApiConfig();
        lf_jL4HP0Qx.setName(jo.getString("name"));
        lf_jL4HP0Qx.setPath(jo.getString("path"));
        lf_jL4HP0Qx.setNote(jo.getString("note"));
        lf_jL4HP0Qx.setGroupId(jo.getString("groupId"));
        lf_jL4HP0Qx.setContentType(jo.getString("contentType"));
        lf_jL4HP0Qx.setJsonParam(jo.getString("jsonParam"));
        lf_jL4HP0Qx.setParams(jo.getJSONArray("paramsJson").toString(SerializerFeature.WriteMapNullValue));
        lf_jL4HP0Qx.setAccess(jo.getInteger("access"));
        lf_jL4HP0Qx.setTask(jo.getJSONArray("taskJson").toString(SerializerFeature.WriteMapNullValue));
        lf_jL4HP0Qx.setStatus(Constants.API_STATUS_OFFLINE);
        String lf_SVInphME = C_sVjkvqrJ.m_5YILraKt();
        lf_jL4HP0Qx.setId(lf_SVInphME);
        lf_jL4HP0Qx.setCreateUserId(C_vudUmpvO.m_4zzh6Q4j());
        JSONArray lf_GkDxQkQ5 = jo.getJSONArray("alarmPlugins");
        lf_GkDxQkQ5.add(jo.getJSONObject("cachePlugin"));
        lf_GkDxQkQ5.add(jo.getJSONObject("globalTransformPlugin"));
        List<ApiPluginConfig> lf_Ro6oiXlA = lf_GkDxQkQ5.toJavaList(ApiPluginConfig.class);
        List<ApiPluginConfig> lf_f63v6kcg = lf_Ro6oiXlA.stream().filter(lambda_lf_MKCGugix -> lambda_lf_MKCGugix != null && StringUtils.isNotEmpty(lambda_lf_MKCGugix.getPluginName())).collect(Collectors.toList());
        lf_f63v6kcg.forEach(lambda_lf_I95W1aeo -> lambda_lf_I95W1aeo.setApiId(lf_SVInphME));
        return gf_YmnEAmmf.m_re9VPNUK(lf_jL4HP0Qx, lf_f63v6kcg);
    }

    @Deprecated
    @RequestMapping("/parseParam")
    public ResponseDto m_DhYf3LOg(String sql) {
        try {
            Set<String> lf_OoRvjHR9 = C_q0JUjrIY.m_AKRRqeF3().parseParameter(sql);
            List<JSONObject> lf_4pjlMAfI = lf_OoRvjHR9.stream().map(lambda_lf_G749WgKv -> {
                JSONObject lf_F4H8fDVD = new JSONObject();
                lf_F4H8fDVD.put("value", lambda_lf_G749WgKv);
                return lf_F4H8fDVD;
            }).collect(Collectors.toList());
            return ResponseDto.successWithData(lf_4pjlMAfI);
        } catch (Exception e) {
            return ResponseDto.fail(e.getMessage());
        }
    }

    @RequestMapping("/getAll")
    public List<ApiConfig> m_9c4QMMJV() {
        return gf_YmnEAmmf.m_k5HAKOzg();
    }

    @RequestMapping("/getApiTree")
    public List<JSONObject> m_MLE6JCpy() {
        return gf_YmnEAmmf.m_nydx4uQk();
    }

    @RequestMapping("/search")
    public List<ApiConfig> m_PGwtnEkb(String name, String note, String path, String groupId) {
        return gf_YmnEAmmf.m_dhINFPau(name, note, path, groupId);
    }

    @RequestMapping("/detail/{id}")
    public ApiConfig m_d3HrJDhK(@PathVariable String id) {
        return gf_YmnEAmmf.m_dtWYPUtm(id);
    }

    @RequestMapping("/delete/{id}")
    public void m_QMjXwjf5(@PathVariable String id) {
        gf_YmnEAmmf.m_IlS1nClI(id);
    }

    @RequestMapping("/update")
    public ResponseDto m_9Orrq6wO(@RequestBody JSONObject jo) {
        ApiConfig lf_nuUGRtBi = new ApiConfig();
        lf_nuUGRtBi.setId(jo.getString("id"));
        lf_nuUGRtBi.setName(jo.getString("name"));
        lf_nuUGRtBi.setPath(jo.getString("path"));
        lf_nuUGRtBi.setNote(jo.getString("note"));
        lf_nuUGRtBi.setGroupId(jo.getString("groupId"));
        lf_nuUGRtBi.setContentType(jo.getString("contentType"));
        lf_nuUGRtBi.setJsonParam(jo.getString("jsonParam"));
        lf_nuUGRtBi.setParams(jo.getJSONArray("paramsJson").toString(SerializerFeature.WriteMapNullValue));
        lf_nuUGRtBi.setAccess(jo.getInteger("access"));
        lf_nuUGRtBi.setTask(jo.getJSONArray("taskJson").toString(SerializerFeature.WriteMapNullValue));
        lf_nuUGRtBi.setStatus(Constants.API_STATUS_OFFLINE);
        JSONArray lf_ZzRXq19y = jo.getJSONArray("alarmPlugins");
        lf_ZzRXq19y.add(jo.getJSONObject("cachePlugin"));
        lf_ZzRXq19y.add(jo.getJSONObject("globalTransformPlugin"));
        List<ApiPluginConfig> lf_OEni41yF = lf_ZzRXq19y.toJavaList(ApiPluginConfig.class);
        List<ApiPluginConfig> lf_4yowH9QE = lf_OEni41yF.stream().filter(lambda_lf_VlAxOYn0 -> lambda_lf_VlAxOYn0 != null && StringUtils.isNotEmpty(lambda_lf_VlAxOYn0.getPluginName())).collect(Collectors.toList());
        return gf_YmnEAmmf.m_3IJcDSiO(lf_nuUGRtBi, lf_4yowH9QE);
    }

    @RequestMapping("/online/{id}")
    public void m_gBzIEkjb(@PathVariable String id) {
        gf_YmnEAmmf.m_E2cE3zIc(id);
    }

    @RequestMapping("/offline/{id}")
    public void m_R87EuUWv(@PathVariable String id) {
        gf_YmnEAmmf.m_KN7jEpTW(id);
    }

    @RequestMapping("/apiDocs")
    public void m_K3esMaSp(String ids, HttpServletResponse response) {
        List<String> lf_1qEsO44S = Arrays.asList(ids.split(","));
        String lf_w3fZ6l9z = gf_YmnEAmmf.m_Rvfs0kPH(lf_1qEsO44S);
        response.setContentType("application/x-msdownload;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=API docs.md");
        OutputStream lf_GhERU9qb = null;
        try {
            lf_GhERU9qb = response.getOutputStream();
            lf_GhERU9qb.write(lf_w3fZ6l9z.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lf_GhERU9qb != null)
                    lf_GhERU9qb.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/downloadConfig")
    public void m_qkR3ou1A(String ids, HttpServletResponse response) {
        List<String> lf_NofiGlxH = Arrays.asList(ids.split(","));
        JSONObject lf_NrojvZ60 = gf_YmnEAmmf.m_ijxFhkag(lf_NofiGlxH);
        String lf_ZbRnxbIL = lf_NrojvZ60.toString(SerializerFeature.WriteMapNullValue);
        response.setContentType("application/x-msdownload;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=api_config.json");
        OutputStream lf_BsU9tM8Y = null;
        try {
            lf_BsU9tM8Y = response.getOutputStream();
            lf_BsU9tM8Y.write(lf_ZbRnxbIL.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lf_BsU9tM8Y != null)
                    lf_BsU9tM8Y.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/downloadGroupConfig")
    public void m_Bp3icTBI(String ids, HttpServletResponse response) {
        List<String> lf_XdYHWZ1G = Arrays.asList(ids.split(","));
        List<Group> lf_BylizSwk = gf_2ypKAgz1.m_gQ24hXXG(lf_XdYHWZ1G);
        String lf_rS83E7Pb = JSON.toJSONString(lf_BylizSwk);
        response.setContentType("application/x-msdownload;charset=utf-8");
        OutputStream lf_sSB7Tulq = null;
        try {
            lf_sSB7Tulq = response.getOutputStream();
            lf_sSB7Tulq.write(lf_rS83E7Pb.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lf_sSB7Tulq != null)
                    lf_sSB7Tulq.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/import", produces = "application/json;charset=UTF-8")
    public void m_I6FoKsyS(@RequestParam("file") MultipartFile file) throws IOException {
        String lf_NAfMCpmn = IOUtils.toString(file.getInputStream(), "utf-8");
        JSONObject lf_5rQjMKTL = JSON.parseObject(lf_NAfMCpmn);
        List<ApiConfig> lf_5VIi2jll = lf_5rQjMKTL.getJSONArray("api").toJavaList(ApiConfig.class);
        Integer lf_6LVZ9waG = gf_YmnEAmmf.m_oHklR2vY();
        if ((lf_6LVZ9waG + lf_5VIi2jll.size()) > C_1muQm9UY.m_FIrnyhMh()) {
            throw new RuntimeException("The number of API exceeds the limit");
        }
        lf_5VIi2jll.stream().forEach(lambda_lf_knXpccRh -> {
            lambda_lf_knXpccRh.setCreateUserId(C_vudUmpvO.m_4zzh6Q4j());
            lambda_lf_knXpccRh.setCreateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
            lambda_lf_knXpccRh.setUpdateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
        });
        List<ApiPluginConfig> lf_gWAN2caN = lf_5rQjMKTL.getJSONArray("plugins").toJavaList(ApiPluginConfig.class);
        gf_YmnEAmmf.m_b1nKkOfD(lf_5VIi2jll, lf_gWAN2caN);
    }

    @RequestMapping(value = "/importGroup", produces = "application/json;charset=UTF-8")
    public void m_XBxk4uuu(@RequestParam("file") MultipartFile file) throws IOException {
        String lf_UH8TLxMF = IOUtils.toString(file.getInputStream(), "utf-8");
        List<Group> lf_HDV3I12X = JSON.parseArray(lf_UH8TLxMF, Group.class);
        Integer lf_LXebL46w = gf_2ypKAgz1.m_TZZqmGR8();
        if ((lf_LXebL46w + lf_HDV3I12X.size()) > C_1muQm9UY.m_ghEMlndZ()) {
            throw new RuntimeException("The number of groups exceeds the limit");
        }
        lf_HDV3I12X.stream().forEach(lambda_lf_ON6OpEdx -> {
            lambda_lf_ON6OpEdx.setCreateUserId(C_vudUmpvO.m_4zzh6Q4j());
            lambda_lf_ON6OpEdx.setCreateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
            lambda_lf_ON6OpEdx.setUpdateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
        });
        gf_2ypKAgz1.m_E4Xqx6XT(lf_HDV3I12X);
    }

    @RequestMapping("/sql/execute")
    public ResponseDto m_ui37godK(String datasourceId, String sql, String params) {
        DruidPooledConnection lf_iwYJRyyT = null;
        try {
            DataSource lf_G1kr5tRm = gf_2ytv18SM.m_GYWILPej(datasourceId);
            lf_iwYJRyyT = C_KvmbqieE.m_u5RCTUtN(lf_G1kr5tRm);
            Map<String, Object> lf_oPF722B8 = JSON.parseObject(params, Map.class);
            SqlMeta lf_0WkDGx9v = C_q0JUjrIY.m_AKRRqeF3().parse(sql, lf_oPF722B8);
            Object lf_dXcQ2g5W = C_QQPsbS0G.m_zHpGnoVb(lf_iwYJRyyT, lf_0WkDGx9v.getSql(), lf_0WkDGx9v.getJdbcParamValues());
            return ResponseDto.successWithData(lf_dXcQ2g5W);
        } catch (Exception e) {
            return ResponseDto.fail(e.getMessage());
        } finally {
            try {
                if (lf_iwYJRyyT != null)
                    lf_iwYJRyyT.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/parseDynamicSql")
    public ResponseDto m_zffYJ2f4(String sql, String params) {
        try {
            Map<String, Object> lf_k6g9xrvH = JSON.parseObject(params, Map.class);
            SqlMeta lf_1dW7HGdb = C_q0JUjrIY.m_AKRRqeF3().parse(sql, lf_k6g9xrvH);
            return ResponseDto.successWithData(lf_1dW7HGdb);
        } catch (Exception e) {
            return ResponseDto.fail(e.getMessage());
        }
    }
}
