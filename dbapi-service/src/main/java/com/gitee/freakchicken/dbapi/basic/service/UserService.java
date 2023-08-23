package com.gitee.freakchicken.dbapi.basic.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.gitee.freakchicken.dbapi.basic.dao.UserMapper;
import com.gitee.freakchicken.dbapi.basic.domain.User;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@DS("meta-db")
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getUser(String username, String password) {

        User user = userMapper.login(username, DigestUtils.md5Hex(password));
        return user;
    }

    public User getUserById(Integer id) {
        return userMapper.selectById(id);
    }

    @Transactional
    public ResponseDto resetPassword(String userId, String oldPassword, String newPassword) {

        User user = userMapper.selectById(userId);
        if (user != null && DigestUtils.md5Hex(oldPassword).equals(user.getPassword())) {

            user.setPassword(DigestUtils.md5Hex(newPassword));
            userMapper.updateById(user);
            return ResponseDto.successWithMsg("Change password success!");
        } else {
            return ResponseDto.fail("Old password incorrect");
        }


    }
}
