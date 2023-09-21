package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.dbapi.C_yQrjZepH;
import com.gitee.freakchicken.dbapi.basic.domain.DataSource;
import com.gitee.freakchicken.dbapi.basic.domain.Group;
import com.gitee.freakchicken.dbapi.basic.service.C_GeJ3dmE4;
import com.gitee.freakchicken.dbapi.basic.service.C_2SJy2rJ0;
import com.gitee.freakchicken.dbapi.basic.service.C_TztqB8u3;
import com.gitee.freakchicken.dbapi.basic.util.Constants;
import com.gitee.freakchicken.dbapi.basic.util.C_8uPcuzJY;
import com.gitee.freakchicken.dbapi.basic.util.C_JJ03WwEB;
import com.gitee.freakchicken.dbapi.basic.util.C_ZF8XcT9C;
import com.gitee.freakchicken.dbapi.basic.util.C_idPcCdpc;
import com.gitee.freakchicken.dbapi.basic.util.C_8qljnQAP;
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
public class C_0V7Hdb3c {

    @Value("${dbapi.mode}")
    String gf_jWHX5VBC;

    @Autowired
    C_GeJ3dmE4 gf_XKqjgk8O;

    @Autowired
    C_2SJy2rJ0 gf_aM8UVjL4;

    @Autowired
    C_TztqB8u3 gf_X5pyPLTo;

    @Value("${dbapi.api.context}")
    String gf_Nsup0vOo;

    @RequestMapping("/context")
    public String m_zHrr5WcN() {
        return gf_Nsup0vOo;
    }

    @RequestMapping("/add")
    public ResponseDto m_VXE8ANML(@RequestBody JSONObject jo) {
        ApiConfig lf_gDbkV6O4 = new ApiConfig();
        lf_gDbkV6O4.setName(jo.getString("name"));
        lf_gDbkV6O4.setPath(jo.getString("path"));
        lf_gDbkV6O4.setNote(jo.getString("note"));
        lf_gDbkV6O4.setGroupId(jo.getString("groupId"));
        lf_gDbkV6O4.setContentType(jo.getString("contentType"));
        lf_gDbkV6O4.setJsonParam(jo.getString("jsonParam"));
        lf_gDbkV6O4.setParams(jo.getJSONArray("paramsJson").toString(SerializerFeature.WriteMapNullValue));
        lf_gDbkV6O4.setAccess(jo.getInteger("access"));
        lf_gDbkV6O4.setTask(jo.getJSONArray("taskJson").toString(SerializerFeature.WriteMapNullValue));
        lf_gDbkV6O4.setStatus(Constants.API_STATUS_OFFLINE);
        String lf_wS21zi4r = C_8qljnQAP.m_DZd6FZFQ();
        lf_gDbkV6O4.setId(lf_wS21zi4r);
        lf_gDbkV6O4.setCreateUserId(C_idPcCdpc.m_CpasizWZ());
        JSONArray lf_RzDNQ27b = jo.getJSONArray("alarmPlugins");
        lf_RzDNQ27b.add(jo.getJSONObject("cachePlugin"));
        lf_RzDNQ27b.add(jo.getJSONObject("globalTransformPlugin"));
        List<ApiPluginConfig> lf_FQyZOvwg = lf_RzDNQ27b.toJavaList(ApiPluginConfig.class);
        List<ApiPluginConfig> lf_vMj3fMnm = lf_FQyZOvwg.stream().filter(lambda_lf_Oi5CnKOR -> lambda_lf_Oi5CnKOR != null && StringUtils.isNotEmpty(lambda_lf_Oi5CnKOR.getPluginName())).collect(Collectors.toList());
        lf_vMj3fMnm.forEach(lambda_lf_7CaJsMgm -> lambda_lf_7CaJsMgm.setApiId(lf_wS21zi4r));
        return gf_XKqjgk8O.m_PrGdCoqL(lf_gDbkV6O4, lf_vMj3fMnm);
    }

    @Deprecated
    @RequestMapping("/parseParam")
    public ResponseDto m_t4gspo51(String sql) {
        try {
            Set<String> lf_WEYi0aW1 = C_ZF8XcT9C.m_tgCQiPFD().parseParameter(sql);
            List<JSONObject> lf_GG6AZpe7 = lf_WEYi0aW1.stream().map(lambda_lf_yMkpcWWu -> {
                JSONObject lf_4vl3bKvb = new JSONObject();
                lf_4vl3bKvb.put("value", lambda_lf_yMkpcWWu);
                return lf_4vl3bKvb;
            }).collect(Collectors.toList());
            return ResponseDto.successWithData(lf_GG6AZpe7);
        } catch (Exception e) {
            return ResponseDto.fail(e.getMessage());
        }
    }

    @RequestMapping("/getAll")
    public List<ApiConfig> m_gpeX1iMB() {
        return gf_XKqjgk8O.m_76erVhMs();
    }

    @RequestMapping("/getApiTree")
    public List<JSONObject> m_p4qm8S7w() {
        return gf_XKqjgk8O.m_XMq9FGJX();
    }

    @RequestMapping("/search")
    public List<ApiConfig> m_p3rU0Lmy(String name, String note, String path, String groupId) {
        return gf_XKqjgk8O.m_AkIoh1xm(name, note, path, groupId);
    }

    @RequestMapping("/detail/{id}")
    public ApiConfig m_zZKib5V4(@PathVariable String id) {
        return gf_XKqjgk8O.m_16ErWpHn(id);
    }

    @RequestMapping("/delete/{id}")
    public void m_1FHUdQxS(@PathVariable String id) {
        gf_XKqjgk8O.m_vlmriFEt(id);
    }

    @RequestMapping("/update")
    public ResponseDto m_fLh9Ki3Z(@RequestBody JSONObject jo) {
        ApiConfig lf_k8cRkaO8 = new ApiConfig();
        lf_k8cRkaO8.setId(jo.getString("id"));
        lf_k8cRkaO8.setName(jo.getString("name"));
        lf_k8cRkaO8.setPath(jo.getString("path"));
        lf_k8cRkaO8.setNote(jo.getString("note"));
        lf_k8cRkaO8.setGroupId(jo.getString("groupId"));
        lf_k8cRkaO8.setContentType(jo.getString("contentType"));
        lf_k8cRkaO8.setJsonParam(jo.getString("jsonParam"));
        lf_k8cRkaO8.setParams(jo.getJSONArray("paramsJson").toString(SerializerFeature.WriteMapNullValue));
        lf_k8cRkaO8.setAccess(jo.getInteger("access"));
        lf_k8cRkaO8.setTask(jo.getJSONArray("taskJson").toString(SerializerFeature.WriteMapNullValue));
        lf_k8cRkaO8.setStatus(Constants.API_STATUS_OFFLINE);
        JSONArray lf_PnQ3D31s = jo.getJSONArray("alarmPlugins");
        lf_PnQ3D31s.add(jo.getJSONObject("cachePlugin"));
        lf_PnQ3D31s.add(jo.getJSONObject("globalTransformPlugin"));
        List<ApiPluginConfig> lf_UnlJWVjL = lf_PnQ3D31s.toJavaList(ApiPluginConfig.class);
        List<ApiPluginConfig> lf_bszUwBKg = lf_UnlJWVjL.stream().filter(lambda_lf_JLwwCCtG -> lambda_lf_JLwwCCtG != null && StringUtils.isNotEmpty(lambda_lf_JLwwCCtG.getPluginName())).collect(Collectors.toList());
        return gf_XKqjgk8O.m_Zvlour7G(lf_k8cRkaO8, lf_bszUwBKg);
    }

    @RequestMapping("/online/{id}")
    public void m_n5ZaWhOg(@PathVariable String id) {
        gf_XKqjgk8O.m_3wTt0ewf(id);
    }

    @RequestMapping("/offline/{id}")
    public void m_04KBCX6w(@PathVariable String id) {
        gf_XKqjgk8O.m_VRxQnIco(id);
    }

    @RequestMapping("/apiDocs")
    public void m_k3KE1Ny7(String ids, HttpServletResponse response) {
        List<String> lf_tiIjJ0RK = Arrays.asList(ids.split(","));
        String lf_nXLujkIT = gf_XKqjgk8O.m_pWw0iQZu(lf_tiIjJ0RK);
        response.setContentType("application/x-msdownload;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=API docs.md");
        OutputStream lf_bKoJoBsP = null;
        try {
            lf_bKoJoBsP = response.getOutputStream();
            lf_bKoJoBsP.write(lf_nXLujkIT.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lf_bKoJoBsP != null)
                    lf_bKoJoBsP.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/downloadConfig")
    public void m_yViboo2h(String ids, HttpServletResponse response) {
        List<String> lf_XRhbnmJN = Arrays.asList(ids.split(","));
        JSONObject lf_BvpdNlGJ = gf_XKqjgk8O.m_a7zMiAHO(lf_XRhbnmJN);
        String lf_8VHT7EPJ = lf_BvpdNlGJ.toString(SerializerFeature.WriteMapNullValue);
        response.setContentType("application/x-msdownload;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=api_config.json");
        OutputStream lf_H7CYVSd1 = null;
        try {
            lf_H7CYVSd1 = response.getOutputStream();
            lf_H7CYVSd1.write(lf_8VHT7EPJ.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lf_H7CYVSd1 != null)
                    lf_H7CYVSd1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/downloadGroupConfig")
    public void m_faOIg6Bn(String ids, HttpServletResponse response) {
        List<String> lf_KyPG5kOw = Arrays.asList(ids.split(","));
        List<Group> lf_6ggNCNIU = gf_X5pyPLTo.m_tmSFULNE(lf_KyPG5kOw);
        String lf_gxtKZw1i = JSON.toJSONString(lf_6ggNCNIU);
        response.setContentType("application/x-msdownload;charset=utf-8");
        OutputStream lf_I0RukWpZ = null;
        try {
            lf_I0RukWpZ = response.getOutputStream();
            lf_I0RukWpZ.write(lf_gxtKZw1i.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lf_I0RukWpZ != null)
                    lf_I0RukWpZ.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/import", produces = "application/json;charset=UTF-8")
    public void m_urcMvsAC(@RequestParam("file") MultipartFile file) throws IOException {
        String lf_QhNryEyA = IOUtils.toString(file.getInputStream(), "utf-8");
        JSONObject lf_CSiHjqog = JSON.parseObject(lf_QhNryEyA);
        List<ApiConfig> lf_UAngtgJo = lf_CSiHjqog.getJSONArray("api").toJavaList(ApiConfig.class);
        Integer lf_835sRdz1 = gf_XKqjgk8O.m_GXcQOyXj();
        if ((lf_835sRdz1 + lf_UAngtgJo.size()) > C_yQrjZepH.m_G2azbgdf()) {
            throw new RuntimeException("The number of API exceeds the limit");
        }
        lf_UAngtgJo.stream().forEach(lambda_lf_rT0ZRi68 -> {
            lambda_lf_rT0ZRi68.setCreateUserId(C_idPcCdpc.m_CpasizWZ());
            lambda_lf_rT0ZRi68.setCreateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
            lambda_lf_rT0ZRi68.setUpdateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
        });
        List<ApiPluginConfig> lf_6jtVV2AK = lf_CSiHjqog.getJSONArray("plugins").toJavaList(ApiPluginConfig.class);
        gf_XKqjgk8O.m_EqSQMz5P(lf_UAngtgJo, lf_6jtVV2AK);
    }

    @RequestMapping(value = "/importGroup", produces = "application/json;charset=UTF-8")
    public void m_oZJltJ2b(@RequestParam("file") MultipartFile file) throws IOException {
        String lf_CboxRRfH = IOUtils.toString(file.getInputStream(), "utf-8");
        List<Group> lf_JSWpfAds = JSON.parseArray(lf_CboxRRfH, Group.class);
        Integer lf_O68fVK2j = gf_X5pyPLTo.m_ND4n2hCM();
        if ((lf_O68fVK2j + lf_JSWpfAds.size()) > C_yQrjZepH.m_8e6D8B1a()) {
            throw new RuntimeException("The number of groups exceeds the limit");
        }
        lf_JSWpfAds.stream().forEach(lambda_lf_zDP1gFK3 -> {
            lambda_lf_zDP1gFK3.setCreateUserId(C_idPcCdpc.m_CpasizWZ());
            lambda_lf_zDP1gFK3.setCreateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
            lambda_lf_zDP1gFK3.setUpdateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
        });
        gf_X5pyPLTo.m_f79VJqbk(lf_JSWpfAds);
    }

    @RequestMapping("/sql/execute")
    public ResponseDto m_f5ou6kYV(String datasourceId, String sql, String params) {
        DruidPooledConnection lf_alhFMMkl = null;
        try {
            DataSource lf_BGf7MRIj = gf_aM8UVjL4.m_qMS1GA0c(datasourceId);
            lf_alhFMMkl = C_JJ03WwEB.m_ezk725ad(lf_BGf7MRIj);
            Map<String, Object> lf_0BnC8DES = JSON.parseObject(params, Map.class);
            SqlMeta lf_F6fIWtzg = C_ZF8XcT9C.m_tgCQiPFD().parse(sql, lf_0BnC8DES);
            Object lf_sTfd77j3 = C_8uPcuzJY.m_sy3p8GYv(lf_alhFMMkl, lf_F6fIWtzg.getSql(), lf_F6fIWtzg.getJdbcParamValues());
            return ResponseDto.successWithData(lf_sTfd77j3);
        } catch (Exception e) {
            return ResponseDto.fail(e.getMessage());
        } finally {
            try {
                if (lf_alhFMMkl != null)
                    lf_alhFMMkl.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/parseDynamicSql")
    public ResponseDto m_VCDAiBaI(String sql, String params) {
        try {
            Map<String, Object> lf_pLz6RVS2 = JSON.parseObject(params, Map.class);
            SqlMeta lf_63utFLOf = C_ZF8XcT9C.m_tgCQiPFD().parse(sql, lf_pLz6RVS2);
            return ResponseDto.successWithData(lf_63utFLOf);
        } catch (Exception e) {
            return ResponseDto.fail(e.getMessage());
        }
    }
}
