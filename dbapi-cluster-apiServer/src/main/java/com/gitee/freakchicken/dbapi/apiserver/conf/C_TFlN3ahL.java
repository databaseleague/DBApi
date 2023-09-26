package com.gitee.freakchicken.dbapi.apiserver.conf;

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
public class C_TFlN3ahL {

    @Value("${dbapi.api.context}")
    String gf_QODq6MGl;

    @Autowired
    private C_oMSdtsf7 gf_0asa8F5q;

    @Autowired
    private C_eAODpKLZ gf_IhT8nnaw;

    @Bean
    public ServletRegistrationBean m_gWT6bMns() {
        String lf_hGrBZUhE = String.format("/%s/*", gf_QODq6MGl);
        ServletRegistrationBean lf_Rq37PWJF = new ServletRegistrationBean(gf_0asa8F5q);
        lf_Rq37PWJF.addUrlMappings(lf_hGrBZUhE);
        log.info("regist APIServlet servelet for {} urlMappings", lf_hGrBZUhE);
        return lf_Rq37PWJF;
    }

    @Bean
    public ServletRegistrationBean m_X0HE8VAe() {
        ServletRegistrationBean lf_x2PlgM8n = new ServletRegistrationBean(gf_IhT8nnaw);
        lf_x2PlgM8n.addUrlMappings("/token/generate");
        log.info("regist tokenServlet servelet");
        return lf_x2PlgM8n;
    }
}
