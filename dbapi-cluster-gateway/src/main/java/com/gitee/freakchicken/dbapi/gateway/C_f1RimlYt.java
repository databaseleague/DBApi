package com.gitee.freakchicken.dbapi.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@ComponentScan(value = { "com.gitee.freakchicken.dbapi.basic", "com.gitee.freakchicken.dbapi.gateway" }, excludeFilters = { @ComponentScan.Filter(type = FilterType.REGEX, pattern = { // 
// 
"com.gitee.freakchicken.dbapi.basic.filter.*", "com.gitee.freakchicken.dbapi.basic.controller.*", "com.gitee.freakchicken.dbapi.basic.conf.*", "com.gitee.freakchicken.dbapi.basic.service.LoadPluginOnSpringReady" }) })
@MapperScan("com.gitee.freakchicken.dbapi.basic.dao")
@EnableCaching
public class C_f1RimlYt {

    public static void main(String[] p_tZfJLufi) {
        System.setProperty("spring.profiles.active", "gateway");
        System.setProperty("reactor.netty.http.server.accessLogEnabled", "false");
        SpringApplication.run(C_f1RimlYt.class, p_tZfJLufi);
    }
}
