package com.gitee.freakchicken.dbapi.conf;

import com.gitee.freakchicken.dbapi.basic.servlet.C_Yzpdk6am;
import com.gitee.freakchicken.dbapi.basic.servlet.C_WUFXj6i9;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class C_LKj2ZFqf {

    @Value("${dbapi.api.context}")
    private String gf_fDGctzBB;

    @Autowired
    private C_Yzpdk6am gf_s2W9ywDQ;

    @Autowired
    private C_WUFXj6i9 gf_9BNsdqjI;

    @Bean
    public ServletRegistrationBean m_bETdql3e() {
        String lf_tHBG9AEy = String.format("/%s/*", gf_fDGctzBB);
        ServletRegistrationBean lf_CZKGRpWv = new ServletRegistrationBean(gf_s2W9ywDQ);
        lf_CZKGRpWv.addUrlMappings(lf_tHBG9AEy);
        log.info("regist APIServlet servelet for {} urlMappings", lf_tHBG9AEy);
        return lf_CZKGRpWv;
    }

    @Bean
    public ServletRegistrationBean m_e7LwXd7t() {
        ServletRegistrationBean lf_WcGHOuZf = new ServletRegistrationBean(gf_9BNsdqjI);
        lf_WcGHOuZf.addUrlMappings("/token/generate");
        log.info("regist tokenServlet servelet ");
        return lf_WcGHOuZf;
    }
}
