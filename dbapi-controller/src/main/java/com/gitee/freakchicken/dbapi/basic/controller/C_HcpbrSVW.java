package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.domain.Client;
import com.gitee.freakchicken.dbapi.basic.service.C_nRExpqvK;
import com.gitee.freakchicken.dbapi.basic.util.C_pW4Y7Qx2;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/client")
public class C_HcpbrSVW {

    @Autowired
    private C_nRExpqvK gf_PedlSS5a;

    @PostMapping("/create")
    public ResponseDto m_e3SvsMzg(Client client) {
        client.setCreateUserId(C_pW4Y7Qx2.m_0JUEwP8t());
        return gf_PedlSS5a.m_u5bEWpaI(client);
    }

    @PostMapping("/getAll")
    public List<Client> m_jwkhwqKq() {
        List<Client> lf_HQpiKpVE = gf_PedlSS5a.m_pyCFEFPI();
        return lf_HQpiKpVE;
    }

    @PostMapping("/delete/{clientId}")
    public void m_HthXNSd4(@PathVariable("clientId") String clientId) {
        gf_PedlSS5a.m_oNqkw4Nu(clientId);
    }

    @PostMapping("/auth")
    public void m_WaI0lsvl(String clientId, String groupIds) {
        gf_PedlSS5a.m_egjXlCnx(clientId, groupIds);
    }

    @PostMapping("/getAuthGroups/{clientId}")
    public List<String> m_7BXxmMr4(@PathVariable("clientId") String clientId) {
        return gf_PedlSS5a.m_AchoLfq7(clientId);
    }
}
