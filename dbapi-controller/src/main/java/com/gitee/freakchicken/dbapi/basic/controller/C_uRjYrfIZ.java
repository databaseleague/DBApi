package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gitee.freakchicken.dbapi.basic.domain.AccessLog;
import com.gitee.freakchicken.dbapi.basic.service.C_qDUqMLv1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/access")
public class C_uRjYrfIZ {

    @Autowired
    private C_qDUqMLv1 gf_tIzPE8fY;

    @RequestMapping("/all")
    public List<AccessLog> m_amjJJVTY() {
        List<AccessLog> lf_kqof4LFC = gf_tIzPE8fY.m_rF5V10kR();
        return lf_kqof4LFC;
    }

    @RequestMapping("/search")
    public List<AccessLog> m_emyC5yqb(String url, String clientId, Long start, Long end, Integer status, String ip) {
        return gf_tIzPE8fY.m_ZryL9UKY(url, clientId, start, end, status, ip);
    }

    @RequestMapping("/countByDay")
    public JSONArray m_KZpGGaB0(Long start, Long end) {
        return gf_tIzPE8fY.m_E2CnHtjm(start, end);
    }

    @RequestMapping("/top5api")
    public List<JSONObject> m_8nPOdIsb(long start, long end) {
        return gf_tIzPE8fY.m_3vWKTPw3(start, end);
    }

    @RequestMapping("/top5client")
    public List<JSONObject> m_AGGpHBVD(long start, long end) {
        return gf_tIzPE8fY.m_B0jJHTKo(start, end);
    }

    @RequestMapping("/topNIP")
    public List<JSONObject> m_ZJhBPAL2(long start, long end) {
        return gf_tIzPE8fY.m_YId1PbkS(start, end);
    }

    @RequestMapping("/top5duration")
    public List<JSONObject> m_AALZxoSa(long start, long end) {
        return gf_tIzPE8fY.m_tne04yf7(start, end);
    }

    @RequestMapping("/successRatio")
    public JSONObject m_jjv0kA8h(long start, long end) {
        return gf_tIzPE8fY.m_Cy6yibjK(start, end);
    }
}
