package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.dbapi.C_CtyAZ80Y;
import com.gitee.freakchicken.dbapi.basic.domain.DataSource;
import com.gitee.freakchicken.dbapi.basic.domain.Group;
import com.gitee.freakchicken.dbapi.basic.service.C_wVYsOSU8;
import com.gitee.freakchicken.dbapi.basic.service.C_PPKGzyLn;
import com.gitee.freakchicken.dbapi.basic.service.C_8XCeckSJ;
import com.gitee.freakchicken.dbapi.basic.util.Constants;
import com.gitee.freakchicken.dbapi.basic.util.C_TfP8QHJa;
import com.gitee.freakchicken.dbapi.basic.util.C_khZIipIa;
import com.gitee.freakchicken.dbapi.basic.util.C_IlxBH4Hk;
import com.gitee.freakchicken.dbapi.basic.util.C_LCGXNEh5;
import com.gitee.freakchicken.dbapi.basic.util.C_yBFy9Zls;
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
public class C_ZT09X2gw {

    @Value("${dbapi.mode}")
    String gf_VFd5R0nq;

    @Autowired
    C_wVYsOSU8 gf_h5jV27AJ;

    @Autowired
    C_PPKGzyLn gf_L6gA9kbt;

    @Autowired
    C_8XCeckSJ gf_wEaYSGxG;

    @Value("${dbapi.api.context}")
    String gf_55bmoqv4;

    @RequestMapping("/context")
    public String m_pFGCvb4m() {
        return gf_55bmoqv4;
    }

    @RequestMapping("/add")
    public ResponseDto m_AdoBuLEf(@RequestBody JSONObject jo) {
        ApiConfig lf_XIoD6yy2 = new ApiConfig();
        lf_XIoD6yy2.setName(jo.getString("name"));
        lf_XIoD6yy2.setPath(jo.getString("path"));
        lf_XIoD6yy2.setNote(jo.getString("note"));
        lf_XIoD6yy2.setGroupId(jo.getString("groupId"));
        lf_XIoD6yy2.setContentType(jo.getString("contentType"));
        lf_XIoD6yy2.setJsonParam(jo.getString("jsonParam"));
        lf_XIoD6yy2.setParams(jo.getJSONArray("paramsJson").toString(SerializerFeature.WriteMapNullValue));
        lf_XIoD6yy2.setAccess(jo.getInteger("access"));
        lf_XIoD6yy2.setTask(jo.getJSONArray("taskJson").toString(SerializerFeature.WriteMapNullValue));
        lf_XIoD6yy2.setStatus(Constants.API_STATUS_OFFLINE);
        String lf_NmQv6OMM = C_yBFy9Zls.m_VCDBHJKc();
        lf_XIoD6yy2.setId(lf_NmQv6OMM);
        lf_XIoD6yy2.setCreateUserId(C_LCGXNEh5.m_4r4IiO0Z());
        JSONArray lf_rRuFR7rw = jo.getJSONArray("alarmPlugins");
        lf_rRuFR7rw.add(jo.getJSONObject("cachePlugin"));
        lf_rRuFR7rw.add(jo.getJSONObject("globalTransformPlugin"));
        List<ApiPluginConfig> lf_dUERAkf5 = lf_rRuFR7rw.toJavaList(ApiPluginConfig.class);
        List<ApiPluginConfig> lf_HrM12Qcc = lf_dUERAkf5.stream().filter(lambda_lf_e0ucfetg -> lambda_lf_e0ucfetg != null && StringUtils.isNotEmpty(lambda_lf_e0ucfetg.getPluginName())).collect(Collectors.toList());
        lf_HrM12Qcc.forEach(lambda_lf_6051cV7F -> lambda_lf_6051cV7F.setApiId(lf_NmQv6OMM));
        return gf_h5jV27AJ.m_EhCNIzPb(lf_XIoD6yy2, lf_HrM12Qcc);
    }

    @Deprecated
    @RequestMapping("/parseParam")
    public ResponseDto m_nhwpfiz1(String sql) {
        try {
            Set<String> lf_HdDcfvom = C_IlxBH4Hk.m_nqOfskey().parseParameter(sql);
            List<JSONObject> lf_KMM6veLV = lf_HdDcfvom.stream().map(lambda_lf_JOx3eQAs -> {
                JSONObject lf_8aAp6zYb = new JSONObject();
                lf_8aAp6zYb.put("value", lambda_lf_JOx3eQAs);
                return lf_8aAp6zYb;
            }).collect(Collectors.toList());
            return ResponseDto.successWithData(lf_KMM6veLV);
        } catch (Exception e) {
            return ResponseDto.fail(e.getMessage());
        }
    }

    @RequestMapping("/getAll")
    public List<ApiConfig> m_IjTtmAlz() {
        return gf_h5jV27AJ.m_mDeyeayM();
    }

    @RequestMapping("/getApiTree")
    public List<JSONObject> m_1IPsADMJ() {
        return gf_h5jV27AJ.m_rbrlGBqs();
    }

    @RequestMapping("/search")
    public List<ApiConfig> m_1mzWemqE(String name, String note, String path, String groupId) {
        return gf_h5jV27AJ.m_7q7vgSUm(name, note, path, groupId);
    }

    @RequestMapping("/detail/{id}")
    public ApiConfig m_4r7IiKXe(@PathVariable String id) {
        return gf_h5jV27AJ.m_hA9ufxjj(id);
    }

    @RequestMapping("/delete/{id}")
    public void m_AyGTGFHU(@PathVariable String id) {
        gf_h5jV27AJ.m_RfxGuUa3(id);
    }

    @RequestMapping("/update")
    public ResponseDto m_rYGgxJdT(@RequestBody JSONObject jo) {
        ApiConfig lf_Gb93IonA = new ApiConfig();
        lf_Gb93IonA.setId(jo.getString("id"));
        lf_Gb93IonA.setName(jo.getString("name"));
        lf_Gb93IonA.setPath(jo.getString("path"));
        lf_Gb93IonA.setNote(jo.getString("note"));
        lf_Gb93IonA.setGroupId(jo.getString("groupId"));
        lf_Gb93IonA.setContentType(jo.getString("contentType"));
        lf_Gb93IonA.setJsonParam(jo.getString("jsonParam"));
        lf_Gb93IonA.setParams(jo.getJSONArray("paramsJson").toString(SerializerFeature.WriteMapNullValue));
        lf_Gb93IonA.setAccess(jo.getInteger("access"));
        lf_Gb93IonA.setTask(jo.getJSONArray("taskJson").toString(SerializerFeature.WriteMapNullValue));
        lf_Gb93IonA.setStatus(Constants.API_STATUS_OFFLINE);
        JSONArray lf_KSypcpi3 = jo.getJSONArray("alarmPlugins");
        lf_KSypcpi3.add(jo.getJSONObject("cachePlugin"));
        lf_KSypcpi3.add(jo.getJSONObject("globalTransformPlugin"));
        List<ApiPluginConfig> lf_7Gvc7MBT = lf_KSypcpi3.toJavaList(ApiPluginConfig.class);
        List<ApiPluginConfig> lf_gqyF7Eq0 = lf_7Gvc7MBT.stream().filter(lambda_lf_ZPyXfPOR -> lambda_lf_ZPyXfPOR != null && StringUtils.isNotEmpty(lambda_lf_ZPyXfPOR.getPluginName())).collect(Collectors.toList());
        return gf_h5jV27AJ.m_WhMBVUDf(lf_Gb93IonA, lf_gqyF7Eq0);
    }

    @RequestMapping("/online/{id}")
    public void m_aalAs8Jc(@PathVariable String id) {
        gf_h5jV27AJ.m_GKkyTShG(id);
    }

    @RequestMapping("/offline/{id}")
    public void m_C1ZfIkrX(@PathVariable String id) {
        gf_h5jV27AJ.m_5iQ9959o(id);
    }

    @RequestMapping("/apiDocs")
    public void m_fgZdjIn0(String ids, HttpServletResponse response) {
        List<String> lf_XCJytY6A = Arrays.asList(ids.split(","));
        String lf_Oj6XvvmE = gf_h5jV27AJ.m_KtvoJG28(lf_XCJytY6A);
        response.setContentType("application/x-msdownload;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=API docs.md");
        OutputStream lf_dsxxatgL = null;
        try {
            lf_dsxxatgL = response.getOutputStream();
            lf_dsxxatgL.write(lf_Oj6XvvmE.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lf_dsxxatgL != null)
                    lf_dsxxatgL.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/downloadConfig")
    public void m_TKw6t5ey(String ids, HttpServletResponse response) {
        List<String> lf_meR7IyrX = Arrays.asList(ids.split(","));
        JSONObject lf_6RZjWjIu = gf_h5jV27AJ.m_08bwokdh(lf_meR7IyrX);
        String lf_dfXywfbh = lf_6RZjWjIu.toString(SerializerFeature.WriteMapNullValue);
        response.setContentType("application/x-msdownload;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=api_config.json");
        OutputStream lf_PM9NEndJ = null;
        try {
            lf_PM9NEndJ = response.getOutputStream();
            lf_PM9NEndJ.write(lf_dfXywfbh.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lf_PM9NEndJ != null)
                    lf_PM9NEndJ.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/downloadGroupConfig")
    public void m_n0MI2G90(String ids, HttpServletResponse response) {
        List<String> lf_pWAqL3Si = Arrays.asList(ids.split(","));
        List<Group> lf_uUdlz1jH = gf_wEaYSGxG.m_KyQGgcHd(lf_pWAqL3Si);
        String lf_pj3wT6T7 = JSON.toJSONString(lf_uUdlz1jH);
        response.setContentType("application/x-msdownload;charset=utf-8");
        OutputStream lf_9whpjGC3 = null;
        try {
            lf_9whpjGC3 = response.getOutputStream();
            lf_9whpjGC3.write(lf_pj3wT6T7.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lf_9whpjGC3 != null)
                    lf_9whpjGC3.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/import", produces = "application/json;charset=UTF-8")
    public void m_lq0Vvwa8(@RequestParam("file") MultipartFile file) throws IOException {
        String lf_I2GLLsUZ = IOUtils.toString(file.getInputStream(), "utf-8");
        JSONObject lf_lQts7Td7 = JSON.parseObject(lf_I2GLLsUZ);
        List<ApiConfig> lf_iCxzAVmF = lf_lQts7Td7.getJSONArray("api").toJavaList(ApiConfig.class);
        Integer lf_U4w9727s = gf_h5jV27AJ.m_AbSxaeyy();
        if ((lf_U4w9727s + lf_iCxzAVmF.size()) > C_CtyAZ80Y.m_WKWU3GQo()) {
            throw new RuntimeException("The number of API exceeds the limit");
        }
        lf_iCxzAVmF.stream().forEach(lambda_lf_w4Pt6rWQ -> {
            lambda_lf_w4Pt6rWQ.setCreateUserId(C_LCGXNEh5.m_4r4IiO0Z());
            lambda_lf_w4Pt6rWQ.setCreateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
            lambda_lf_w4Pt6rWQ.setUpdateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
        });
        List<ApiPluginConfig> lf_dXFfZ1ne = lf_lQts7Td7.getJSONArray("plugins").toJavaList(ApiPluginConfig.class);
        gf_h5jV27AJ.m_CjwFJtDd(lf_iCxzAVmF, lf_dXFfZ1ne);
    }

    @RequestMapping(value = "/importGroup", produces = "application/json;charset=UTF-8")
    public void m_co9T2DjY(@RequestParam("file") MultipartFile file) throws IOException {
        String lf_uo1KqfqC = IOUtils.toString(file.getInputStream(), "utf-8");
        List<Group> lf_LkQAip2c = JSON.parseArray(lf_uo1KqfqC, Group.class);
        Integer lf_30bVP3r3 = gf_wEaYSGxG.m_A43AZJfD();
        if ((lf_30bVP3r3 + lf_LkQAip2c.size()) > C_CtyAZ80Y.m_GPdLDm3B()) {
            throw new RuntimeException("The number of groups exceeds the limit");
        }
        lf_LkQAip2c.stream().forEach(lambda_lf_ERUJj9nc -> {
            lambda_lf_ERUJj9nc.setCreateUserId(C_LCGXNEh5.m_4r4IiO0Z());
            lambda_lf_ERUJj9nc.setCreateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
            lambda_lf_ERUJj9nc.setUpdateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
        });
        gf_wEaYSGxG.m_TqMvg6K2(lf_LkQAip2c);
    }

    @RequestMapping("/sql/execute")
    public ResponseDto m_b4FGGwh9(String datasourceId, String sql, String params) {
        DruidPooledConnection lf_vrwVJ6Fn = null;
        try {
            DataSource lf_0Q0GuTOG = gf_L6gA9kbt.m_ggRKn4xy(datasourceId);
            lf_vrwVJ6Fn = C_khZIipIa.m_vb8mHVEp(lf_0Q0GuTOG);
            Map<String, Object> lf_vY5ITqMT = JSON.parseObject(params, Map.class);
            SqlMeta lf_P21gf9D4 = C_IlxBH4Hk.m_nqOfskey().parse(sql, lf_vY5ITqMT);
            Object lf_lSxZr8OM = C_TfP8QHJa.m_MYbYmrjL(lf_vrwVJ6Fn, lf_P21gf9D4.getSql(), lf_P21gf9D4.getJdbcParamValues());
            return ResponseDto.successWithData(lf_lSxZr8OM);
        } catch (Exception e) {
            return ResponseDto.fail(e.getMessage());
        } finally {
            try {
                if (lf_vrwVJ6Fn != null)
                    lf_vrwVJ6Fn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/parseDynamicSql")
    public ResponseDto m_rxhvp6Vz(String sql, String params) {
        try {
            Map<String, Object> lf_x9u82ckz = JSON.parseObject(params, Map.class);
            SqlMeta lf_G03IyTNF = C_IlxBH4Hk.m_nqOfskey().parse(sql, lf_x9u82ckz);
            return ResponseDto.successWithData(lf_G03IyTNF);
        } catch (Exception e) {
            return ResponseDto.fail(e.getMessage());
        }
    }
}
