package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.domain.User;
import com.gitee.freakchicken.dbapi.basic.service.C_Ei9EBY2s;
import com.gitee.freakchicken.dbapi.basic.util.C_tmJWNszs;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class C_MpksxNhd {

    @Autowired
    C_Ei9EBY2s gf_VTRSnWcO;

    @RequestMapping("/login")
    public ResponseDto m_qvEU7HPz(String username, String password) {
        User lf_ala1aHSh = gf_VTRSnWcO.m_pG9MIs4n(username, password);
        if (lf_ala1aHSh == null) {
            return ResponseDto.fail("Username or password incorrect!");
        } else {
            String lf_eB5mOCbt = C_tmJWNszs.m_g727AA8g(lf_ala1aHSh.getId().toString(), lf_ala1aHSh.getPassword());
            lf_ala1aHSh.setToken(lf_eB5mOCbt);
            return ResponseDto.successWithData(lf_ala1aHSh);
        }
    }

    @RequestMapping("/resetPassword")
    public ResponseDto m_OOBX4w4n(String userId, String oldPassword, String newPassword) {
        return gf_VTRSnWcO.m_eHr8Clns(userId, oldPassword, newPassword);
    }
}
