package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.service.C_3FeAXavv;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/firewall")
public class C_MyQpXwA4 {

    @Autowired
    C_3FeAXavv gf_1PkqQmeo;

    @RequestMapping("/save")
    public void m_ov0TY1Hd(String status, String mode, String whiteIP, String blackIP) {
        if (status.equals("on")) {
            if (mode.equals("white")) {
                gf_1PkqQmeo.m_Co9SCYDl(mode, whiteIP);
            } else if (mode.equals("black")) {
                gf_1PkqQmeo.m_Co9SCYDl(mode, blackIP);
            }
        } else if (status.equals("off")) {
            gf_1PkqQmeo.m_ex6VwI2F();
        }
    }

    @RequestMapping("/detail")
    public Map<String, String> m_Kbbv7h5a() {
        return gf_1PkqQmeo.m_l9iyX9RU();
    }
}
