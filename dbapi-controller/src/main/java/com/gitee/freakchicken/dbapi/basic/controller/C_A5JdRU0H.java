package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.domain.Client;
import com.gitee.freakchicken.dbapi.basic.service.C_TUHlgH0Q;
import com.gitee.freakchicken.dbapi.basic.util.C_LCGXNEh5;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/client")
public class C_A5JdRU0H {

    @Autowired
    private C_TUHlgH0Q gf_wGlC8u35;

    @PostMapping("/create")
    public ResponseDto m_04Pr4Yzj(Client client) {
        client.setCreateUserId(C_LCGXNEh5.m_4r4IiO0Z());
        return gf_wGlC8u35.m_0nUAC9pD(client);
    }

    @PostMapping("/getAll")
    public List<Client> m_fgvjhEqp() {
        List<Client> lf_BQ9HabS7 = gf_wGlC8u35.m_eGgbtsUA();
        return lf_BQ9HabS7;
    }

    @PostMapping("/delete/{clientId}")
    public void m_vZZ9IwVy(@PathVariable("clientId") String clientId) {
        gf_wGlC8u35.m_aRBx4G3s(clientId);
    }

    @PostMapping("/auth")
    public void m_2GdlSpuL(String clientId, String groupIds) {
        gf_wGlC8u35.m_VANk6IfD(clientId, groupIds);
    }

    @PostMapping("/getAuthGroups/{clientId}")
    public List<String> m_dmJKswvK(@PathVariable("clientId") String clientId) {
        return gf_wGlC8u35.m_zd5lsvtn(clientId);
    }
}
