package com.gitee.freakchicken.dbapi.conf;

import com.gitee.freakchicken.dbapi.basic.servlet.C_9E6wG0qK;
import com.gitee.freakchicken.dbapi.basic.servlet.C_lvYe4Hv8;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class C_HH9OyExf {

    @Value("${dbapi.api.context}")
    private String gf_afcxON6H;

    @Autowired
    private C_9E6wG0qK gf_mPQmDjsI;

    @Autowired
    private C_lvYe4Hv8 gf_E3ACVu2J;

    @Bean
    public ServletRegistrationBean m_VtVBWYvu() {
        String lf_tDDOrHmc = String.format("/%s/*", gf_afcxON6H);
        ServletRegistrationBean lf_d3bkOO4D = new ServletRegistrationBean(gf_mPQmDjsI);
        lf_d3bkOO4D.addUrlMappings(lf_tDDOrHmc);
        log.info("regist APIServlet servelet for {} urlMappings", lf_tDDOrHmc);
        return lf_d3bkOO4D;
    }

    @Bean
    public ServletRegistrationBean m_U3S9fEb1() {
        ServletRegistrationBean lf_x2QqWIBP = new ServletRegistrationBean(gf_E3ACVu2J);
        lf_x2QqWIBP.addUrlMappings("/token/generate");
        log.info("regist tokenServlet servelet ");
        return lf_x2QqWIBP;
    }
}
