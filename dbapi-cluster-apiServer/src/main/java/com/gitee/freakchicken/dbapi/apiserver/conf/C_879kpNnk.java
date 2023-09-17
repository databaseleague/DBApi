package com.gitee.freakchicken.dbapi.apiserver.conf;

import com.gitee.freakchicken.dbapi.basic.servlet.C_3GYv6aXr;
import com.gitee.freakchicken.dbapi.basic.servlet.C_cDqwG3fa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class C_879kpNnk {

    @Value("${dbapi.api.context}")
    String gf_lQ79uLKF;

    @Autowired
    private C_3GYv6aXr gf_1DJbT7D7;

    @Autowired
    private C_cDqwG3fa gf_p8b32IlF;

    @Bean
    public ServletRegistrationBean m_3hl8SGWn() {
        String lf_1xQbuwPt = String.format("/%s/*", gf_lQ79uLKF);
        ServletRegistrationBean lf_dTCOPAYx = new ServletRegistrationBean(gf_1DJbT7D7);
        lf_dTCOPAYx.addUrlMappings(lf_1xQbuwPt);
        log.info("regist APIServlet servelet for {} urlMappings", lf_1xQbuwPt);
        return lf_dTCOPAYx;
    }

    @Bean
    public ServletRegistrationBean m_2IZlQu5f() {
        ServletRegistrationBean lf_GGfbffCB = new ServletRegistrationBean(gf_p8b32IlF);
        lf_GGfbffCB.addUrlMappings("/token/generate");
        log.info("regist tokenServlet servelet");
        return lf_GGfbffCB;
    }
}
