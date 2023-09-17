package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gitee.freakchicken.dbapi.basic.domain.AccessLog;
import com.gitee.freakchicken.dbapi.basic.service.C_v39whaiK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/access")
public class C_hDAmjGDy {

    @Autowired
    private C_v39whaiK gf_Si7pfRxZ;

    @RequestMapping("/all")
    public List<AccessLog> m_XO9qBvhH() {
        List<AccessLog> lf_mjI6iGI8 = gf_Si7pfRxZ.m_uGSSDFzK();
        return lf_mjI6iGI8;
    }

    @RequestMapping("/search")
    public List<AccessLog> m_L0hu9KlC(String url, String clientId, Long start, Long end, Integer status, String ip) {
        return gf_Si7pfRxZ.m_G8iTZA2P(url, clientId, start, end, status, ip);
    }

    @RequestMapping("/countByDay")
    public JSONArray m_wMlraJoX(Long start, Long end) {
        return gf_Si7pfRxZ.m_XswfFuJT(start, end);
    }

    @RequestMapping("/top5api")
    public List<JSONObject> m_nZsszZvu(long start, long end) {
        return gf_Si7pfRxZ.m_wpKxiuyA(start, end);
    }

    @RequestMapping("/top5client")
    public List<JSONObject> m_ktpV8h0w(long start, long end) {
        return gf_Si7pfRxZ.m_PZNWkzeX(start, end);
    }

    @RequestMapping("/topNIP")
    public List<JSONObject> m_ytHGDGhb(long start, long end) {
        return gf_Si7pfRxZ.m_UtXE4bg4(start, end);
    }

    @RequestMapping("/top5duration")
    public List<JSONObject> m_juiNZtax(long start, long end) {
        return gf_Si7pfRxZ.m_jIj29y94(start, end);
    }

    @RequestMapping("/successRatio")
    public JSONObject m_0NDo9gq0(long start, long end) {
        return gf_Si7pfRxZ.m_AvKX8D4t(start, end);
    }
}
