package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.dbapi.apple.SqlMeta;
import com.dbapi.apple.verify.SpecManager;
import com.gitee.freakchicken.dbapi.basic.domain.DataSource;
import com.gitee.freakchicken.dbapi.basic.domain.Group;
import com.gitee.freakchicken.dbapi.basic.service.C_BO0wE3Ut;
import com.gitee.freakchicken.dbapi.basic.service.C_QZ7SgGKu;
import com.gitee.freakchicken.dbapi.basic.service.C_F7UxtfcI;
import com.gitee.freakchicken.dbapi.basic.util.Constants;
import com.gitee.freakchicken.dbapi.basic.util.C_VTgGlxrg;
import com.gitee.freakchicken.dbapi.basic.util.C_0pwc7Ovh;
import com.gitee.freakchicken.dbapi.basic.util.C_NCAE0oPV;
import com.gitee.freakchicken.dbapi.basic.util.C_EBTXy8Ml;
import com.gitee.freakchicken.dbapi.basic.util.C_epfPkhEu;
import com.gitee.freakchicken.dbapi.common.ApiConfig;
import com.gitee.freakchicken.dbapi.common.ApiPluginConfig;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
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
public class C_sNuhI288 {

    @Value("${dbapi.mode}")
    String gf_kdpQNvVM;

    @Autowired
    C_BO0wE3Ut gf_qnJMikkd;

    @Autowired
    C_QZ7SgGKu gf_Z0KnF5wm;

    @Autowired
    C_F7UxtfcI gf_ifdapSMM;

    @Value("${dbapi.api.context}")
    String gf_aIKOjgTb;

    @RequestMapping("/context")
    public String m_crzDhNa8() {
        return gf_aIKOjgTb;
    }

    @RequestMapping("/add")
    public ResponseDto m_xO90bXCT(@RequestBody JSONObject jo) {
        ApiConfig lf_VNcSjWTT = new ApiConfig();
        lf_VNcSjWTT.setName(jo.getString("name"));
        lf_VNcSjWTT.setPath(jo.getString("path"));
        lf_VNcSjWTT.setNote(jo.getString("note"));
        lf_VNcSjWTT.setGroupId(jo.getString("groupId"));
        lf_VNcSjWTT.setContentType(jo.getString("contentType"));
        lf_VNcSjWTT.setJsonParam(jo.getString("jsonParam"));
        lf_VNcSjWTT.setParams(jo.getJSONArray("paramsJson").toString(SerializerFeature.WriteMapNullValue));
        lf_VNcSjWTT.setAccess(jo.getInteger("access"));
        lf_VNcSjWTT.setTask(jo.getJSONArray("taskJson").toString(SerializerFeature.WriteMapNullValue));
        lf_VNcSjWTT.setStatus(Constants.API_STATUS_OFFLINE);
        String lf_H8zNzM2K = C_epfPkhEu.m_7HxJ62Xn();
        lf_VNcSjWTT.setId(lf_H8zNzM2K);
        lf_VNcSjWTT.setCreateUserId(C_EBTXy8Ml.m_3gCYT3A1());
        JSONArray lf_9JqhsW54 = jo.getJSONArray("alarmPlugins");
        lf_9JqhsW54.add(jo.getJSONObject("cachePlugin"));
        lf_9JqhsW54.add(jo.getJSONObject("globalTransformPlugin"));
        List<ApiPluginConfig> lf_MW00jPST = lf_9JqhsW54.toJavaList(ApiPluginConfig.class);
        List<ApiPluginConfig> lf_qeImGmy5 = lf_MW00jPST.stream().filter(lambda_lf_YERfQnBf -> lambda_lf_YERfQnBf != null && StringUtils.isNotEmpty(lambda_lf_YERfQnBf.getPluginName())).collect(Collectors.toList());
        lf_qeImGmy5.forEach(lambda_lf_FFnq1hKW -> lambda_lf_FFnq1hKW.setApiId(lf_H8zNzM2K));
        return gf_qnJMikkd.m_qMHviDKp(lf_VNcSjWTT, lf_qeImGmy5);
    }

    @Deprecated
    @RequestMapping("/parseParam")
    public ResponseDto m_tSVQU6ay(String sql) {
        try {
            Set<String> lf_d1sVgHw8 = C_NCAE0oPV.m_tFEt7ZPI().parseParameter(sql);
            List<JSONObject> lf_siyKaMdK = lf_d1sVgHw8.stream().map(lambda_lf_lhxf059m -> {
                JSONObject lf_qTWePXj5 = new JSONObject();
                lf_qTWePXj5.put("value", lambda_lf_lhxf059m);
                return lf_qTWePXj5;
            }).collect(Collectors.toList());
            return ResponseDto.successWithData(lf_siyKaMdK);
        } catch (Exception e) {
            return ResponseDto.fail(e.getMessage());
        }
    }

    @RequestMapping("/getAll")
    public List<ApiConfig> m_N4YvRXtB() {
        return gf_qnJMikkd.m_66ZRw9nD();
    }

    @RequestMapping("/getApiTree")
    public List<JSONObject> m_UskzCPWD() {
        return gf_qnJMikkd.m_4PLRgG8s();
    }

    @RequestMapping("/search")
    public List<ApiConfig> m_78LftkLy(String name, String note, String path, String groupId) {
        return gf_qnJMikkd.m_eQf2gfVa(name, note, path, groupId);
    }

    @RequestMapping("/detail/{id}")
    public ApiConfig m_epqt2eTM(@PathVariable String id) {
        return gf_qnJMikkd.m_1WtNkJkI(id);
    }

    @RequestMapping("/delete/{id}")
    public void m_SfNeB816(@PathVariable String id) {
        gf_qnJMikkd.m_aUiyjiiD(id);
    }

    @RequestMapping("/update")
    public ResponseDto m_hkpf79xz(@RequestBody JSONObject jo) {
        ApiConfig lf_X8eNGX00 = new ApiConfig();
        lf_X8eNGX00.setId(jo.getString("id"));
        lf_X8eNGX00.setName(jo.getString("name"));
        lf_X8eNGX00.setPath(jo.getString("path"));
        lf_X8eNGX00.setNote(jo.getString("note"));
        lf_X8eNGX00.setGroupId(jo.getString("groupId"));
        lf_X8eNGX00.setContentType(jo.getString("contentType"));
        lf_X8eNGX00.setJsonParam(jo.getString("jsonParam"));
        lf_X8eNGX00.setParams(jo.getJSONArray("paramsJson").toString(SerializerFeature.WriteMapNullValue));
        lf_X8eNGX00.setAccess(jo.getInteger("access"));
        lf_X8eNGX00.setTask(jo.getJSONArray("taskJson").toString(SerializerFeature.WriteMapNullValue));
        lf_X8eNGX00.setStatus(Constants.API_STATUS_OFFLINE);
        JSONArray lf_yaawLxsc = jo.getJSONArray("alarmPlugins");
        lf_yaawLxsc.add(jo.getJSONObject("cachePlugin"));
        lf_yaawLxsc.add(jo.getJSONObject("globalTransformPlugin"));
        List<ApiPluginConfig> lf_8JgGvogT = lf_yaawLxsc.toJavaList(ApiPluginConfig.class);
        List<ApiPluginConfig> lf_Mze5HK9n = lf_8JgGvogT.stream().filter(lambda_lf_flsPNgW7 -> lambda_lf_flsPNgW7 != null && StringUtils.isNotEmpty(lambda_lf_flsPNgW7.getPluginName())).collect(Collectors.toList());
        return gf_qnJMikkd.m_XSgTyy3P(lf_X8eNGX00, lf_Mze5HK9n);
    }

    @RequestMapping("/online/{id}")
    public void m_nqcxvMWI(@PathVariable String id) {
        gf_qnJMikkd.m_2LSvyIJT(id);
    }

    @RequestMapping("/offline/{id}")
    public void m_JAaYyxDX(@PathVariable String id) {
        gf_qnJMikkd.m_9JyQ800b(id);
    }

    @RequestMapping("/apiDocs")
    public void m_re4TkO1Y(String ids, HttpServletResponse response) {
        List<String> lf_2W3221hb = Arrays.asList(ids.split(","));
        String lf_EtXTfKMA = gf_qnJMikkd.m_BX8Ik24Z(lf_2W3221hb);
        response.setContentType("application/x-msdownload;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=API docs.md");
        OutputStream lf_ZDhJgbyE = null;
        try {
            lf_ZDhJgbyE = response.getOutputStream();
            lf_ZDhJgbyE.write(lf_EtXTfKMA.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lf_ZDhJgbyE != null)
                    lf_ZDhJgbyE.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/downloadConfig")
    public void m_H9t4ws4W(String ids, HttpServletResponse response) {
        List<String> lf_gjZAIQ81 = Arrays.asList(ids.split(","));
        JSONObject lf_jNQ9D023 = gf_qnJMikkd.m_RRTO3iZ2(lf_gjZAIQ81);
        String lf_weupZxew = lf_jNQ9D023.toString(SerializerFeature.WriteMapNullValue);
        response.setContentType("application/x-msdownload;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=api_config.json");
        OutputStream lf_mCiGHvpb = null;
        try {
            lf_mCiGHvpb = response.getOutputStream();
            lf_mCiGHvpb.write(lf_weupZxew.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lf_mCiGHvpb != null)
                    lf_mCiGHvpb.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/downloadGroupConfig")
    public void m_71Fswhvx(String ids, HttpServletResponse response) {
        List<String> lf_GtuJQap6 = Arrays.asList(ids.split(","));
        List<Group> lf_viGuStGN = gf_ifdapSMM.m_P2JLnZpb(lf_GtuJQap6);
        String lf_ijU8putO = JSON.toJSONString(lf_viGuStGN);
        response.setContentType("application/x-msdownload;charset=utf-8");
        OutputStream lf_RuRl8jJD = null;
        try {
            lf_RuRl8jJD = response.getOutputStream();
            lf_RuRl8jJD.write(lf_ijU8putO.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lf_RuRl8jJD != null)
                    lf_RuRl8jJD.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/import", produces = "application/json;charset=UTF-8")
    public void m_YekaCtPl(@RequestParam("file") MultipartFile file) throws IOException {
        String lf_JZpyuBkO = IOUtils.toString(file.getInputStream(), "utf-8");
        JSONObject lf_sZKtV8CA = JSON.parseObject(lf_JZpyuBkO);
        List<ApiConfig> lf_CXJNZ3yE = lf_sZKtV8CA.getJSONArray("api").toJavaList(ApiConfig.class);
        Integer lf_1zbu7dTU = gf_qnJMikkd.m_hsVnmyi8();
        if ((lf_1zbu7dTU + lf_CXJNZ3yE.size()) > SpecManager.getApiNum()) {
            throw new RuntimeException("The number of API exceeds the limit");
        }
        lf_CXJNZ3yE.stream().forEach(lambda_lf_gy86Bcqn -> {
            lambda_lf_gy86Bcqn.setCreateUserId(C_EBTXy8Ml.m_3gCYT3A1());
            lambda_lf_gy86Bcqn.setCreateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
            lambda_lf_gy86Bcqn.setUpdateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
        });
        List<ApiPluginConfig> lf_VE9qMidl = lf_sZKtV8CA.getJSONArray("plugins").toJavaList(ApiPluginConfig.class);
        gf_qnJMikkd.m_iNPE4Jub(lf_CXJNZ3yE, lf_VE9qMidl);
    }

    @RequestMapping(value = "/importGroup", produces = "application/json;charset=UTF-8")
    public void m_QGDFHKxf(@RequestParam("file") MultipartFile file) throws IOException {
        String lf_b1b31F3c = IOUtils.toString(file.getInputStream(), "utf-8");
        List<Group> lf_cbbumZnx = JSON.parseArray(lf_b1b31F3c, Group.class);
        Integer lf_khxPcD30 = gf_ifdapSMM.m_UbEhBqkn();
        if ((lf_khxPcD30 + lf_cbbumZnx.size()) > SpecManager.getGroupNum()) {
            throw new RuntimeException("The number of groups exceeds the limit");
        }
        lf_cbbumZnx.stream().forEach(lambda_lf_rf3LQktt -> {
            lambda_lf_rf3LQktt.setCreateUserId(C_EBTXy8Ml.m_3gCYT3A1());
            lambda_lf_rf3LQktt.setCreateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
            lambda_lf_rf3LQktt.setUpdateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
        });
        gf_ifdapSMM.m_pzism1vn(lf_cbbumZnx);
    }

    @RequestMapping("/sql/execute")
    public ResponseDto m_bviUDAum(String datasourceId, String sql, String params) {
        DruidPooledConnection lf_b5XoscUB = null;
        try {
            DataSource lf_iWGIlrIg = gf_Z0KnF5wm.m_sUgJb8Zu(datasourceId);
            lf_b5XoscUB = C_0pwc7Ovh.m_Smt0D1dZ(lf_iWGIlrIg);
            Map<String, Object> lf_FCbaHZFz = JSON.parseObject(params, Map.class);
            SqlMeta lf_ipHrbEAN = C_NCAE0oPV.m_tFEt7ZPI().parse(sql, lf_FCbaHZFz);
            Object lf_44J2n595 = C_VTgGlxrg.m_Rg4menVn(lf_b5XoscUB, lf_ipHrbEAN.getSql(), lf_ipHrbEAN.getJdbcParamValues());
            return ResponseDto.successWithData(lf_44J2n595);
        } catch (Exception e) {
            return ResponseDto.fail(e.getMessage());
        } finally {
            try {
                if (lf_b5XoscUB != null)
                    lf_b5XoscUB.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/parseDynamicSql")
    public ResponseDto m_w3XMhZd4(String sql, String params) {
        try {
            Map<String, Object> lf_ebgBL8wS = JSON.parseObject(params, Map.class);
            SqlMeta lf_r6VpLB9H = C_NCAE0oPV.m_tFEt7ZPI().parse(sql, lf_ebgBL8wS);
            return ResponseDto.successWithData(lf_r6VpLB9H);
        } catch (Exception e) {
            return ResponseDto.fail(e.getMessage());
        }
    }
}
