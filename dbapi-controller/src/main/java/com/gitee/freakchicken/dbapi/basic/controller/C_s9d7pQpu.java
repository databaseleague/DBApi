package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.domain.Client;
import com.gitee.freakchicken.dbapi.basic.service.C_UQfCXKBu;
import com.gitee.freakchicken.dbapi.basic.util.C_EBTXy8Ml;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/client")
public class C_s9d7pQpu {

    @Autowired
    private C_UQfCXKBu gf_vsXWrLZH;

    @PostMapping("/create")
    public ResponseDto m_9bmZPT0A(Client client) {
        client.setCreateUserId(C_EBTXy8Ml.m_3gCYT3A1());
        return gf_vsXWrLZH.m_1g9ZJ8V5(client);
    }

    @PostMapping("/getAll")
    public List<Client> m_MoUAxscu() {
        List<Client> lf_Mef7wH7s = gf_vsXWrLZH.m_dnE13TPM();
        return lf_Mef7wH7s;
    }

    @PostMapping("/delete/{clientId}")
    public void m_2QJ6ou4g(@PathVariable("clientId") String clientId) {
        gf_vsXWrLZH.m_jBdfHOPa(clientId);
    }

    @PostMapping("/auth")
    public void m_Yh8zyYC6(String clientId, String groupIds) {
        gf_vsXWrLZH.m_ezfLmGz0(clientId, groupIds);
    }

    @PostMapping("/getAuthGroups/{clientId}")
    public List<String> m_MlQihnlw(@PathVariable("clientId") String clientId) {
        return gf_vsXWrLZH.m_804h5qrx(clientId);
    }
}
