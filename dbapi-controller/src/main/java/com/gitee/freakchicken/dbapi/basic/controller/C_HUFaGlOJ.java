package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.domain.User;
import com.gitee.freakchicken.dbapi.basic.service.C_b47wiYIN;
import com.gitee.freakchicken.dbapi.basic.util.C_bzOuiv2k;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class C_HUFaGlOJ {

    @Autowired
    C_b47wiYIN gf_NfxlxVwK;

    @RequestMapping("/login")
    public ResponseDto m_thj4XNvF(String username, String password) {
        User lf_9o3ehtVx = gf_NfxlxVwK.m_O2e22N5J(username, password);
        if (lf_9o3ehtVx == null) {
            return ResponseDto.fail("Username or password incorrect!");
        } else {
            String lf_Dml6Rbsj = C_bzOuiv2k.m_gH6G1CZS(lf_9o3ehtVx.getId().toString(), lf_9o3ehtVx.getPassword());
            lf_9o3ehtVx.setToken(lf_Dml6Rbsj);
            return ResponseDto.successWithData(lf_9o3ehtVx);
        }
    }

    @RequestMapping("/resetPassword")
    public ResponseDto m_mVjq4LVn(String userId, String oldPassword, String newPassword) {
        return gf_NfxlxVwK.m_fcr2fZmx(userId, oldPassword, newPassword);
    }
}
