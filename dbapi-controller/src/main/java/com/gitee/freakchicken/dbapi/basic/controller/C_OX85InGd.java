package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.fastjson.JSONObject;
import com.gitee.freakchicken.dbapi.plugin.PluginManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plugin")
public class C_OX85InGd {

    @RequestMapping("/all")
    public JSONObject m_ttvPLBSn() {
        JSONObject lf_qyZQ8Tg3 = new JSONObject();
        lf_qyZQ8Tg3.put("cache", PluginManager.getAllCachePlugins());
        lf_qyZQ8Tg3.put("transform", PluginManager.getAllTransformPlugins());
        lf_qyZQ8Tg3.put("alarm", PluginManager.getAllAlarmPlugins());
        lf_qyZQ8Tg3.put("globalTransform", PluginManager.getAllGlobalTransformPlugins());
        return lf_qyZQ8Tg3;
    }
}
