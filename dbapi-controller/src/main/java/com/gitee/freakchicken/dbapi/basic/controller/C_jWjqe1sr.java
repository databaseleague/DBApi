package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.domain.Group;
import com.gitee.freakchicken.dbapi.basic.service.C_dTOaI7qN;
import com.gitee.freakchicken.dbapi.basic.util.C_vudUmpvO;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/group")
public class C_jWjqe1sr {

    @Autowired
    C_dTOaI7qN gf_F425K76P;

    @RequestMapping("/create")
    public ResponseDto m_Dg7d57z1(Group group) {
        group.setCreateUserId(C_vudUmpvO.m_4zzh6Q4j());
        return gf_F425K76P.m_KkQbPfMl(group);
    }

    @RequestMapping("/delete/{id}")
    public ResponseDto m_1eKKZ2Mi(@PathVariable String id) {
        return gf_F425K76P.m_lkbKqRuW(id);
    }

    @RequestMapping("/getAll")
    public List<Group> m_ile7UwZu() {
        List<Group> lf_ZzlDk7Bl = gf_F425K76P.m_amUrJ4ck();
        return lf_ZzlDk7Bl;
    }

    @RequestMapping("/update")
    public void m_OAGYRW7Q(Group group) {
        gf_F425K76P.m_TBvTM46d(group);
    }
}
