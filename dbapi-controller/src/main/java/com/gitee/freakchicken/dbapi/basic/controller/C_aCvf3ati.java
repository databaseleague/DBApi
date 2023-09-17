package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.domain.User;
import com.gitee.freakchicken.dbapi.basic.service.C_y5ZsO7HK;
import com.gitee.freakchicken.dbapi.basic.util.C_NRYCuMqs;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class C_aCvf3ati {

    @Autowired
    C_y5ZsO7HK gf_sspRLibP;

    @RequestMapping("/login")
    public ResponseDto m_d3gzR34g(String username, String password) {
        User lf_hJXSKFNr = gf_sspRLibP.m_zVXImI8x(username, password);
        if (lf_hJXSKFNr == null) {
            return ResponseDto.fail("Username or password incorrect!");
        } else {
            String lf_O0ir7fH0 = C_NRYCuMqs.m_A6HDoYmK(lf_hJXSKFNr.getId().toString(), lf_hJXSKFNr.getPassword());
            lf_hJXSKFNr.setToken(lf_O0ir7fH0);
            return ResponseDto.successWithData(lf_hJXSKFNr);
        }
    }

    @RequestMapping("/resetPassword")
    public ResponseDto m_rUTelXTd(String userId, String oldPassword, String newPassword) {
        return gf_sspRLibP.m_plSAzE79(userId, oldPassword, newPassword);
    }
}
