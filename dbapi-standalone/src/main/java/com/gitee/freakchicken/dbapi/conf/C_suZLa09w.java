package com.gitee.freakchicken.dbapi.conf;

import com.gitee.freakchicken.dbapi.basic.servlet.C_jnrXyp58;
import com.gitee.freakchicken.dbapi.basic.servlet.C_aVi3Uyyt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class C_suZLa09w {

    @Value("${dbapi.api.context}")
    private String gf_aQKE46iJ;

    @Autowired
    private C_jnrXyp58 gf_YIv9xBH1;

    @Autowired
    private C_aVi3Uyyt gf_XQiA3EOh;

    @Bean
    public ServletRegistrationBean m_aRN9r99s() {
        String lf_RPWwfa1q = String.format("/%s/*", gf_aQKE46iJ);
        ServletRegistrationBean lf_zJDS1IMY = new ServletRegistrationBean(gf_YIv9xBH1);
        lf_zJDS1IMY.addUrlMappings(lf_RPWwfa1q);
        log.info("regist APIServlet servelet for {} urlMappings", lf_RPWwfa1q);
        return lf_zJDS1IMY;
    }

    @Bean
    public ServletRegistrationBean m_LtFYDSTx() {
        ServletRegistrationBean lf_adBOfoqG = new ServletRegistrationBean(gf_XQiA3EOh);
        lf_adBOfoqG.addUrlMappings("/token/generate");
        log.info("regist tokenServlet servelet ");
        return lf_adBOfoqG;
    }
}
