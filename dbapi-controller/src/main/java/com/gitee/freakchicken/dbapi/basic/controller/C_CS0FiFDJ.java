package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.domain.Group;
import com.gitee.freakchicken.dbapi.basic.service.C_F7UxtfcI;
import com.gitee.freakchicken.dbapi.basic.util.C_EBTXy8Ml;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/group")
public class C_CS0FiFDJ {

    @Autowired
    C_F7UxtfcI gf_IjoXXeH7;

    @RequestMapping("/create")
    public ResponseDto m_nrBnfbdV(Group group) {
        group.setCreateUserId(C_EBTXy8Ml.m_3gCYT3A1());
        return gf_IjoXXeH7.m_L32zMI5d(group);
    }

    @RequestMapping("/delete/{id}")
    public ResponseDto m_A7yp5J5m(@PathVariable String id) {
        return gf_IjoXXeH7.m_pk5WXRwm(id);
    }

    @RequestMapping("/getAll")
    public List<Group> m_1mQG2QOA() {
        List<Group> lf_cpynxwbk = gf_IjoXXeH7.m_tXk70WDU();
        return lf_cpynxwbk;
    }

    @RequestMapping("/update")
    public void m_R5rwRpKC(Group group) {
        gf_IjoXXeH7.m_joSnOu9X(group);
    }
}
