package com.gitee.freakchicken.dbapi.basic.controller;

import com.gitee.freakchicken.dbapi.basic.domain.User;
import com.gitee.freakchicken.dbapi.basic.service.C_Z5TGnMNO;
import com.gitee.freakchicken.dbapi.basic.util.C_0cSzX84s;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class C_SvXXgIAg {

    @Autowired
    C_Z5TGnMNO gf_YEDa0dtE;

    @RequestMapping("/login")
    public ResponseDto m_kkFPuvz4(String username, String password) {
        User lf_et3Qo6jd = gf_YEDa0dtE.m_gH5xHnnw(username, password);
        if (lf_et3Qo6jd == null) {
            return ResponseDto.fail("Username or password incorrect!");
        } else {
            String lf_44R4JVyY = C_0cSzX84s.m_44FiOatE(lf_et3Qo6jd.getId().toString(), lf_et3Qo6jd.getPassword());
            lf_et3Qo6jd.setToken(lf_44R4JVyY);
            return ResponseDto.successWithData(lf_et3Qo6jd);
        }
    }

    @RequestMapping("/resetPassword")
    public ResponseDto m_x5kLgm6h(String userId, String oldPassword, String newPassword) {
        return gf_YEDa0dtE.m_wUE7GWz1(userId, oldPassword, newPassword);
    }
}
