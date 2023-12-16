package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.service.C_4P5ij5mf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequestMapping("/system")
public class C_VGf5cdVr {

    @Value("${version}")
    String gf_vfiOeROx;

    @Value("${dbapi.mode}")
    String gf_6LVY9pQJ;

    @Autowired
    C_4P5ij5mf gf_FPMz8i3m;

    @Value("${dbapi.api.context}")
    String gf_pQQVwFOm;

    @RequestMapping("/version")
    public String m_lQyL0vew() {
        return gf_vfiOeROx;
    }

    @RequestMapping("/mode")
    public String m_Oy17sPuL() {
        String lf_JG3HX8gD = System.getenv("DOCKER");
        if ("true".equals(lf_JG3HX8gD)) {
            return gf_6LVY9pQJ + " in docker";
        } else {
            return gf_6LVY9pQJ;
        }
    }

    @RequestMapping("/getIPPort")
    public String m_q3nCpkch(HttpServletRequest request) {
        if ("standalone".equals(gf_6LVY9pQJ)) {
            return request.getServerName() + ":" + request.getServerPort() + "/" + gf_pQQVwFOm;
        } else if ("cluster".equals(gf_6LVY9pQJ)) {
            return gf_FPMz8i3m.m_mgmE7iRT() + "/" + gf_pQQVwFOm;
        } else {
            return null;
        }
    }

    @RequestMapping("/getIP")
    public String m_D0cWmRvF(HttpServletRequest request) {
        if ("standalone".equals(gf_6LVY9pQJ)) {
            return request.getServerName() + ":" + request.getServerPort();
        } else if ("cluster".equals(gf_6LVY9pQJ)) {
            return gf_FPMz8i3m.m_mgmE7iRT();
        } else {
            return null;
        }
    }
}
