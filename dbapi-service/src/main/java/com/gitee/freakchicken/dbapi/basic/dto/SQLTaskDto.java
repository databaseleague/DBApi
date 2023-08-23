package com.gitee.freakchicken.dbapi.basic.dto;

import lombok.Data;

import java.util.List;

@Data
public class SQLTaskDto {

    String datasourceId;

    Boolean transaction;

    List<ApiSqlDto> sqlList;

}
