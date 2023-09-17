package com.gitee.freakchicken.dbapi.plugin;

import com.gitee.freakchicken.dbapi.common.ApiConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;

public abstract class CachePlugin implements BasePlugin {

    public Logger logger = LoggerFactory.getLogger(CachePlugin.class);

    public abstract void init();

    public abstract void set(ApiConfig config, Map<String, Object> requestParams, Object data, String localPluginParam);

    public abstract void clean(ApiConfig config, String localPluginParam);

    public abstract Object get(ApiConfig config, Map<String, Object> requestParams, String localPluginParam);
}
