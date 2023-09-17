package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.service.C_8CjE0s2l;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/firewall")
public class C_lXAtZ5rQ {

    @Autowired
    C_8CjE0s2l gf_nXUHMwKf;

    @RequestMapping("/save")
    public void m_sqU0BLKC(String status, String mode, String whiteIP, String blackIP) {
        if (status.equals("on")) {
            if (mode.equals("white")) {
                gf_nXUHMwKf.m_ikdrhJbC(mode, whiteIP);
            } else if (mode.equals("black")) {
                gf_nXUHMwKf.m_ikdrhJbC(mode, blackIP);
            }
        } else if (status.equals("off")) {
            gf_nXUHMwKf.m_61zKW4Sk();
        }
    }

    @RequestMapping("/detail")
    public Map<String, String> m_kNXKhTcT() {
        return gf_nXUHMwKf.m_Qx9XjfqN();
    }
}
