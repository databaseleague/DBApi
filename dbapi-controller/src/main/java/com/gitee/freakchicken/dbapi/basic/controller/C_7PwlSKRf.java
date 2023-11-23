package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.domain.User;
import com.gitee.freakchicken.dbapi.basic.service.C_K7Ac0fQF;
import com.gitee.freakchicken.dbapi.basic.util.C_IvNrvvGl;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class C_7PwlSKRf {

    @Autowired
    C_K7Ac0fQF gf_KaAM0coY;

    @RequestMapping("/login")
    public ResponseDto m_c4GXeH6U(String username, String password) {
        User lf_KF4NQwK0 = gf_KaAM0coY.m_MuwWb69k(username, password);
        if (lf_KF4NQwK0 == null) {
            return ResponseDto.fail("Username or password incorrect!");
        } else {
            String lf_bvJ2lDFa = C_IvNrvvGl.m_Fu3Jsub1(lf_KF4NQwK0.getId().toString(), lf_KF4NQwK0.getPassword());
            lf_KF4NQwK0.setToken(lf_bvJ2lDFa);
            return ResponseDto.successWithData(lf_KF4NQwK0);
        }
    }

    @RequestMapping("/resetPassword")
    public ResponseDto m_gpoKxn7e(String userId, String oldPassword, String newPassword) {
        return gf_KaAM0coY.m_tth2Od6P(userId, oldPassword, newPassword);
    }
}
