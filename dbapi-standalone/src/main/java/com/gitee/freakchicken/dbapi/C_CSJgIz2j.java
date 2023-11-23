package com.gitee.freakchicken.dbapi;

import com.dbapi.C_4QNAxexX;
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
public class C_CSJgIz2j {

    public static void main(String[] p_eVtU9AzT) {
        System.setProperty("spring.profiles.active", "standalone");
        SpringApplication.run(C_CSJgIz2j.class, p_eVtU9AzT);
    }

    @Value("${version}")
    String gf_SPUlc34B;

    @PostConstruct
    public void m_Gzi78sB5() {
        C_4QNAxexX.m_EqlkeY2K(gf_SPUlc34B);
    }
}
