package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.domain.User;
import com.gitee.freakchicken.dbapi.basic.service.C_x5KREvdK;
import com.gitee.freakchicken.dbapi.basic.util.C_rBywQc3Z;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class C_ecT6Clzi {

    @Autowired
    C_x5KREvdK gf_CbSiO73h;

    @RequestMapping("/login")
    public ResponseDto m_KbSg54BY(String username, String password) {
        User lf_E5JPnXXD = gf_CbSiO73h.m_aMb7x7Dp(username, password);
        if (lf_E5JPnXXD == null) {
            return ResponseDto.fail("Username or password incorrect!");
        } else {
            String lf_OEalweHp = C_rBywQc3Z.m_McCqZvNV(lf_E5JPnXXD.getId().toString(), lf_E5JPnXXD.getPassword());
            lf_E5JPnXXD.setToken(lf_OEalweHp);
            return ResponseDto.successWithData(lf_E5JPnXXD);
        }
    }

    @RequestMapping("/resetPassword")
    public ResponseDto m_JbludB19(String userId, String oldPassword, String newPassword) {
        return gf_CbSiO73h.m_Nx1mSYlW(userId, oldPassword, newPassword);
    }
}
