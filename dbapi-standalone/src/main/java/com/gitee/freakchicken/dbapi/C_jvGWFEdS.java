package com.gitee.freakchicken.dbapi;

import com.dbapi.apple.verify.Activator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import javax.annotation.PostConstruct;

@SpringBootApplication
@MapperScan("com.gitee.freakchicken.dbapi.basic.dao")
@EnableCaching
@ComponentScan(value = { "com.gitee.freakchicken.dbapi.basic", "com.gitee.freakchicken.dbapi.conf" })
@EnableAsync
public class C_jvGWFEdS {

    public static void main(String[] p_L0kEgKeu) {
        System.setProperty("spring.profiles.active", "standalone");
        SpringApplication.run(C_jvGWFEdS.class, p_L0kEgKeu);
    }

    @PostConstruct
    public void m_EG3qjOlJ() {
        Activator.verify();
    }
}
