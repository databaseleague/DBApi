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
import com.gitee.freakchicken.dbapi.basic.service.C_sHsAeSoN;
import com.gitee.freakchicken.dbapi.basic.service.C_DNpMVP6y;
import com.gitee.freakchicken.dbapi.basic.service.C_n20BDw2R;
import com.gitee.freakchicken.dbapi.basic.util.Constants;
import com.gitee.freakchicken.dbapi.basic.util.C_31nDdnvP;
import com.gitee.freakchicken.dbapi.basic.util.C_iYar35dl;
import com.gitee.freakchicken.dbapi.basic.util.C_6ZmRqh3F;
import com.gitee.freakchicken.dbapi.basic.util.C_9CYMzywH;
import com.gitee.freakchicken.dbapi.basic.util.C_soYuxXDp;
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
public class C_YDRbukbu {

    @Value("${dbapi.mode}")
    String gf_ZCBr7ita;

    @Autowired
    C_sHsAeSoN gf_KDuDr1Ld;

    @Autowired
    C_DNpMVP6y gf_XreQhihq;

    @Autowired
    C_n20BDw2R gf_C3yHhNKe;

    @Value("${dbapi.api.context}")
    String gf_Fn6QkjYb;

    @RequestMapping("/context")
    public String m_XVb9tjvP() {
        return gf_Fn6QkjYb;
    }

    @RequestMapping("/add")
    public ResponseDto m_SlDEMexV(@RequestBody JSONObject jo) {
        ApiConfig lf_veusXjsT = new ApiConfig();
        lf_veusXjsT.setName(jo.getString("name"));
        lf_veusXjsT.setPath(jo.getString("path"));
        lf_veusXjsT.setNote(jo.getString("note"));
        lf_veusXjsT.setGroupId(jo.getString("groupId"));
        lf_veusXjsT.setContentType(jo.getString("contentType"));
        lf_veusXjsT.setJsonParam(jo.getString("jsonParam"));
        lf_veusXjsT.setParams(jo.getJSONArray("paramsJson").toString(SerializerFeature.WriteMapNullValue));
        lf_veusXjsT.setAccess(jo.getInteger("access"));
        lf_veusXjsT.setTask(jo.getJSONArray("taskJson").toString(SerializerFeature.WriteMapNullValue));
        lf_veusXjsT.setStatus(Constants.API_STATUS_OFFLINE);
        String lf_dKvRRfXD = C_soYuxXDp.m_GvdOXSp3();
        lf_veusXjsT.setId(lf_dKvRRfXD);
        lf_veusXjsT.setCreateUserId(C_9CYMzywH.m_PvlTFGSh());
        JSONArray lf_zHf0M7bz = jo.getJSONArray("alarmPlugins");
        lf_zHf0M7bz.add(jo.getJSONObject("cachePlugin"));
        lf_zHf0M7bz.add(jo.getJSONObject("globalTransformPlugin"));
        List<ApiPluginConfig> lf_XOu0gHiK = lf_zHf0M7bz.toJavaList(ApiPluginConfig.class);
        List<ApiPluginConfig> lf_AS388H5m = lf_XOu0gHiK.stream().filter(lambda_lf_x0NAMR2H -> lambda_lf_x0NAMR2H != null && StringUtils.isNotEmpty(lambda_lf_x0NAMR2H.getPluginName())).collect(Collectors.toList());
        lf_AS388H5m.forEach(lambda_lf_A2sAcTim -> lambda_lf_A2sAcTim.setApiId(lf_dKvRRfXD));
        return gf_KDuDr1Ld.m_xEK26qA3(lf_veusXjsT, lf_AS388H5m);
    }

    @Deprecated
    @RequestMapping("/parseParam")
    public ResponseDto m_wMdwAhTn(String sql) {
        try {
            Set<String> lf_QUoqNO8v = C_6ZmRqh3F.m_dzVvIA7n().parseParameter(sql);
            List<JSONObject> lf_eTGGyq8o = lf_QUoqNO8v.stream().map(lambda_lf_axTPWAkz -> {
                JSONObject lf_GbUtogRU = new JSONObject();
                lf_GbUtogRU.put("value", lambda_lf_axTPWAkz);
                return lf_GbUtogRU;
            }).collect(Collectors.toList());
            return ResponseDto.successWithData(lf_eTGGyq8o);
        } catch (Exception e) {
            return ResponseDto.fail(e.getMessage());
        }
    }

    @RequestMapping("/getAll")
    public List<ApiConfig> m_US9FfaMB() {
        return gf_KDuDr1Ld.m_5So2gceK();
    }

    @RequestMapping("/getApiTree")
    public List<JSONObject> m_W45DVCgd() {
        return gf_KDuDr1Ld.m_0C8JCjwY();
    }

    @RequestMapping("/search")
    public List<ApiConfig> m_O8uhfNLi(String name, String note, String path, String groupId) {
        return gf_KDuDr1Ld.m_pHA3KY8P(name, note, path, groupId);
    }

    @RequestMapping("/detail/{id}")
    public ApiConfig m_gur0Ma5f(@PathVariable String id) {
        return gf_KDuDr1Ld.m_mSimgjoh(id);
    }

    @RequestMapping("/delete/{id}")
    public void m_SIzgWKcK(@PathVariable String id) {
        gf_KDuDr1Ld.m_NkaKOjMy(id);
    }

    @RequestMapping("/update")
    public ResponseDto m_AC80K5Sk(@RequestBody JSONObject jo) {
        ApiConfig lf_swOqwffd = new ApiConfig();
        lf_swOqwffd.setId(jo.getString("id"));
        lf_swOqwffd.setName(jo.getString("name"));
        lf_swOqwffd.setPath(jo.getString("path"));
        lf_swOqwffd.setNote(jo.getString("note"));
        lf_swOqwffd.setGroupId(jo.getString("groupId"));
        lf_swOqwffd.setContentType(jo.getString("contentType"));
        lf_swOqwffd.setJsonParam(jo.getString("jsonParam"));
        lf_swOqwffd.setParams(jo.getJSONArray("paramsJson").toString(SerializerFeature.WriteMapNullValue));
        lf_swOqwffd.setAccess(jo.getInteger("access"));
        lf_swOqwffd.setTask(jo.getJSONArray("taskJson").toString(SerializerFeature.WriteMapNullValue));
        lf_swOqwffd.setStatus(Constants.API_STATUS_OFFLINE);
        JSONArray lf_wDROmHy3 = jo.getJSONArray("alarmPlugins");
        lf_wDROmHy3.add(jo.getJSONObject("cachePlugin"));
        lf_wDROmHy3.add(jo.getJSONObject("globalTransformPlugin"));
        List<ApiPluginConfig> lf_9PqGCD8P = lf_wDROmHy3.toJavaList(ApiPluginConfig.class);
        List<ApiPluginConfig> lf_KvKKABF9 = lf_9PqGCD8P.stream().filter(lambda_lf_5Xbgkli2 -> lambda_lf_5Xbgkli2 != null && StringUtils.isNotEmpty(lambda_lf_5Xbgkli2.getPluginName())).collect(Collectors.toList());
        return gf_KDuDr1Ld.m_zwXVqNvo(lf_swOqwffd, lf_KvKKABF9);
    }

    @RequestMapping("/online/{id}")
    public void m_a675c2lS(@PathVariable String id) {
        gf_KDuDr1Ld.m_e6rpW4EX(id);
    }

    @RequestMapping("/offline/{id}")
    public void m_6le0dGvI(@PathVariable String id) {
        gf_KDuDr1Ld.m_DdgwRMLI(id);
    }

    @RequestMapping("/apiDocs")
    public void m_j2LncWBZ(String ids, HttpServletResponse response) {
        List<String> lf_dDGemBCh = Arrays.asList(ids.split(","));
        String lf_6B8p6feH = gf_KDuDr1Ld.m_4xejOow2(lf_dDGemBCh);
        response.setContentType("application/x-msdownload;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=API docs.md");
        OutputStream lf_X8WgyeSr = null;
        try {
            lf_X8WgyeSr = response.getOutputStream();
            lf_X8WgyeSr.write(lf_6B8p6feH.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lf_X8WgyeSr != null)
                    lf_X8WgyeSr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/downloadConfig")
    public void m_AHN786FR(String ids, HttpServletResponse response) {
        List<String> lf_zfRbxFMQ = Arrays.asList(ids.split(","));
        JSONObject lf_ADkBGJwd = gf_KDuDr1Ld.m_VVB9RsWZ(lf_zfRbxFMQ);
        String lf_ACuVWecW = lf_ADkBGJwd.toString(SerializerFeature.WriteMapNullValue);
        response.setContentType("application/x-msdownload;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=api_config.json");
        OutputStream lf_HFAcfk6U = null;
        try {
            lf_HFAcfk6U = response.getOutputStream();
            lf_HFAcfk6U.write(lf_ACuVWecW.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lf_HFAcfk6U != null)
                    lf_HFAcfk6U.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/downloadGroupConfig")
    public void m_mEHLDmgk(String ids, HttpServletResponse response) {
        List<String> lf_fTtNmsml = Arrays.asList(ids.split(","));
        List<Group> lf_FNPjLJFd = gf_C3yHhNKe.m_b4oT5wNc(lf_fTtNmsml);
        String lf_lEcu35C4 = JSON.toJSONString(lf_FNPjLJFd);
        response.setContentType("application/x-msdownload;charset=utf-8");
        OutputStream lf_kOEXLKX2 = null;
        try {
            lf_kOEXLKX2 = response.getOutputStream();
            lf_kOEXLKX2.write(lf_lEcu35C4.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lf_kOEXLKX2 != null)
                    lf_kOEXLKX2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/import", produces = "application/json;charset=UTF-8")
    public void m_ikZBMvHU(@RequestParam("file") MultipartFile file) throws IOException {
        String lf_X2dvsPo5 = IOUtils.toString(file.getInputStream(), "utf-8");
        JSONObject lf_X2nkRmA2 = JSON.parseObject(lf_X2dvsPo5);
        List<ApiConfig> lf_mgnyUL9J = lf_X2nkRmA2.getJSONArray("api").toJavaList(ApiConfig.class);
        Integer lf_r8PY91ym = gf_KDuDr1Ld.m_ZP6H4YBP();
        if ((lf_r8PY91ym + lf_mgnyUL9J.size()) > SpecManager.getApiNum()) {
            throw new RuntimeException("The number of API exceeds the limit");
        }
        lf_mgnyUL9J.stream().forEach(lambda_lf_nfxzFPcs -> {
            lambda_lf_nfxzFPcs.setCreateUserId(C_9CYMzywH.m_PvlTFGSh());
            lambda_lf_nfxzFPcs.setCreateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
            lambda_lf_nfxzFPcs.setUpdateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
        });
        List<ApiPluginConfig> lf_8ftDeJn1 = lf_X2nkRmA2.getJSONArray("plugins").toJavaList(ApiPluginConfig.class);
        gf_KDuDr1Ld.m_3RXKKOal(lf_mgnyUL9J, lf_8ftDeJn1);
    }

    @RequestMapping(value = "/importGroup", produces = "application/json;charset=UTF-8")
    public void m_nVI9G9ku(@RequestParam("file") MultipartFile file) throws IOException {
        String lf_lYMNvNvn = IOUtils.toString(file.getInputStream(), "utf-8");
        List<Group> lf_ErJkWYkg = JSON.parseArray(lf_lYMNvNvn, Group.class);
        Integer lf_oHbr7PoH = gf_C3yHhNKe.m_xJ4buG4r();
        if ((lf_oHbr7PoH + lf_ErJkWYkg.size()) > SpecManager.getGroupNum()) {
            throw new RuntimeException("The number of groups exceeds the limit");
        }
        lf_ErJkWYkg.stream().forEach(lambda_lf_Q54kbSGq -> {
            lambda_lf_Q54kbSGq.setCreateUserId(C_9CYMzywH.m_PvlTFGSh());
            lambda_lf_Q54kbSGq.setCreateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
            lambda_lf_Q54kbSGq.setUpdateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
        });
        gf_C3yHhNKe.m_OhHaMrWR(lf_ErJkWYkg);
    }

    @RequestMapping("/sql/execute")
    public ResponseDto m_c8aI1dho(String datasourceId, String sql, String params) {
        DruidPooledConnection lf_UOamzilN = null;
        try {
            DataSource lf_LjD3wyxK = gf_XreQhihq.m_tck0gaQC(datasourceId);
            lf_UOamzilN = C_iYar35dl.m_p8mwaR3T(lf_LjD3wyxK);
            Map<String, Object> lf_Mzdvn3K5 = JSON.parseObject(params, Map.class);
            SqlMeta lf_koz5Sjjv = C_6ZmRqh3F.m_dzVvIA7n().parse(sql, lf_Mzdvn3K5);
            Object lf_ebRn9Tew = C_31nDdnvP.m_kNioAR0O(lf_UOamzilN, lf_koz5Sjjv.getSql(), lf_koz5Sjjv.getJdbcParamValues());
            return ResponseDto.successWithData(lf_ebRn9Tew);
        } catch (Exception e) {
            return ResponseDto.fail(e.getMessage());
        } finally {
            try {
                if (lf_UOamzilN != null)
                    lf_UOamzilN.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/parseDynamicSql")
    public ResponseDto m_OtbkQbuF(String sql, String params) {
        try {
            Map<String, Object> lf_pUn7Dkww = JSON.parseObject(params, Map.class);
            SqlMeta lf_jzv2Zqhe = C_6ZmRqh3F.m_dzVvIA7n().parse(sql, lf_pUn7Dkww);
            return ResponseDto.successWithData(lf_jzv2Zqhe);
        } catch (Exception e) {
            return ResponseDto.fail(e.getMessage());
        }
    }
}
