package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.domain.Client;
import com.gitee.freakchicken.dbapi.basic.service.C_UY1FD1nS;
import com.gitee.freakchicken.dbapi.basic.util.C_vudUmpvO;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/client")
public class C_ObwWvP7r {

    @Autowired
    private C_UY1FD1nS gf_qqo0hgik;

    @PostMapping("/create")
    public ResponseDto m_pSEswcYj(Client client) {
        client.setCreateUserId(C_vudUmpvO.m_4zzh6Q4j());
        return gf_qqo0hgik.m_C5MUt5JV(client);
    }

    @PostMapping("/getAll")
    public List<Client> m_AqB0pSGJ() {
        List<Client> lf_8bXrnxta = gf_qqo0hgik.m_zogrPZnS();
        return lf_8bXrnxta;
    }

    @PostMapping("/delete/{clientId}")
    public void m_vWmLRPRb(@PathVariable("clientId") String clientId) {
        gf_qqo0hgik.m_bjfDyzdT(clientId);
    }

    @PostMapping("/auth")
    public void m_LEbkAGwk(String clientId, String groupIds) {
        gf_qqo0hgik.m_az3bDbPT(clientId, groupIds);
    }

    @PostMapping("/getAuthGroups/{clientId}")
    public List<String> m_ngOFkFVF(@PathVariable("clientId") String clientId) {
        return gf_qqo0hgik.m_pJm4UcY7(clientId);
    }
}
