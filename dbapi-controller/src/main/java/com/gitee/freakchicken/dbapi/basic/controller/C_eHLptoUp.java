package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.service.C_U2XcchGU;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequestMapping("/system")
public class C_eHLptoUp {

    @Value("${version}")
    String gf_MjHindEj;

    @Value("${dbapi.mode}")
    String gf_attr37dG;

    @Autowired
    C_U2XcchGU gf_T2aXTDyR;

    @Value("${dbapi.api.context}")
    String gf_1U3n01FS;

    @RequestMapping("/version")
    public String m_AUiRlS6g() {
        return gf_MjHindEj;
    }

    @RequestMapping("/mode")
    public String m_1hlcNJaO() {
        String lf_THYJ2aiw = System.getenv("DOCKER");
        if ("true".equals(lf_THYJ2aiw)) {
            return gf_attr37dG + " in docker";
        } else {
            return gf_attr37dG;
        }
    }

    @RequestMapping("/getIPPort")
    public String m_IahxhYF2(HttpServletRequest request) {
        if ("standalone".equals(gf_attr37dG)) {
            return request.getServerName() + ":" + request.getServerPort() + "/" + gf_1U3n01FS;
        } else if ("cluster".equals(gf_attr37dG)) {
            return gf_T2aXTDyR.m_HeR4EEry() + "/" + gf_1U3n01FS;
        } else {
            return null;
        }
    }

    @RequestMapping("/getIP")
    public String m_PaGLcjCz(HttpServletRequest request) {
        if ("standalone".equals(gf_attr37dG)) {
            return request.getServerName() + ":" + request.getServerPort();
        } else if ("cluster".equals(gf_attr37dG)) {
            return gf_T2aXTDyR.m_HeR4EEry();
        } else {
            return null;
        }
    }
}
