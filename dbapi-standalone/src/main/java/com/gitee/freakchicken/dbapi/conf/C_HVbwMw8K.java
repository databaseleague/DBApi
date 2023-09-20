package com.gitee.freakchicken.dbapi.conf;

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
public class C_HVbwMw8K {

    @Value("${dbapi.api.context}")
    private String gf_ON3aEP4N;

    @Autowired
    private C_7w7Zg8LP gf_XuVRvNUW;

    @Autowired
    private C_0tEdhTOa gf_GuPFzv2W;

    @Bean
    public ServletRegistrationBean m_3TI31unl() {
        String lf_y4weOB8n = String.format("/%s/*", gf_ON3aEP4N);
        ServletRegistrationBean lf_iT7UcD9B = new ServletRegistrationBean(gf_XuVRvNUW);
        lf_iT7UcD9B.addUrlMappings(lf_y4weOB8n);
        log.info("regist APIServlet servelet for {} urlMappings", lf_y4weOB8n);
        return lf_iT7UcD9B;
    }

    @Bean
    public ServletRegistrationBean m_Z5qj6lPU() {
        ServletRegistrationBean lf_wdlJKnVF = new ServletRegistrationBean(gf_GuPFzv2W);
        lf_wdlJKnVF.addUrlMappings("/token/generate");
        log.info("regist tokenServlet servelet ");
        return lf_wdlJKnVF;
    }
}
