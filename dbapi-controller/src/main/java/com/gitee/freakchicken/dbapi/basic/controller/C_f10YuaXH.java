package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.service.C_UoTIlJoS;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/firewall")
public class C_f10YuaXH {

    @Autowired
    C_UoTIlJoS gf_L96CCrzw;

    @RequestMapping("/save")
    public void m_UMOvMeog(String status, String mode, String whiteIP, String blackIP) {
        if (status.equals("on")) {
            if (mode.equals("white")) {
                gf_L96CCrzw.m_LAbD2SGw(mode, whiteIP);
            } else if (mode.equals("black")) {
                gf_L96CCrzw.m_LAbD2SGw(mode, blackIP);
            }
        } else if (status.equals("off")) {
            gf_L96CCrzw.m_Xm1UOJC9();
        }
    }

    @RequestMapping("/detail")
    public Map<String, String> m_hiY1VVFM() {
        return gf_L96CCrzw.m_HEbLyMRP();
    }
}
