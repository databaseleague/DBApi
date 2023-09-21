package com.gitee.freakchicken.dbapi.conf;

import com.gitee.freakchicken.dbapi.basic.servlet.C_dlPkPNdI;
import com.gitee.freakchicken.dbapi.basic.servlet.C_wrChm4qv;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class C_0hTAsNCt {

    @Value("${dbapi.api.context}")
    private String gf_q4sHpoBZ;

    @Autowired
    private C_dlPkPNdI gf_VaW7AGHx;

    @Autowired
    private C_wrChm4qv gf_oPtCiLbn;

    @Bean
    public ServletRegistrationBean m_Qg9brWLi() {
        String lf_laGLDN65 = String.format("/%s/*", gf_q4sHpoBZ);
        ServletRegistrationBean lf_MbJEoFBA = new ServletRegistrationBean(gf_VaW7AGHx);
        lf_MbJEoFBA.addUrlMappings(lf_laGLDN65);
        log.info("regist APIServlet servelet for {} urlMappings", lf_laGLDN65);
        return lf_MbJEoFBA;
    }

    @Bean
    public ServletRegistrationBean m_wnKMHjrl() {
        ServletRegistrationBean lf_oX10PkiE = new ServletRegistrationBean(gf_oPtCiLbn);
        lf_oX10PkiE.addUrlMappings("/token/generate");
        log.info("regist tokenServlet servelet ");
        return lf_oX10PkiE;
    }
}
