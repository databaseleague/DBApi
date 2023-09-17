package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.domain.Client;
import com.gitee.freakchicken.dbapi.basic.service.C_Cg3Ivd0o;
import com.gitee.freakchicken.dbapi.basic.util.C_9CYMzywH;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/client")
public class C_Rm7UfnDh {

    @Autowired
    private C_Cg3Ivd0o gf_BaTHzy7s;

    @PostMapping("/create")
    public ResponseDto m_oYt6bgcV(Client client) {
        client.setCreateUserId(C_9CYMzywH.m_PvlTFGSh());
        return gf_BaTHzy7s.m_WhhtdZMf(client);
    }

    @PostMapping("/getAll")
    public List<Client> m_TvujqcYg() {
        List<Client> lf_ndRHgvac = gf_BaTHzy7s.m_Y8ulupBq();
        return lf_ndRHgvac;
    }

    @PostMapping("/delete/{clientId}")
    public void m_5GZDxoMN(@PathVariable("clientId") String clientId) {
        gf_BaTHzy7s.m_dje5G4wv(clientId);
    }

    @PostMapping("/auth")
    public void m_YWjqTrxh(String clientId, String groupIds) {
        gf_BaTHzy7s.m_tKxE6pAn(clientId, groupIds);
    }

    @PostMapping("/getAuthGroups/{clientId}")
    public List<String> m_t5m4UOPC(@PathVariable("clientId") String clientId) {
        return gf_BaTHzy7s.m_nPuXglbh(clientId);
    }
}
