package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.service.C_nzGlHcnH;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequestMapping("/system")
public class C_Yin3yd8O {

    @Value("${version}")
    String gf_31hwQbRg;

    @Value("${dbapi.mode}")
    String gf_iIGu9pa7;

    @Autowired
    C_nzGlHcnH gf_fp8MmVcU;

    @Value("${dbapi.api.context}")
    String gf_fUuPpkMB;

    @RequestMapping("/version")
    public String m_QsGkrK9W() {
        return gf_31hwQbRg;
    }

    @RequestMapping("/mode")
    public String m_WiHrnrza() {
        String lf_rERERQPz = System.getenv("DOCKER");
        if ("true".equals(lf_rERERQPz)) {
            return gf_iIGu9pa7 + " in docker";
        } else {
            return gf_iIGu9pa7;
        }
    }

    @RequestMapping("/getIPPort")
    public String m_5Nqdw4B8(HttpServletRequest request) {
        if ("standalone".equals(gf_iIGu9pa7)) {
            return request.getServerName() + ":" + request.getServerPort() + "/" + gf_fUuPpkMB;
        } else if ("cluster".equals(gf_iIGu9pa7)) {
            return gf_fp8MmVcU.m_xRR8EB4G() + "/" + gf_fUuPpkMB;
        } else {
            return null;
        }
    }

    @RequestMapping("/getIP")
    public String m_b8UdKnOp(HttpServletRequest request) {
        if ("standalone".equals(gf_iIGu9pa7)) {
            return request.getServerName() + ":" + request.getServerPort();
        } else if ("cluster".equals(gf_iIGu9pa7)) {
            return gf_fp8MmVcU.m_xRR8EB4G();
        } else {
            return null;
        }
    }
}
