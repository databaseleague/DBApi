package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.domain.Client;
import com.gitee.freakchicken.dbapi.basic.service.C_0u6UvISA;
import com.gitee.freakchicken.dbapi.basic.util.C_oagmA7fO;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/client")
public class C_pDEBPYaV {

    @Autowired
    private C_0u6UvISA gf_6WeiXiIX;

    @PostMapping("/create")
    public ResponseDto m_Gck4kfp8(Client client) {
        client.setCreateUserId(C_oagmA7fO.m_RXdK6OuW());
        return gf_6WeiXiIX.m_CQ7tgaeE(client);
    }

    @PostMapping("/getAll")
    public List<Client> m_DmQGnWhi() {
        List<Client> lf_Yfe4JUUm = gf_6WeiXiIX.m_lgzfEZH7();
        return lf_Yfe4JUUm;
    }

    @PostMapping("/delete/{clientId}")
    public void m_vwZdSHpW(@PathVariable("clientId") String clientId) {
        gf_6WeiXiIX.m_xo9RaFBg(clientId);
    }

    @PostMapping("/auth")
    public void m_dMrjPNhX(String clientId, String groupIds) {
        gf_6WeiXiIX.m_of0jW2hU(clientId, groupIds);
    }

    @PostMapping("/getAuthGroups/{clientId}")
    public List<String> m_HqCScI4l(@PathVariable("clientId") String clientId) {
        return gf_6WeiXiIX.m_so27rcmM(clientId);
    }
}
