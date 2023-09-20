package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.service.C_YQ0bt7k7;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequestMapping("/system")
public class C_4RwgzirL {

    @Value("${version}")
    String gf_mKHA5xKM;

    @Value("${dbapi.mode}")
    String gf_O2RlgDdb;

    @Autowired
    C_YQ0bt7k7 gf_UG3Uniz2;

    @Value("${dbapi.api.context}")
    String gf_xQpD9GeH;

    @RequestMapping("/version")
    public String m_0vEpy8mc() {
        return gf_mKHA5xKM;
    }

    @RequestMapping("/mode")
    public String m_Jdanrc6E() {
        String lf_FfTbkrHk = System.getenv("DOCKER");
        if ("true".equals(lf_FfTbkrHk)) {
            return gf_O2RlgDdb + " in docker";
        } else {
            return gf_O2RlgDdb;
        }
    }

    @RequestMapping("/getIPPort")
    public String m_LwRP18bE(HttpServletRequest request) {
        if ("standalone".equals(gf_O2RlgDdb)) {
            return request.getServerName() + ":" + request.getServerPort() + "/" + gf_xQpD9GeH;
        } else if ("cluster".equals(gf_O2RlgDdb)) {
            return gf_UG3Uniz2.m_nhwK1Ul3() + "/" + gf_xQpD9GeH;
        } else {
            return null;
        }
    }

    @RequestMapping("/getIP")
    public String m_aYLVln1E(HttpServletRequest request) {
        if ("standalone".equals(gf_O2RlgDdb)) {
            return request.getServerName() + ":" + request.getServerPort();
        } else if ("cluster".equals(gf_O2RlgDdb)) {
            return gf_UG3Uniz2.m_nhwK1Ul3();
        } else {
            return null;
        }
    }
}
