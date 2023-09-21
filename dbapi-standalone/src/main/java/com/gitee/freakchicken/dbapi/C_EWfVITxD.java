package com.gitee.freakchicken.dbapi;

import com.dbapi.C_1FzchE3P;
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
public class C_EWfVITxD {

    public static void main(String[] p_tt66RY8e) {
        System.setProperty("spring.profiles.active", "standalone");
        SpringApplication.run(C_EWfVITxD.class, p_tt66RY8e);
    }

    @Value("${version}")
    String gf_BxienfNj;

    @PostConstruct
    public void m_D4UTvk5t() {
        C_1FzchE3P.m_Ke0DbkXK(gf_BxienfNj);
    }
}
