package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.service.C_pt3rVIPu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/firewall")
public class C_vQA6fhJw {

    @Autowired
    C_pt3rVIPu gf_JG0yWyLv;

    @RequestMapping("/save")
    public void m_6qbhY1wq(String status, String mode, String whiteIP, String blackIP) {
        if (status.equals("on")) {
            if (mode.equals("white")) {
                gf_JG0yWyLv.m_itucgvNy(mode, whiteIP);
            } else if (mode.equals("black")) {
                gf_JG0yWyLv.m_itucgvNy(mode, blackIP);
            }
        } else if (status.equals("off")) {
            gf_JG0yWyLv.m_Znby0Qy9();
        }
    }

    @RequestMapping("/detail")
    public Map<String, String> m_KQVN496n() {
        return gf_JG0yWyLv.m_oA6BwnTu();
    }
}
