package com.gitee.freakchicken.dbapi;

import com.dbapi.C_Al2P4IQb;
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
public class C_cLAoks4E {

    public static void main(String[] p_F0H9JYfT) {
        System.setProperty("spring.profiles.active", "standalone");
        SpringApplication.run(C_cLAoks4E.class, p_F0H9JYfT);
    }

    @Value("${version}")
    String gf_rvBrDm3c;

    @PostConstruct
    public void m_LTnSy5nL() {
        C_Al2P4IQb.m_bgPr5w6d(gf_rvBrDm3c);
    }
}
