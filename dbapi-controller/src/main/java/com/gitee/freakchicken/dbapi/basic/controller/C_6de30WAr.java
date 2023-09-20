package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gitee.freakchicken.dbapi.basic.domain.AccessLog;
import com.gitee.freakchicken.dbapi.basic.service.C_eHAUh5yl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/access")
public class C_6de30WAr {

    @Autowired
    private C_eHAUh5yl gf_makro7MT;

    @RequestMapping("/all")
    public List<AccessLog> m_cTzh49nn() {
        List<AccessLog> lf_dwZ64zAA = gf_makro7MT.m_cd9zDocB();
        return lf_dwZ64zAA;
    }

    @RequestMapping("/search")
    public List<AccessLog> m_yvH48biu(String url, String clientId, Long start, Long end, Integer status, String ip) {
        return gf_makro7MT.m_TtgWgVdq(url, clientId, start, end, status, ip);
    }

    @RequestMapping("/countByDay")
    public JSONArray m_7f17YCrQ(Long start, Long end) {
        return gf_makro7MT.m_8sltwtwo(start, end);
    }

    @RequestMapping("/top5api")
    public List<JSONObject> m_gehfOlVB(long start, long end) {
        return gf_makro7MT.m_YDjureR3(start, end);
    }

    @RequestMapping("/top5client")
    public List<JSONObject> m_v0Ka1OKs(long start, long end) {
        return gf_makro7MT.m_Ne2sr81w(start, end);
    }

    @RequestMapping("/topNIP")
    public List<JSONObject> m_DLashcD0(long start, long end) {
        return gf_makro7MT.m_im0TkVRs(start, end);
    }

    @RequestMapping("/top5duration")
    public List<JSONObject> m_TfTl2mgv(long start, long end) {
        return gf_makro7MT.m_9c9cvRmQ(start, end);
    }

    @RequestMapping("/successRatio")
    public JSONObject m_9T8q2NLm(long start, long end) {
        return gf_makro7MT.m_CE3CVZ7H(start, end);
    }
}
