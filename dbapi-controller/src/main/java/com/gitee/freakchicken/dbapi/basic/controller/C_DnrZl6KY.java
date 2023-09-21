package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.fastjson.JSONObject;
import com.gitee.freakchicken.dbapi.plugin.PluginManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plugin")
public class C_DnrZl6KY {

    @RequestMapping("/all")
    public JSONObject m_AS3WliLB() {
        JSONObject lf_a00oX2qJ = new JSONObject();
        lf_a00oX2qJ.put("cache", PluginManager.getAllCachePlugins());
        lf_a00oX2qJ.put("transform", PluginManager.getAllTransformPlugins());
        lf_a00oX2qJ.put("alarm", PluginManager.getAllAlarmPlugins());
        lf_a00oX2qJ.put("globalTransform", PluginManager.getAllGlobalTransformPlugins());
        return lf_a00oX2qJ;
    }
}
