package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.service.C_meAhBQ4r;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/firewall")
public class C_8utXZqtg {

    @Autowired
    C_meAhBQ4r gf_jgsjEbD6;

    @RequestMapping("/save")
    public void m_Xcnty3gw(String status, String mode, String whiteIP, String blackIP) {
        if (status.equals("on")) {
            if (mode.equals("white")) {
                gf_jgsjEbD6.m_cEpoXsrL(mode, whiteIP);
            } else if (mode.equals("black")) {
                gf_jgsjEbD6.m_cEpoXsrL(mode, blackIP);
            }
        } else if (status.equals("off")) {
            gf_jgsjEbD6.m_nggDvVSs();
        }
    }

    @RequestMapping("/detail")
    public Map<String, String> m_2aXRbq4g() {
        return gf_jgsjEbD6.m_d7puPtdy();
    }
}
