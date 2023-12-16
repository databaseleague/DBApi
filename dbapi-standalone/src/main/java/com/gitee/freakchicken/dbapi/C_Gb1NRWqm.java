package com.gitee.freakchicken.dbapi;

import com.dbapi.C_q4eIyk82;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import javax.annotation.PostConstruct;

@SpringBootApplication
@MapperScan("com.gitee.freakchicken.dbapi.basic.dao")
@EnableCaching
@ComponentScan(value = { "com.gitee.freakchicken.dbapi.basic", "com.gitee.freakchicken.dbapi.conf" })
@EnableAsync
@EnableScheduling
public class C_Gb1NRWqm {

    public static void main(String[] p_etyqjs7l) {
        System.setProperty("spring.profiles.active", "standalone");
        SpringApplication.run(C_Gb1NRWqm.class, p_etyqjs7l);
    }

    @Value("${version}")
    String gf_heyB5A08;

    @PostConstruct
    public void m_gv7M06j6() {
        C_q4eIyk82.m_Omw6HiKu(gf_heyB5A08);
    }
}
