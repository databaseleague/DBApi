package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.service.C_E46GzSxW;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/firewall")
public class C_BG5Ijlvm {

    @Autowired
    C_E46GzSxW gf_0vJHoHiN;

    @RequestMapping("/save")
    public void m_sJeclpmd(String status, String mode, String whiteIP, String blackIP) {
        if (status.equals("on")) {
            if (mode.equals("white")) {
                gf_0vJHoHiN.m_o9CalkDa(mode, whiteIP);
            } else if (mode.equals("black")) {
                gf_0vJHoHiN.m_o9CalkDa(mode, blackIP);
            }
        } else if (status.equals("off")) {
            gf_0vJHoHiN.m_94qdtv0b();
        }
    }

    @RequestMapping("/detail")
    public Map<String, String> m_syU5v4mO() {
        return gf_0vJHoHiN.m_foSflm2S();
    }
}
