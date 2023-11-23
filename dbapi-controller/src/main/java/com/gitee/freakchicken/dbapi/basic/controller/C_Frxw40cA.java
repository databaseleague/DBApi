package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gitee.freakchicken.dbapi.basic.domain.AccessLog;
import com.gitee.freakchicken.dbapi.basic.service.C_w5RdsxjI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/access")
public class C_Frxw40cA {

    @Autowired
    private C_w5RdsxjI gf_vxibMzEh;

    @RequestMapping("/all")
    public List<AccessLog> m_lmUBWfrM() {
        List<AccessLog> lf_SgnHH15l = gf_vxibMzEh.m_TtLmmiUx();
        return lf_SgnHH15l;
    }

    @RequestMapping("/search")
    public List<AccessLog> m_Zn0zj0n8(String url, String clientId, Long start, Long end, Integer status, String ip) {
        return gf_vxibMzEh.m_UKI1zPC3(url, clientId, start, end, status, ip);
    }

    @RequestMapping("/countByDay")
    public JSONArray m_JMjYgaAo(Long start, Long end) {
        return gf_vxibMzEh.m_rZW30PRv(start, end);
    }

    @RequestMapping("/top5api")
    public List<JSONObject> m_dvlffNgl(long start, long end) {
        return gf_vxibMzEh.m_JLD8tUBT(start, end);
    }

    @RequestMapping("/top5client")
    public List<JSONObject> m_pTnU6X9n(long start, long end) {
        return gf_vxibMzEh.m_yUThf9Fs(start, end);
    }

    @RequestMapping("/topNIP")
    public List<JSONObject> m_va3dWyiV(long start, long end) {
        return gf_vxibMzEh.m_ypkFPTDt(start, end);
    }

    @RequestMapping("/top5duration")
    public List<JSONObject> m_noSaih34(long start, long end) {
        return gf_vxibMzEh.m_Muq3dFOG(start, end);
    }

    @RequestMapping("/successRatio")
    public JSONObject m_asqVjt9Y(long start, long end) {
        return gf_vxibMzEh.m_nYqEddIx(start, end);
    }
}
