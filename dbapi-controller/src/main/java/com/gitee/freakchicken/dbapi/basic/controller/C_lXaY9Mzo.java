package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.fastjson.JSONObject;
import com.gitee.freakchicken.dbapi.plugin.PluginManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plugin")
public class C_lXaY9Mzo {

    @RequestMapping("/all")
    public JSONObject m_mqSPsuVf() {
        JSONObject lf_nVLFclE5 = new JSONObject();
        lf_nVLFclE5.put("cache", PluginManager.getAllCachePlugins());
        lf_nVLFclE5.put("transform", PluginManager.getAllTransformPlugins());
        lf_nVLFclE5.put("alarm", PluginManager.getAllAlarmPlugins());
        lf_nVLFclE5.put("globalTransform", PluginManager.getAllGlobalTransformPlugins());
        return lf_nVLFclE5;
    }
}
