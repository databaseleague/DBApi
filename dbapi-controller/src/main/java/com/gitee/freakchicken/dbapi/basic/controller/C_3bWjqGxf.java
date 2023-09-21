package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gitee.freakchicken.dbapi.basic.domain.AccessLog;
import com.gitee.freakchicken.dbapi.basic.service.C_zdcVaG0K;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/access")
public class C_3bWjqGxf {

    @Autowired
    private C_zdcVaG0K gf_kBf0CcZv;

    @RequestMapping("/all")
    public List<AccessLog> m_tEoCcQw7() {
        List<AccessLog> lf_oyKz1brg = gf_kBf0CcZv.m_MSn8MNL8();
        return lf_oyKz1brg;
    }

    @RequestMapping("/search")
    public List<AccessLog> m_lgcrRDQK(String url, String clientId, Long start, Long end, Integer status, String ip) {
        return gf_kBf0CcZv.m_UupwVhWo(url, clientId, start, end, status, ip);
    }

    @RequestMapping("/countByDay")
    public JSONArray m_eY231mRz(Long start, Long end) {
        return gf_kBf0CcZv.m_8HgEjYa2(start, end);
    }

    @RequestMapping("/top5api")
    public List<JSONObject> m_wh3bjY1d(long start, long end) {
        return gf_kBf0CcZv.m_SgIIp0z1(start, end);
    }

    @RequestMapping("/top5client")
    public List<JSONObject> m_BvNu6uqs(long start, long end) {
        return gf_kBf0CcZv.m_CtRGrw8R(start, end);
    }

    @RequestMapping("/topNIP")
    public List<JSONObject> m_CHru46bx(long start, long end) {
        return gf_kBf0CcZv.m_JmQFXUtt(start, end);
    }

    @RequestMapping("/top5duration")
    public List<JSONObject> m_AXdBYVKb(long start, long end) {
        return gf_kBf0CcZv.m_eF1eChax(start, end);
    }

    @RequestMapping("/successRatio")
    public JSONObject m_fzwzLpCE(long start, long end) {
        return gf_kBf0CcZv.m_vR6Q2u9I(start, end);
    }
}
