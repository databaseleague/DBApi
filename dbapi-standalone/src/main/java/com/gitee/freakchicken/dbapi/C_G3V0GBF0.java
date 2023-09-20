package com.gitee.freakchicken.dbapi;

import com.dbapi.C_ISsmJ1nt;
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
public class C_G3V0GBF0 {

    public static void main(String[] p_XsHI4WS8) {
        System.setProperty("spring.profiles.active", "standalone");
        SpringApplication.run(C_G3V0GBF0.class, p_XsHI4WS8);
    }

    @Value("${version}")
    String gf_eNrw73NH;

    @PostConstruct
    public void m_VIPc7CZt() {
        C_ISsmJ1nt.m_HwBVGZeg(gf_eNrw73NH);
    }
}
