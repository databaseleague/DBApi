package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.dbapi.C_dQG4lXSP;
import com.gitee.freakchicken.dbapi.basic.domain.DataSource;
import com.gitee.freakchicken.dbapi.basic.domain.Group;
import com.gitee.freakchicken.dbapi.basic.service.C_Oocj4pSC;
import com.gitee.freakchicken.dbapi.basic.service.C_FHj5xs4w;
import com.gitee.freakchicken.dbapi.basic.service.C_6NvESxQY;
import com.gitee.freakchicken.dbapi.basic.util.Constants;
import com.gitee.freakchicken.dbapi.basic.util.C_zAYV4Q2c;
import com.gitee.freakchicken.dbapi.basic.util.C_Brw65PMK;
import com.gitee.freakchicken.dbapi.basic.util.C_npxw9W8i;
import com.gitee.freakchicken.dbapi.basic.util.C_oagmA7fO;
import com.gitee.freakchicken.dbapi.basic.util.C_TnYY0cK9;
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
public class C_LqTPYp3w {

    @Value("${dbapi.mode}")
    String gf_avOJej0b;

    @Autowired
    C_Oocj4pSC gf_hGp0NiIT;

    @Autowired
    C_FHj5xs4w gf_51etN91J;

    @Autowired
    C_6NvESxQY gf_OBPnAPK5;

    @Value("${dbapi.api.context}")
    String gf_vV5Uy1UU;

    @RequestMapping("/context")
    public String m_5FKqKO4Y() {
        return gf_vV5Uy1UU;
    }

    @RequestMapping("/add")
    public ResponseDto m_VNg0isY8(@RequestBody JSONObject jo) {
        ApiConfig lf_q7QGLReP = new ApiConfig();
        lf_q7QGLReP.setName(jo.getString("name"));
        lf_q7QGLReP.setPath(jo.getString("path"));
        lf_q7QGLReP.setNote(jo.getString("note"));
        lf_q7QGLReP.setGroupId(jo.getString("groupId"));
        lf_q7QGLReP.setContentType(jo.getString("contentType"));
        lf_q7QGLReP.setJsonParam(jo.getString("jsonParam"));
        lf_q7QGLReP.setParams(jo.getJSONArray("paramsJson").toString(SerializerFeature.WriteMapNullValue));
        lf_q7QGLReP.setAccess(jo.getInteger("access"));
        lf_q7QGLReP.setTask(jo.getJSONArray("taskJson").toString(SerializerFeature.WriteMapNullValue));
        lf_q7QGLReP.setStatus(Constants.API_STATUS_OFFLINE);
        String lf_OIS2rPE3 = C_TnYY0cK9.m_PmvWHWQo();
        lf_q7QGLReP.setId(lf_OIS2rPE3);
        lf_q7QGLReP.setCreateUserId(C_oagmA7fO.m_RXdK6OuW());
        JSONArray lf_MAOrC2LA = jo.getJSONArray("alarmPlugins");
        lf_MAOrC2LA.add(jo.getJSONObject("cachePlugin"));
        lf_MAOrC2LA.add(jo.getJSONObject("globalTransformPlugin"));
        List<ApiPluginConfig> lf_LB5h4MOB = lf_MAOrC2LA.toJavaList(ApiPluginConfig.class);
        List<ApiPluginConfig> lf_jxPNfqWW = lf_LB5h4MOB.stream().filter(lambda_lf_NNwIOmR1 -> lambda_lf_NNwIOmR1 != null && StringUtils.isNotEmpty(lambda_lf_NNwIOmR1.getPluginName())).collect(Collectors.toList());
        lf_jxPNfqWW.forEach(lambda_lf_oDU2pq8s -> lambda_lf_oDU2pq8s.setApiId(lf_OIS2rPE3));
        return gf_hGp0NiIT.m_rVvk9sGo(lf_q7QGLReP, lf_jxPNfqWW);
    }

    @Deprecated
    @RequestMapping("/parseParam")
    public ResponseDto m_yrdpEoqZ(String sql) {
        try {
            Set<String> lf_z9IdzmBZ = C_npxw9W8i.m_9aHoEQju().parseParameter(sql);
            List<JSONObject> lf_TUvIpcRw = lf_z9IdzmBZ.stream().map(lambda_lf_qsKGzbUa -> {
                JSONObject lf_DQF4ZLsP = new JSONObject();
                lf_DQF4ZLsP.put("value", lambda_lf_qsKGzbUa);
                return lf_DQF4ZLsP;
            }).collect(Collectors.toList());
            return ResponseDto.successWithData(lf_TUvIpcRw);
        } catch (Exception e) {
            return ResponseDto.fail(e.getMessage());
        }
    }

    @RequestMapping("/getAll")
    public List<ApiConfig> m_loH45rOG() {
        return gf_hGp0NiIT.m_lbBZMHhh();
    }

    @RequestMapping("/getApiTree")
    public List<JSONObject> m_O0yliVIU() {
        return gf_hGp0NiIT.m_LIOO5pva();
    }

    @RequestMapping("/search")
    public List<ApiConfig> m_kKOZupGd(String name, String note, String path, String groupId) {
        return gf_hGp0NiIT.m_4OKtzIV7(name, note, path, groupId);
    }

    @RequestMapping("/detail/{id}")
    public ApiConfig m_63JPIN7A(@PathVariable String id) {
        return gf_hGp0NiIT.m_kPIiJNrm(id);
    }

    @RequestMapping("/delete/{id}")
    public void m_oilXUwql(@PathVariable String id) {
        gf_hGp0NiIT.m_ZkR77dfB(id);
    }

    @RequestMapping("/update")
    public ResponseDto m_m8Ob4c2d(@RequestBody JSONObject jo) {
        ApiConfig lf_65lyyn4v = new ApiConfig();
        lf_65lyyn4v.setId(jo.getString("id"));
        lf_65lyyn4v.setName(jo.getString("name"));
        lf_65lyyn4v.setPath(jo.getString("path"));
        lf_65lyyn4v.setNote(jo.getString("note"));
        lf_65lyyn4v.setGroupId(jo.getString("groupId"));
        lf_65lyyn4v.setContentType(jo.getString("contentType"));
        lf_65lyyn4v.setJsonParam(jo.getString("jsonParam"));
        lf_65lyyn4v.setParams(jo.getJSONArray("paramsJson").toString(SerializerFeature.WriteMapNullValue));
        lf_65lyyn4v.setAccess(jo.getInteger("access"));
        lf_65lyyn4v.setTask(jo.getJSONArray("taskJson").toString(SerializerFeature.WriteMapNullValue));
        lf_65lyyn4v.setStatus(Constants.API_STATUS_OFFLINE);
        JSONArray lf_EMhaxWAr = jo.getJSONArray("alarmPlugins");
        lf_EMhaxWAr.add(jo.getJSONObject("cachePlugin"));
        lf_EMhaxWAr.add(jo.getJSONObject("globalTransformPlugin"));
        List<ApiPluginConfig> lf_KaB50DJF = lf_EMhaxWAr.toJavaList(ApiPluginConfig.class);
        List<ApiPluginConfig> lf_hE6Pp1E7 = lf_KaB50DJF.stream().filter(lambda_lf_M5LmtdKA -> lambda_lf_M5LmtdKA != null && StringUtils.isNotEmpty(lambda_lf_M5LmtdKA.getPluginName())).collect(Collectors.toList());
        return gf_hGp0NiIT.m_qB3QSCxB(lf_65lyyn4v, lf_hE6Pp1E7);
    }

    @RequestMapping("/online/{id}")
    public void m_i09tn0lP(@PathVariable String id) {
        gf_hGp0NiIT.m_5iXPcWpM(id);
    }

    @RequestMapping("/offline/{id}")
    public void m_fVja7l3n(@PathVariable String id) {
        gf_hGp0NiIT.m_OKyEY08F(id);
    }

    @RequestMapping("/apiDocs")
    public void m_dIpeuIC4(String ids, HttpServletResponse response) {
        List<String> lf_GkrSHMQr = Arrays.asList(ids.split(","));
        String lf_K9g1QDJ4 = gf_hGp0NiIT.m_59Hpag5y(lf_GkrSHMQr);
        response.setContentType("application/x-msdownload;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=API docs.md");
        OutputStream lf_93IDNptQ = null;
        try {
            lf_93IDNptQ = response.getOutputStream();
            lf_93IDNptQ.write(lf_K9g1QDJ4.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lf_93IDNptQ != null)
                    lf_93IDNptQ.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/downloadConfig")
    public void m_b7kpvudq(String ids, HttpServletResponse response) {
        List<String> lf_VvNbMo5T = Arrays.asList(ids.split(","));
        JSONObject lf_pDxhqini = gf_hGp0NiIT.m_Z82pynTJ(lf_VvNbMo5T);
        String lf_dxTUBD9q = lf_pDxhqini.toString(SerializerFeature.WriteMapNullValue);
        response.setContentType("application/x-msdownload;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=api_config.json");
        OutputStream lf_qaWJxnN4 = null;
        try {
            lf_qaWJxnN4 = response.getOutputStream();
            lf_qaWJxnN4.write(lf_dxTUBD9q.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lf_qaWJxnN4 != null)
                    lf_qaWJxnN4.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/downloadGroupConfig")
    public void m_5EMhXpFP(String ids, HttpServletResponse response) {
        List<String> lf_tZ0Fvl4Q = Arrays.asList(ids.split(","));
        List<Group> lf_kGJiKq0c = gf_OBPnAPK5.m_PRqAzFwg(lf_tZ0Fvl4Q);
        String lf_fGs5gF3E = JSON.toJSONString(lf_kGJiKq0c);
        response.setContentType("application/x-msdownload;charset=utf-8");
        OutputStream lf_ZVXtshUa = null;
        try {
            lf_ZVXtshUa = response.getOutputStream();
            lf_ZVXtshUa.write(lf_fGs5gF3E.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lf_ZVXtshUa != null)
                    lf_ZVXtshUa.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/import", produces = "application/json;charset=UTF-8")
    public void m_5jLQnPFu(@RequestParam("file") MultipartFile file) throws IOException {
        String lf_azqmM7gV = IOUtils.toString(file.getInputStream(), "utf-8");
        JSONObject lf_RNdizOBX = JSON.parseObject(lf_azqmM7gV);
        List<ApiConfig> lf_xDqXMKWS = lf_RNdizOBX.getJSONArray("api").toJavaList(ApiConfig.class);
        Integer lf_NS3HAKPH = gf_hGp0NiIT.m_xmsaKViG();
        if ((lf_NS3HAKPH + lf_xDqXMKWS.size()) > C_dQG4lXSP.m_a3lCmeR1()) {
            throw new RuntimeException("The number of API exceeds the limit");
        }
        lf_xDqXMKWS.stream().forEach(lambda_lf_smpaosUM -> {
            lambda_lf_smpaosUM.setCreateUserId(C_oagmA7fO.m_RXdK6OuW());
            lambda_lf_smpaosUM.setCreateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
            lambda_lf_smpaosUM.setUpdateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
        });
        List<ApiPluginConfig> lf_bHuJLQ8E = lf_RNdizOBX.getJSONArray("plugins").toJavaList(ApiPluginConfig.class);
        gf_hGp0NiIT.m_9gdi0Juc(lf_xDqXMKWS, lf_bHuJLQ8E);
    }

    @RequestMapping(value = "/importGroup", produces = "application/json;charset=UTF-8")
    public void m_i1yPMyP2(@RequestParam("file") MultipartFile file) throws IOException {
        String lf_1JbSpw6O = IOUtils.toString(file.getInputStream(), "utf-8");
        List<Group> lf_wTi09rH3 = JSON.parseArray(lf_1JbSpw6O, Group.class);
        Integer lf_Trjf9gsY = gf_OBPnAPK5.m_ctmE9FZH();
        if ((lf_Trjf9gsY + lf_wTi09rH3.size()) > C_dQG4lXSP.m_71XFXcNk()) {
            throw new RuntimeException("The number of groups exceeds the limit");
        }
        lf_wTi09rH3.stream().forEach(lambda_lf_dlU3t4Kn -> {
            lambda_lf_dlU3t4Kn.setCreateUserId(C_oagmA7fO.m_RXdK6OuW());
            lambda_lf_dlU3t4Kn.setCreateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
            lambda_lf_dlU3t4Kn.setUpdateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
        });
        gf_OBPnAPK5.m_HwR196qB(lf_wTi09rH3);
    }

    @RequestMapping("/sql/execute")
    public ResponseDto m_ubVptfSL(String datasourceId, String sql, String params) {
        DruidPooledConnection lf_UX2AIqfc = null;
        try {
            DataSource lf_6hrjlaAx = gf_51etN91J.m_4QfMOutT(datasourceId);
            lf_UX2AIqfc = C_Brw65PMK.m_KgAFIOMX(lf_6hrjlaAx);
            Map<String, Object> lf_REtbuzJy = JSON.parseObject(params, Map.class);
            SqlMeta lf_crrrhX7l = C_npxw9W8i.m_9aHoEQju().parse(sql, lf_REtbuzJy);
            Object lf_QOqwLLyg = C_zAYV4Q2c.m_CIkzTEx0(lf_UX2AIqfc, lf_crrrhX7l.getSql(), lf_crrrhX7l.getJdbcParamValues());
            return ResponseDto.successWithData(lf_QOqwLLyg);
        } catch (Exception e) {
            return ResponseDto.fail(e.getMessage());
        } finally {
            try {
                if (lf_UX2AIqfc != null)
                    lf_UX2AIqfc.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/parseDynamicSql")
    public ResponseDto m_g0MDfQTK(String sql, String params) {
        try {
            Map<String, Object> lf_Yq4Rg6hM = JSON.parseObject(params, Map.class);
            SqlMeta lf_Gur36PKz = C_npxw9W8i.m_9aHoEQju().parse(sql, lf_Yq4Rg6hM);
            return ResponseDto.successWithData(lf_Gur36PKz);
        } catch (Exception e) {
            return ResponseDto.fail(e.getMessage());
        }
    }
}
