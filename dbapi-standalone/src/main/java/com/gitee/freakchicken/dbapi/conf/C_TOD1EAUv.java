package com.gitee.freakchicken.dbapi.conf;

import com.gitee.freakchicken.dbapi.basic.servlet.C_oMSdtsf7;
import com.gitee.freakchicken.dbapi.basic.servlet.C_eAODpKLZ;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class C_TOD1EAUv {

    @Value("${dbapi.api.context}")
    private String gf_dPnFcZ4w;

    @Autowired
    private C_oMSdtsf7 gf_1hdu7kLC;

    @Autowired
    private C_eAODpKLZ gf_QG7NpFVo;

    @Bean
    public ServletRegistrationBean m_DCExsDu2() {
        String lf_8PxxYdhH = String.format("/%s/*", gf_dPnFcZ4w);
        ServletRegistrationBean lf_9Ayi2A27 = new ServletRegistrationBean(gf_1hdu7kLC);
        lf_9Ayi2A27.addUrlMappings(lf_8PxxYdhH);
        log.info("regist APIServlet servelet for {} urlMappings", lf_8PxxYdhH);
        return lf_9Ayi2A27;
    }

    @Bean
    public ServletRegistrationBean m_zW5UhcgI() {
        ServletRegistrationBean lf_ZrKj3Je8 = new ServletRegistrationBean(gf_QG7NpFVo);
        lf_ZrKj3Je8.addUrlMappings("/token/generate");
        log.info("regist tokenServlet servelet ");
        return lf_ZrKj3Je8;
    }
}
