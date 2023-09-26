package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gitee.freakchicken.dbapi.basic.domain.AccessLog;
import com.gitee.freakchicken.dbapi.basic.service.C_bNfxKyHw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/access")
public class C_CEriA5bo {

    @Autowired
    private C_bNfxKyHw gf_oHksGNWv;

    @RequestMapping("/all")
    public List<AccessLog> m_SPpERx3J() {
        List<AccessLog> lf_2BiFF2kH = gf_oHksGNWv.m_jiu8J1fT();
        return lf_2BiFF2kH;
    }

    @RequestMapping("/search")
    public List<AccessLog> m_lVqSlUNO(String url, String clientId, Long start, Long end, Integer status, String ip) {
        return gf_oHksGNWv.m_FgvkuKIU(url, clientId, start, end, status, ip);
    }

    @RequestMapping("/countByDay")
    public JSONArray m_EfAjHhqP(Long start, Long end) {
        return gf_oHksGNWv.m_O7uEV3nS(start, end);
    }

    @RequestMapping("/top5api")
    public List<JSONObject> m_dJ47jepE(long start, long end) {
        return gf_oHksGNWv.m_TkWpJTAA(start, end);
    }

    @RequestMapping("/top5client")
    public List<JSONObject> m_x3bL8uLr(long start, long end) {
        return gf_oHksGNWv.m_J55nSGry(start, end);
    }

    @RequestMapping("/topNIP")
    public List<JSONObject> m_tpj4z47d(long start, long end) {
        return gf_oHksGNWv.m_6BF6b0R4(start, end);
    }

    @RequestMapping("/top5duration")
    public List<JSONObject> m_HLH3bjJf(long start, long end) {
        return gf_oHksGNWv.m_K0rjlOSM(start, end);
    }

    @RequestMapping("/successRatio")
    public JSONObject m_eiV9MM0A(long start, long end) {
        return gf_oHksGNWv.m_lexhRhyu(start, end);
    }
}
