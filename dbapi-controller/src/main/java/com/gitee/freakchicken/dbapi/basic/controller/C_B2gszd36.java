package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.service.C_7LFtD2JY;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequestMapping("/system")
public class C_B2gszd36 {

    @Value("${version}")
    String gf_sOWwJypf;

    @Value("${dbapi.mode}")
    String gf_3kXv5al9;

    @Autowired
    C_7LFtD2JY gf_KhHKDsFh;

    @Value("${dbapi.api.context}")
    String gf_ECVBZk5J;

    @RequestMapping("/version")
    public String m_SaohYk7f() {
        return gf_sOWwJypf;
    }

    @RequestMapping("/mode")
    public String m_h5disT00() {
        String lf_tyYXiByb = System.getenv("DOCKER");
        if ("true".equals(lf_tyYXiByb)) {
            return gf_3kXv5al9 + " in docker";
        } else {
            return gf_3kXv5al9;
        }
    }

    @RequestMapping("/getIPPort")
    public String m_qPWfsT1H(HttpServletRequest request) {
        if ("standalone".equals(gf_3kXv5al9)) {
            return request.getServerName() + ":" + request.getServerPort() + "/" + gf_ECVBZk5J;
        } else if ("cluster".equals(gf_3kXv5al9)) {
            return gf_KhHKDsFh.m_43PTQFDD() + "/" + gf_ECVBZk5J;
        } else {
            return null;
        }
    }

    @RequestMapping("/getIP")
    public String m_KQHg5Dm6(HttpServletRequest request) {
        if ("standalone".equals(gf_3kXv5al9)) {
            return request.getServerName() + ":" + request.getServerPort();
        } else if ("cluster".equals(gf_3kXv5al9)) {
            return gf_KhHKDsFh.m_43PTQFDD();
        } else {
            return null;
        }
    }
}
