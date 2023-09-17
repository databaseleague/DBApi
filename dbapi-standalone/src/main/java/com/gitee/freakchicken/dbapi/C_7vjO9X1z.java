package com.gitee.freakchicken.dbapi;

import com.dbapi.apple.verify.Activator;
import org.mybatis.spring.annotation.MapperScan;
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
public class C_7vjO9X1z {

    public static void main(String[] p_yxWkgByv) {
        System.setProperty("spring.profiles.active", "standalone");
        SpringApplication.run(C_7vjO9X1z.class, p_yxWkgByv);
    }

    @PostConstruct
    public void m_22ys0NeL() {
        Activator.verify();
    }
}
