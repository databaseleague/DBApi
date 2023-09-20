package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.domain.Group;
import com.gitee.freakchicken.dbapi.basic.service.C_6NvESxQY;
import com.gitee.freakchicken.dbapi.basic.util.C_oagmA7fO;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/group")
public class C_z5xYrvxs {

    @Autowired
    C_6NvESxQY gf_oghcr2yC;

    @RequestMapping("/create")
    public ResponseDto m_CJlCDJ5p(Group group) {
        group.setCreateUserId(C_oagmA7fO.m_RXdK6OuW());
        return gf_oghcr2yC.m_3iVwlN4H(group);
    }

    @RequestMapping("/delete/{id}")
    public ResponseDto m_cBcepMg9(@PathVariable String id) {
        return gf_oghcr2yC.m_yc9P16i8(id);
    }

    @RequestMapping("/getAll")
    public List<Group> m_fUvrav8p() {
        List<Group> lf_FaZpUu9l = gf_oghcr2yC.m_Ce2ZgTRc();
        return lf_FaZpUu9l;
    }

    @RequestMapping("/update")
    public void m_TkfINoLc(Group group) {
        gf_oghcr2yC.m_CaIrjEQc(group);
    }
}
