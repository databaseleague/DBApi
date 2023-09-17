package com.gitee.freakchicken.dbapi.apiserver;

import com.dbapi.apple.verify.Activator;
import org.mybatis.spring.annotation.MapperScan;
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
public class C_pZvO1qSs {

    public static void main(String[] p_NzDtNWCh) {
        System.setProperty("spring.profiles.active", "apiServer");
        SpringApplication.run(C_pZvO1qSs.class, p_NzDtNWCh);
    }

    @PostConstruct
    public void m_Yy79xxRj() {
        Activator.verify();
    }
}
