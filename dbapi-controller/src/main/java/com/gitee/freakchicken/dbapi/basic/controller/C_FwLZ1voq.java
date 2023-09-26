package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.domain.User;
import com.gitee.freakchicken.dbapi.basic.service.C_FCdl5BaH;
import com.gitee.freakchicken.dbapi.basic.util.C_ykKSYJrZ;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class C_FwLZ1voq {

    @Autowired
    C_FCdl5BaH gf_63LBWyGh;

    @RequestMapping("/login")
    public ResponseDto m_Vtkbyvuh(String username, String password) {
        User lf_Bf8rcTmE = gf_63LBWyGh.m_sBTSXt2r(username, password);
        if (lf_Bf8rcTmE == null) {
            return ResponseDto.fail("Username or password incorrect!");
        } else {
            String lf_FN431bzG = C_ykKSYJrZ.m_PK6RFu9T(lf_Bf8rcTmE.getId().toString(), lf_Bf8rcTmE.getPassword());
            lf_Bf8rcTmE.setToken(lf_FN431bzG);
            return ResponseDto.successWithData(lf_Bf8rcTmE);
        }
    }

    @RequestMapping("/resetPassword")
    public ResponseDto m_vmPfPNJk(String userId, String oldPassword, String newPassword) {
        return gf_63LBWyGh.m_49b9KWnf(userId, oldPassword, newPassword);
    }
}
