package com.gitee.freakchicken.dbapi.basic.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gitee.freakchicken.dbapi.basic.util.Constants;
import lombok.Data;


import java.io.Serializable;

/**
 * @program: dbApi
 * @description:
 * @author: jiangqiang
 * @create: 2021-01-20 09:52
 **/
@Data
@TableName(value = "datasource")
public class DataSource implements Serializable {

    @TableId(value = "id")
    String id;

    @TableField
    String name;

    @TableField
    String note;

    @TableField
    String type;

    @TableField
    String detail;

    @TableField("create_user_id")
    Integer createUserId;

    @TableField(value = "create_time")
    String createTime;

    @TableField(value = "update_time")
    String updateTime;

    @JSONField(serialize = false)
    @JsonIgnore
    public boolean isJdbcType(){
        return Constants.DATASOURCE_TYPE_JDBC.equals(this.type);
    }

    @JSONField(serialize = false)
    @JsonIgnore
    public JdbcDataSource getJdbcDataSource() {
        JdbcDataSource jdbcDataSource = JSON.parseObject(detail, JdbcDataSource.class);
        return jdbcDataSource;
    }

}
