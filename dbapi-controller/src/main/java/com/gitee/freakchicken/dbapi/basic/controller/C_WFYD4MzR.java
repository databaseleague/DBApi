package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.fastjson.JSONObject;
import com.gitee.freakchicken.dbapi.plugin.PluginManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plugin")
public class C_WFYD4MzR {

    @RequestMapping("/all")
    public JSONObject m_ofI0o1z9() {
        JSONObject lf_2KlOWNBH = new JSONObject();
        lf_2KlOWNBH.put("cache", PluginManager.getAllCachePlugins());
        lf_2KlOWNBH.put("transform", PluginManager.getAllTransformPlugins());
        lf_2KlOWNBH.put("alarm", PluginManager.getAllAlarmPlugins());
        lf_2KlOWNBH.put("globalTransform", PluginManager.getAllGlobalTransformPlugins());
        return lf_2KlOWNBH;
    }
}
