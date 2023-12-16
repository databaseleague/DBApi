package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gitee.freakchicken.dbapi.basic.domain.AccessLog;
import com.gitee.freakchicken.dbapi.basic.service.C_VweOL1nE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/access")
public class C_wbYkTLZG {

    @Autowired
    private C_VweOL1nE gf_5jAi25vL;

    @RequestMapping("/all")
    public List<AccessLog> m_U8Ix9zC7() {
        List<AccessLog> lf_0NRvWvI7 = gf_5jAi25vL.m_2tNt6T78();
        return lf_0NRvWvI7;
    }

    @RequestMapping("/search")
    public List<AccessLog> m_9Bh5OMVC(String url, String clientId, Long start, Long end, Integer status, String ip) {
        return gf_5jAi25vL.m_3Ywg3Pa0(url, clientId, start, end, status, ip);
    }

    @RequestMapping("/countByDay")
    public JSONArray m_hd3iZToK(Long start, Long end) {
        return gf_5jAi25vL.m_KRB9glgz(start, end);
    }

    @RequestMapping("/top5api")
    public List<JSONObject> m_iSt1uMD7(long start, long end) {
        return gf_5jAi25vL.m_l8yFav9V(start, end);
    }

    @RequestMapping("/top5client")
    public List<JSONObject> m_KFGORySA(long start, long end) {
        return gf_5jAi25vL.m_BqHOIIEu(start, end);
    }

    @RequestMapping("/topNIP")
    public List<JSONObject> m_z1moGO6J(long start, long end) {
        return gf_5jAi25vL.m_ULINPSPP(start, end);
    }

    @RequestMapping("/top5duration")
    public List<JSONObject> m_FdK1rhYv(long start, long end) {
        return gf_5jAi25vL.m_mkCOUBSV(start, end);
    }

    @RequestMapping("/successRatio")
    public JSONObject m_P4zSMmTk(long start, long end) {
        return gf_5jAi25vL.m_3b40WEVp(start, end);
    }
}
