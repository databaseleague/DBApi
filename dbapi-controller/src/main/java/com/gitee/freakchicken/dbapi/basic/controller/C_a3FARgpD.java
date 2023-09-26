package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.domain.Group;
import com.gitee.freakchicken.dbapi.basic.service.C_G5OMPVYO;
import com.gitee.freakchicken.dbapi.basic.util.C_pW4Y7Qx2;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/group")
public class C_a3FARgpD {

    @Autowired
    C_G5OMPVYO gf_tXgc30fO;

    @RequestMapping("/create")
    public ResponseDto m_N3CjUerk(Group group) {
        group.setCreateUserId(C_pW4Y7Qx2.m_0JUEwP8t());
        return gf_tXgc30fO.m_mTRhbXMq(group);
    }

    @RequestMapping("/delete/{id}")
    public ResponseDto m_ezmyyJp4(@PathVariable String id) {
        return gf_tXgc30fO.m_f1wt4gMF(id);
    }

    @RequestMapping("/getAll")
    public List<Group> m_wtz2kh6C() {
        List<Group> lf_zJsLXFZQ = gf_tXgc30fO.m_rxK82HgH();
        return lf_zJsLXFZQ;
    }

    @RequestMapping("/update")
    public void m_STwcaTj1(Group group) {
        gf_tXgc30fO.m_GhCY1TlW(group);
    }
}
