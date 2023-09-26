package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.dbapi.C_HnBXSCdF;
import com.gitee.freakchicken.dbapi.basic.domain.DataSource;
import com.gitee.freakchicken.dbapi.basic.domain.Group;
import com.gitee.freakchicken.dbapi.basic.service.C_eFnBz7On;
import com.gitee.freakchicken.dbapi.basic.service.C_6NZfqGQo;
import com.gitee.freakchicken.dbapi.basic.service.C_G5OMPVYO;
import com.gitee.freakchicken.dbapi.basic.util.Constants;
import com.gitee.freakchicken.dbapi.basic.util.C_7LZZiEH7;
import com.gitee.freakchicken.dbapi.basic.util.C_qv6gCIrW;
import com.gitee.freakchicken.dbapi.basic.util.C_dTvY8axI;
import com.gitee.freakchicken.dbapi.basic.util.C_pW4Y7Qx2;
import com.gitee.freakchicken.dbapi.basic.util.C_Kgwd1mWU;
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
public class C_cJUV5hk0 {

    @Value("${dbapi.mode}")
    String gf_jPSqlDtV;

    @Autowired
    C_eFnBz7On gf_UedHBOUD;

    @Autowired
    C_6NZfqGQo gf_S2vIEcXL;

    @Autowired
    C_G5OMPVYO gf_3bsC3IkD;

    @Value("${dbapi.api.context}")
    String gf_lI7qVlDz;

    @RequestMapping("/context")
    public String m_HeFC90hX() {
        return gf_lI7qVlDz;
    }

    @RequestMapping("/add")
    public ResponseDto m_RfdWxoXQ(@RequestBody JSONObject jo) {
        ApiConfig lf_Agb1l7QD = new ApiConfig();
        lf_Agb1l7QD.setName(jo.getString("name"));
        lf_Agb1l7QD.setPath(jo.getString("path"));
        lf_Agb1l7QD.setNote(jo.getString("note"));
        lf_Agb1l7QD.setGroupId(jo.getString("groupId"));
        lf_Agb1l7QD.setContentType(jo.getString("contentType"));
        lf_Agb1l7QD.setJsonParam(jo.getString("jsonParam"));
        lf_Agb1l7QD.setParams(jo.getJSONArray("paramsJson").toString(SerializerFeature.WriteMapNullValue));
        lf_Agb1l7QD.setAccess(jo.getInteger("access"));
        lf_Agb1l7QD.setTask(jo.getJSONArray("taskJson").toString(SerializerFeature.WriteMapNullValue));
        lf_Agb1l7QD.setStatus(Constants.API_STATUS_OFFLINE);
        String lf_ajAW9Tvh = C_Kgwd1mWU.m_lEjbzWIK();
        lf_Agb1l7QD.setId(lf_ajAW9Tvh);
        lf_Agb1l7QD.setCreateUserId(C_pW4Y7Qx2.m_0JUEwP8t());
        JSONArray lf_Rl72cLK6 = jo.getJSONArray("alarmPlugins");
        lf_Rl72cLK6.add(jo.getJSONObject("cachePlugin"));
        lf_Rl72cLK6.add(jo.getJSONObject("globalTransformPlugin"));
        List<ApiPluginConfig> lf_p1XcOi3t = lf_Rl72cLK6.toJavaList(ApiPluginConfig.class);
        List<ApiPluginConfig> lf_S58y5cqE = lf_p1XcOi3t.stream().filter(lambda_lf_klp9mJsz -> lambda_lf_klp9mJsz != null && StringUtils.isNotEmpty(lambda_lf_klp9mJsz.getPluginName())).collect(Collectors.toList());
        lf_S58y5cqE.forEach(lambda_lf_vyaYLtis -> lambda_lf_vyaYLtis.setApiId(lf_ajAW9Tvh));
        return gf_UedHBOUD.m_ALranmpM(lf_Agb1l7QD, lf_S58y5cqE);
    }

    @Deprecated
    @RequestMapping("/parseParam")
    public ResponseDto m_SiCK1qJv(String sql) {
        try {
            Set<String> lf_ibb17raJ = C_dTvY8axI.m_cwQ0C1DD().parseParameter(sql);
            List<JSONObject> lf_bzDh4T34 = lf_ibb17raJ.stream().map(lambda_lf_eS3rROBn -> {
                JSONObject lf_ObR2t6ML = new JSONObject();
                lf_ObR2t6ML.put("value", lambda_lf_eS3rROBn);
                return lf_ObR2t6ML;
            }).collect(Collectors.toList());
            return ResponseDto.successWithData(lf_bzDh4T34);
        } catch (Exception e) {
            return ResponseDto.fail(e.getMessage());
        }
    }

    @RequestMapping("/getAll")
    public List<ApiConfig> m_sLKSkjZm() {
        return gf_UedHBOUD.m_pK96IpqL();
    }

    @RequestMapping("/getApiTree")
    public List<JSONObject> m_1uVCFp9M() {
        return gf_UedHBOUD.m_Pk57zEy7();
    }

    @RequestMapping("/search")
    public List<ApiConfig> m_Lt2HyxLA(String name, String note, String path, String groupId) {
        return gf_UedHBOUD.m_g4EKNmhh(name, note, path, groupId);
    }

    @RequestMapping("/detail/{id}")
    public ApiConfig m_IaYBVoIl(@PathVariable String id) {
        return gf_UedHBOUD.m_ipLWUo7q(id);
    }

    @RequestMapping("/delete/{id}")
    public void m_4VUxLcOY(@PathVariable String id) {
        gf_UedHBOUD.m_63rwYEz6(id);
    }

    @RequestMapping("/update")
    public ResponseDto m_YKhe17mT(@RequestBody JSONObject jo) {
        ApiConfig lf_6NF2kMJ8 = new ApiConfig();
        lf_6NF2kMJ8.setId(jo.getString("id"));
        lf_6NF2kMJ8.setName(jo.getString("name"));
        lf_6NF2kMJ8.setPath(jo.getString("path"));
        lf_6NF2kMJ8.setNote(jo.getString("note"));
        lf_6NF2kMJ8.setGroupId(jo.getString("groupId"));
        lf_6NF2kMJ8.setContentType(jo.getString("contentType"));
        lf_6NF2kMJ8.setJsonParam(jo.getString("jsonParam"));
        lf_6NF2kMJ8.setParams(jo.getJSONArray("paramsJson").toString(SerializerFeature.WriteMapNullValue));
        lf_6NF2kMJ8.setAccess(jo.getInteger("access"));
        lf_6NF2kMJ8.setTask(jo.getJSONArray("taskJson").toString(SerializerFeature.WriteMapNullValue));
        lf_6NF2kMJ8.setStatus(Constants.API_STATUS_OFFLINE);
        JSONArray lf_gjHxkkWb = jo.getJSONArray("alarmPlugins");
        lf_gjHxkkWb.add(jo.getJSONObject("cachePlugin"));
        lf_gjHxkkWb.add(jo.getJSONObject("globalTransformPlugin"));
        List<ApiPluginConfig> lf_kFbZhxdR = lf_gjHxkkWb.toJavaList(ApiPluginConfig.class);
        List<ApiPluginConfig> lf_aqnD6TIl = lf_kFbZhxdR.stream().filter(lambda_lf_LyMR90oO -> lambda_lf_LyMR90oO != null && StringUtils.isNotEmpty(lambda_lf_LyMR90oO.getPluginName())).collect(Collectors.toList());
        return gf_UedHBOUD.m_s8IifzN8(lf_6NF2kMJ8, lf_aqnD6TIl);
    }

    @RequestMapping("/online/{id}")
    public void m_OT7ORR0W(@PathVariable String id) {
        gf_UedHBOUD.m_Tx0IS6CZ(id);
    }

    @RequestMapping("/offline/{id}")
    public void m_rl6ZXBIc(@PathVariable String id) {
        gf_UedHBOUD.m_3W7DE3Do(id);
    }

    @RequestMapping("/apiDocs")
    public void m_eSVsuKBb(String ids, HttpServletResponse response) {
        List<String> lf_p6oHo8Ec = Arrays.asList(ids.split(","));
        String lf_DZqldXdD = gf_UedHBOUD.m_pYMB4ORd(lf_p6oHo8Ec);
        response.setContentType("application/x-msdownload;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=API docs.md");
        OutputStream lf_2IE744NN = null;
        try {
            lf_2IE744NN = response.getOutputStream();
            lf_2IE744NN.write(lf_DZqldXdD.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lf_2IE744NN != null)
                    lf_2IE744NN.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/downloadConfig")
    public void m_7QILGUbD(String ids, HttpServletResponse response) {
        List<String> lf_dLt4szBt = Arrays.asList(ids.split(","));
        JSONObject lf_KHZ0OwKh = gf_UedHBOUD.m_LNzSZqF5(lf_dLt4szBt);
        String lf_2lIeJX16 = lf_KHZ0OwKh.toString(SerializerFeature.WriteMapNullValue);
        response.setContentType("application/x-msdownload;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=api_config.json");
        OutputStream lf_VvZBvw9J = null;
        try {
            lf_VvZBvw9J = response.getOutputStream();
            lf_VvZBvw9J.write(lf_2lIeJX16.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lf_VvZBvw9J != null)
                    lf_VvZBvw9J.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/downloadGroupConfig")
    public void m_K2D7I8Na(String ids, HttpServletResponse response) {
        List<String> lf_pw61uebW = Arrays.asList(ids.split(","));
        List<Group> lf_J4U8D2Zq = gf_3bsC3IkD.m_ckJ8klee(lf_pw61uebW);
        String lf_05pIrKah = JSON.toJSONString(lf_J4U8D2Zq);
        response.setContentType("application/x-msdownload;charset=utf-8");
        OutputStream lf_Q2mSfu2k = null;
        try {
            lf_Q2mSfu2k = response.getOutputStream();
            lf_Q2mSfu2k.write(lf_05pIrKah.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lf_Q2mSfu2k != null)
                    lf_Q2mSfu2k.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/import", produces = "application/json;charset=UTF-8")
    public void m_29M7NIy5(@RequestParam("file") MultipartFile file) throws IOException {
        String lf_4hOS46SE = IOUtils.toString(file.getInputStream(), "utf-8");
        JSONObject lf_euHzG4gL = JSON.parseObject(lf_4hOS46SE);
        List<ApiConfig> lf_1WDDgEHa = lf_euHzG4gL.getJSONArray("api").toJavaList(ApiConfig.class);
        Integer lf_eYSQMb4l = gf_UedHBOUD.m_j7RuLt43();
        if ((lf_eYSQMb4l + lf_1WDDgEHa.size()) > C_HnBXSCdF.m_VgdYPjQ0()) {
            throw new RuntimeException("The number of API exceeds the limit");
        }
        lf_1WDDgEHa.stream().forEach(lambda_lf_ff4KDNzf -> {
            lambda_lf_ff4KDNzf.setCreateUserId(C_pW4Y7Qx2.m_0JUEwP8t());
            lambda_lf_ff4KDNzf.setCreateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
            lambda_lf_ff4KDNzf.setUpdateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
        });
        List<ApiPluginConfig> lf_7Ntao2Bs = lf_euHzG4gL.getJSONArray("plugins").toJavaList(ApiPluginConfig.class);
        gf_UedHBOUD.m_jZJdUIYp(lf_1WDDgEHa, lf_7Ntao2Bs);
    }

    @RequestMapping(value = "/importGroup", produces = "application/json;charset=UTF-8")
    public void m_35WPOSbu(@RequestParam("file") MultipartFile file) throws IOException {
        String lf_kbONqxh6 = IOUtils.toString(file.getInputStream(), "utf-8");
        List<Group> lf_YUaWU3PV = JSON.parseArray(lf_kbONqxh6, Group.class);
        Integer lf_qtMjUF97 = gf_3bsC3IkD.m_jqTJt3Kz();
        if ((lf_qtMjUF97 + lf_YUaWU3PV.size()) > C_HnBXSCdF.m_rm48GyMg()) {
            throw new RuntimeException("The number of groups exceeds the limit");
        }
        lf_YUaWU3PV.stream().forEach(lambda_lf_ApsFmOEq -> {
            lambda_lf_ApsFmOEq.setCreateUserId(C_pW4Y7Qx2.m_0JUEwP8t());
            lambda_lf_ApsFmOEq.setCreateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
            lambda_lf_ApsFmOEq.setUpdateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
        });
        gf_3bsC3IkD.m_xNVZ10cQ(lf_YUaWU3PV);
    }

    @RequestMapping("/sql/execute")
    public ResponseDto m_3YBEF8dq(String datasourceId, String sql, String params) {
        DruidPooledConnection lf_41obZyAh = null;
        try {
            DataSource lf_PGg4GcCW = gf_S2vIEcXL.m_0NVp7hEz(datasourceId);
            lf_41obZyAh = C_qv6gCIrW.m_6BCTSwlB(lf_PGg4GcCW);
            Map<String, Object> lf_5TNkq9cb = JSON.parseObject(params, Map.class);
            SqlMeta lf_OlnnMllg = C_dTvY8axI.m_cwQ0C1DD().parse(sql, lf_5TNkq9cb);
            Object lf_vnxwqGF4 = C_7LZZiEH7.m_zMvTAVYI(lf_41obZyAh, lf_OlnnMllg.getSql(), lf_OlnnMllg.getJdbcParamValues());
            return ResponseDto.successWithData(lf_vnxwqGF4);
        } catch (Exception e) {
            return ResponseDto.fail(e.getMessage());
        } finally {
            try {
                if (lf_41obZyAh != null)
                    lf_41obZyAh.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/parseDynamicSql")
    public ResponseDto m_GaBlGI0L(String sql, String params) {
        try {
            Map<String, Object> lf_IUON4TA8 = JSON.parseObject(params, Map.class);
            SqlMeta lf_JQboKmel = C_dTvY8axI.m_cwQ0C1DD().parse(sql, lf_IUON4TA8);
            return ResponseDto.successWithData(lf_JQboKmel);
        } catch (Exception e) {
            return ResponseDto.fail(e.getMessage());
        }
    }
}
