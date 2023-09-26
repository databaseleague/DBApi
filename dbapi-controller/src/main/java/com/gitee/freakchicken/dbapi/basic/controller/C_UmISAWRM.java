package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.fastjson.JSONObject;
import com.gitee.freakchicken.dbapi.plugin.PluginManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plugin")
public class C_UmISAWRM {

    @RequestMapping("/all")
    public JSONObject m_RMnkYtKx() {
        JSONObject lf_TL6irSM9 = new JSONObject();
        lf_TL6irSM9.put("cache", PluginManager.getAllCachePlugins());
        lf_TL6irSM9.put("transform", PluginManager.getAllTransformPlugins());
        lf_TL6irSM9.put("alarm", PluginManager.getAllAlarmPlugins());
        lf_TL6irSM9.put("globalTransform", PluginManager.getAllGlobalTransformPlugins());
        return lf_TL6irSM9;
    }
}
