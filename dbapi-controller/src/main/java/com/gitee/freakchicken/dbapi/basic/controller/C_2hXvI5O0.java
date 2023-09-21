package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.domain.Client;
import com.gitee.freakchicken.dbapi.basic.service.C_lqjf7MAK;
import com.gitee.freakchicken.dbapi.basic.util.C_idPcCdpc;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/client")
public class C_2hXvI5O0 {

    @Autowired
    private C_lqjf7MAK gf_zpLJuO9A;

    @PostMapping("/create")
    public ResponseDto m_tEQPHtzO(Client client) {
        client.setCreateUserId(C_idPcCdpc.m_CpasizWZ());
        return gf_zpLJuO9A.m_QrWZ17fZ(client);
    }

    @PostMapping("/getAll")
    public List<Client> m_ziPvH5AK() {
        List<Client> lf_1r0VtgUy = gf_zpLJuO9A.m_5LIhkiHy();
        return lf_1r0VtgUy;
    }

    @PostMapping("/delete/{clientId}")
    public void m_W4jrlvTO(@PathVariable("clientId") String clientId) {
        gf_zpLJuO9A.m_qRInNI5P(clientId);
    }

    @PostMapping("/auth")
    public void m_YNOA15LU(String clientId, String groupIds) {
        gf_zpLJuO9A.m_y06HA2GF(clientId, groupIds);
    }

    @PostMapping("/getAuthGroups/{clientId}")
    public List<String> m_vU2cP12n(@PathVariable("clientId") String clientId) {
        return gf_zpLJuO9A.m_NSxUFs83(clientId);
    }
}
