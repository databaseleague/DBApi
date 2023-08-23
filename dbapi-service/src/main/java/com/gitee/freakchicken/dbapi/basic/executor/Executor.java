package com.gitee.freakchicken.dbapi.basic.executor;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public interface Executor {

    public Object execute(JSONObject taskJson, Map<String, Object> param) throws Exception;
}
