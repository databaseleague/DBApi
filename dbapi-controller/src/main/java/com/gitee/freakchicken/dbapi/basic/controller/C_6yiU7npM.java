package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.service.C_1evcT41m;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/firewall")
public class C_6yiU7npM {

    @Autowired
    C_1evcT41m gf_52xXNarq;

    @RequestMapping("/save")
    public void m_Ab7JDuPI(String status, String mode, String whiteIP, String blackIP) {
        if (status.equals("on")) {
            if (mode.equals("white")) {
                gf_52xXNarq.m_lNV1T0X6(mode, whiteIP);
            } else if (mode.equals("black")) {
                gf_52xXNarq.m_lNV1T0X6(mode, blackIP);
            }
        } else if (status.equals("off")) {
            gf_52xXNarq.m_faY5anOr();
        }
    }

    @RequestMapping("/detail")
    public Map<String, String> m_IJp85zFE() {
        return gf_52xXNarq.m_yrTUfph6();
    }
}
