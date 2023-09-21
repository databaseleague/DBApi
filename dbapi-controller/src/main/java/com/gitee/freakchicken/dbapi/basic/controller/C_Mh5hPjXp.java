package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.domain.Group;
import com.gitee.freakchicken.dbapi.basic.service.C_TztqB8u3;
import com.gitee.freakchicken.dbapi.basic.util.C_idPcCdpc;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/group")
public class C_Mh5hPjXp {

    @Autowired
    C_TztqB8u3 gf_GQ1R6kBd;

    @RequestMapping("/create")
    public ResponseDto m_984unMXJ(Group group) {
        group.setCreateUserId(C_idPcCdpc.m_CpasizWZ());
        return gf_GQ1R6kBd.m_JLfzq1iK(group);
    }

    @RequestMapping("/delete/{id}")
    public ResponseDto m_oEiI8Pq8(@PathVariable String id) {
        return gf_GQ1R6kBd.m_xAd7vocu(id);
    }

    @RequestMapping("/getAll")
    public List<Group> m_EjnhV9Cx() {
        List<Group> lf_rZGMJLcb = gf_GQ1R6kBd.m_WoBhy0S0();
        return lf_rZGMJLcb;
    }

    @RequestMapping("/update")
    public void m_GFZfq4ai(Group group) {
        gf_GQ1R6kBd.m_dgBpIzTE(group);
    }
}
