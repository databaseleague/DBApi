package com.gitee.freakchicken.dbapi.apiserver.conf;

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
public class C_0C14pfQO {

    @Value("${dbapi.api.context}")
    String gf_oXHucsl1;

    @Autowired
    private C_9E6wG0qK gf_W7NAABUm;

    @Autowired
    private C_lvYe4Hv8 gf_ZxXlFaEN;

    @Bean
    public ServletRegistrationBean m_b5Loe4Vi() {
        String lf_oni9UGTa = String.format("/%s/*", gf_oXHucsl1);
        ServletRegistrationBean lf_ANnERXtB = new ServletRegistrationBean(gf_W7NAABUm);
        lf_ANnERXtB.addUrlMappings(lf_oni9UGTa);
        log.info("regist APIServlet servelet for {} urlMappings", lf_oni9UGTa);
        return lf_ANnERXtB;
    }

    @Bean
    public ServletRegistrationBean m_VbuprYBN() {
        ServletRegistrationBean lf_HuzWyoPu = new ServletRegistrationBean(gf_ZxXlFaEN);
        lf_HuzWyoPu.addUrlMappings("/token/generate");
        log.info("regist tokenServlet servelet");
        return lf_HuzWyoPu;
    }
}
