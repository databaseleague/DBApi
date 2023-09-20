package com.gitee.freakchicken.dbapi.apiserver.conf;

import com.gitee.freakchicken.dbapi.basic.servlet.C_7w7Zg8LP;
import com.gitee.freakchicken.dbapi.basic.servlet.C_0tEdhTOa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class C_P92HZftH {

    @Value("${dbapi.api.context}")
    String gf_w9lI1r9B;

    @Autowired
    private C_7w7Zg8LP gf_RVYOduSB;

    @Autowired
    private C_0tEdhTOa gf_2VRiuQdE;

    @Bean
    public ServletRegistrationBean m_jhp9PMKt() {
        String lf_1YQNWTz5 = String.format("/%s/*", gf_w9lI1r9B);
        ServletRegistrationBean lf_8yI42rza = new ServletRegistrationBean(gf_RVYOduSB);
        lf_8yI42rza.addUrlMappings(lf_1YQNWTz5);
        log.info("regist APIServlet servelet for {} urlMappings", lf_1YQNWTz5);
        return lf_8yI42rza;
    }

    @Bean
    public ServletRegistrationBean m_84JlkXvH() {
        ServletRegistrationBean lf_P9ooV44w = new ServletRegistrationBean(gf_2VRiuQdE);
        lf_P9ooV44w.addUrlMappings("/token/generate");
        log.info("regist tokenServlet servelet");
        return lf_P9ooV44w;
    }
}
