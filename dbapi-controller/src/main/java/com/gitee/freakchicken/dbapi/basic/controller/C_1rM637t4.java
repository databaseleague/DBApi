package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.fastjson.JSONObject;
import com.gitee.freakchicken.dbapi.plugin.PluginManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plugin")
public class C_1rM637t4 {

    @RequestMapping("/all")
    public JSONObject m_gIRt5J94() {
        JSONObject lf_YuyxqmTx = new JSONObject();
        lf_YuyxqmTx.put("cache", PluginManager.getAllCachePlugins());
        lf_YuyxqmTx.put("transform", PluginManager.getAllTransformPlugins());
        lf_YuyxqmTx.put("alarm", PluginManager.getAllAlarmPlugins());
        lf_YuyxqmTx.put("globalTransform", PluginManager.getAllGlobalTransformPlugins());
        return lf_YuyxqmTx;
    }
}
