package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.domain.Group;
import com.gitee.freakchicken.dbapi.basic.service.C_8XCeckSJ;
import com.gitee.freakchicken.dbapi.basic.util.C_LCGXNEh5;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/group")
public class C_XVfhxAfE {

    @Autowired
    C_8XCeckSJ gf_vuEAJLlj;

    @RequestMapping("/create")
    public ResponseDto m_fgS38VIl(Group group) {
        group.setCreateUserId(C_LCGXNEh5.m_4r4IiO0Z());
        return gf_vuEAJLlj.m_zBcbWsJx(group);
    }

    @RequestMapping("/delete/{id}")
    public ResponseDto m_1EjNVDFR(@PathVariable String id) {
        return gf_vuEAJLlj.m_IktpBH6U(id);
    }

    @RequestMapping("/getAll")
    public List<Group> m_Y6MDr8rC() {
        List<Group> lf_9W7zENMD = gf_vuEAJLlj.m_qRbWAMuj();
        return lf_9W7zENMD;
    }

    @RequestMapping("/update")
    public void m_Hui0l3jP(Group group) {
        gf_vuEAJLlj.m_IssKOSTZ(group);
    }
}
