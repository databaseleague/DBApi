package com.gitee.freakchicken.dbapi.apiserver.conf;

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
public class C_7tXfbGmo {

    @Value("${dbapi.api.context}")
    String gf_ERPiXFgG;

    @Autowired
    private C_jnrXyp58 gf_IUA5YhPw;

    @Autowired
    private C_aVi3Uyyt gf_EcErapVB;

    @Bean
    public ServletRegistrationBean m_PUjtEL5C() {
        String lf_fCEzHjke = String.format("/%s/*", gf_ERPiXFgG);
        ServletRegistrationBean lf_CHcXWTuw = new ServletRegistrationBean(gf_IUA5YhPw);
        lf_CHcXWTuw.addUrlMappings(lf_fCEzHjke);
        log.info("regist APIServlet servelet for {} urlMappings", lf_fCEzHjke);
        return lf_CHcXWTuw;
    }

    @Bean
    public ServletRegistrationBean m_8dw6gif9() {
        ServletRegistrationBean lf_sn3ybAvB = new ServletRegistrationBean(gf_EcErapVB);
        lf_sn3ybAvB.addUrlMappings("/token/generate");
        log.info("regist tokenServlet servelet");
        return lf_sn3ybAvB;
    }
}
