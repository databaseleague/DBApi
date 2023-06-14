package com.gitee.freakchicken.dbapi.basic.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class JdbcDataSource {

    private String type;
    private String url;
    private String driver;
    private String username;
    private String password;
    private String tableSql;

    @JSONField(serialize = false)
    private boolean isEdit_password;

}
