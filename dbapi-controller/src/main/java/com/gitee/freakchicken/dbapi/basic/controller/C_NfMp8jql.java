package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.fastjson.JSONObject;
import com.gitee.freakchicken.dbapi.plugin.PluginManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plugin")
public class C_NfMp8jql {

    @RequestMapping("/all")
    public JSONObject m_pdmTfjHm() {
        JSONObject lf_PPeXSOPV = new JSONObject();
        lf_PPeXSOPV.put("cache", PluginManager.getAllCachePlugins());
        lf_PPeXSOPV.put("transform", PluginManager.getAllTransformPlugins());
        lf_PPeXSOPV.put("alarm", PluginManager.getAllAlarmPlugins());
        lf_PPeXSOPV.put("globalTransform", PluginManager.getAllGlobalTransformPlugins());
        return lf_PPeXSOPV;
    }
}
