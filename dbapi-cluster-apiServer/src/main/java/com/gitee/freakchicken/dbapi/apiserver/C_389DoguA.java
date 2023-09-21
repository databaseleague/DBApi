package com.gitee.freakchicken.dbapi.apiserver;

import com.dbapi.C_1FzchE3P;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import javax.annotation.PostConstruct;

@EnableScheduling
@SpringBootApplication
@MapperScan("com.gitee.freakchicken.dbapi.basic.dao")
@EnableCaching
@EnableAsync
@ComponentScan(value = { "com.gitee.freakchicken.dbapi.basic", "com.gitee.freakchicken.dbapi.apiserver" }, excludeFilters = { @ComponentScan.Filter(type = FilterType.REGEX, pattern = { // 
// 
"com.gitee.freakchicken.dbapi.basic.filter.ApiIPFilter", "com.gitee.freakchicken.dbapi.basic.conf.*", "com.gitee.freakchicken.dbapi.basic.controller.*" }) })
public class C_389DoguA {

    public static void main(String[] p_GscmR01k) {
        System.setProperty("spring.profiles.active", "apiServer");
        SpringApplication.run(C_389DoguA.class, p_GscmR01k);
    }

    @Value("${version}")
    String gf_ViWKg39t;

    @PostConstruct
    public void m_F54RA8u9() {
        C_1FzchE3P.m_Ke0DbkXK(gf_ViWKg39t);
    }
}
