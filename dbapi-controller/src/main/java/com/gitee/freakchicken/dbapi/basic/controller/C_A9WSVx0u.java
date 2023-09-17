package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.domain.Group;
import com.gitee.freakchicken.dbapi.basic.service.C_n20BDw2R;
import com.gitee.freakchicken.dbapi.basic.util.C_9CYMzywH;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/group")
public class C_A9WSVx0u {

    @Autowired
    C_n20BDw2R gf_FmYHdGjY;

    @RequestMapping("/create")
    public ResponseDto m_DJiBwKyh(Group group) {
        group.setCreateUserId(C_9CYMzywH.m_PvlTFGSh());
        return gf_FmYHdGjY.m_DnHaK2mN(group);
    }

    @RequestMapping("/delete/{id}")
    public ResponseDto m_VNWBbGpb(@PathVariable String id) {
        return gf_FmYHdGjY.m_BL8dDxD7(id);
    }

    @RequestMapping("/getAll")
    public List<Group> m_JNmrF4Oz() {
        List<Group> lf_bqF3m4tb = gf_FmYHdGjY.m_5Ia4wEZP();
        return lf_bqF3m4tb;
    }

    @RequestMapping("/update")
    public void m_IRHlsC1D(Group group) {
        gf_FmYHdGjY.m_EpGds6uj(group);
    }
}
