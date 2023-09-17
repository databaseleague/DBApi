package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.service.C_ILLzv1ps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequestMapping("/system")
public class C_sVRbSEjR {

    @Value("${version}")
    String gf_9FArt2xw;

    @Value("${dbapi.mode}")
    String gf_jCBP2qSL;

    @Autowired
    C_ILLzv1ps gf_SX8ljkMU;

    @Value("${dbapi.api.context}")
    String gf_qxkz4hgX;

    @RequestMapping("/version")
    public String m_LGtcj9s2() {
        return gf_9FArt2xw;
    }

    @RequestMapping("/mode")
    public String m_tkw6puye() {
        String lf_BccdpVDZ = System.getenv("DOCKER");
        if ("true".equals(lf_BccdpVDZ)) {
            return gf_jCBP2qSL + " in docker";
        } else {
            return gf_jCBP2qSL;
        }
    }

    @RequestMapping("/getIPPort")
    public String m_bIlx34Oa(HttpServletRequest request) {
        if ("standalone".equals(gf_jCBP2qSL)) {
            return request.getServerName() + ":" + request.getServerPort() + "/" + gf_qxkz4hgX;
        } else if ("cluster".equals(gf_jCBP2qSL)) {
            return gf_SX8ljkMU.m_pliBDzKw() + "/" + gf_qxkz4hgX;
        } else {
            return null;
        }
    }

    @RequestMapping("/getIP")
    public String m_TYrAse2B(HttpServletRequest request) {
        if ("standalone".equals(gf_jCBP2qSL)) {
            return request.getServerName() + ":" + request.getServerPort();
        } else if ("cluster".equals(gf_jCBP2qSL)) {
            return gf_SX8ljkMU.m_pliBDzKw();
        } else {
            return null;
        }
    }
}
