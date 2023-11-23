package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.service.C_hLFal6dr;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequestMapping("/system")
public class C_XNG742vs {

    @Value("${version}")
    String gf_2hbKmDU7;

    @Value("${dbapi.mode}")
    String gf_XNriPQ74;

    @Autowired
    C_hLFal6dr gf_I25Ow2DU;

    @Value("${dbapi.api.context}")
    String gf_T0EYs5SX;

    @RequestMapping("/version")
    public String m_zkTzcmtE() {
        return gf_2hbKmDU7;
    }

    @RequestMapping("/mode")
    public String m_RQYCzZvb() {
        String lf_yNP1gl83 = System.getenv("DOCKER");
        if ("true".equals(lf_yNP1gl83)) {
            return gf_XNriPQ74 + " in docker";
        } else {
            return gf_XNriPQ74;
        }
    }

    @RequestMapping("/getIPPort")
    public String m_IvgPSpFO(HttpServletRequest request) {
        if ("standalone".equals(gf_XNriPQ74)) {
            return request.getServerName() + ":" + request.getServerPort() + "/" + gf_T0EYs5SX;
        } else if ("cluster".equals(gf_XNriPQ74)) {
            return gf_I25Ow2DU.m_rzfrSdMn() + "/" + gf_T0EYs5SX;
        } else {
            return null;
        }
    }

    @RequestMapping("/getIP")
    public String m_r51ELDZN(HttpServletRequest request) {
        if ("standalone".equals(gf_XNriPQ74)) {
            return request.getServerName() + ":" + request.getServerPort();
        } else if ("cluster".equals(gf_XNriPQ74)) {
            return gf_I25Ow2DU.m_rzfrSdMn();
        } else {
            return null;
        }
    }
}
