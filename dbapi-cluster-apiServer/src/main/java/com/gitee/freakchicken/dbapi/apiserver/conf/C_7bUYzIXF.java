package com.gitee.freakchicken.dbapi.apiserver.conf;

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
public class C_7bUYzIXF {

    @Value("${dbapi.api.context}")
    String gf_wzBoVmuR;

    @Autowired
    private C_Yzpdk6am gf_D2cfqTx9;

    @Autowired
    private C_WUFXj6i9 gf_NPOl35fZ;

    @Bean
    public ServletRegistrationBean m_ASUqu04F() {
        String lf_HHcFPBIr = String.format("/%s/*", gf_wzBoVmuR);
        ServletRegistrationBean lf_kQ7ZbSqh = new ServletRegistrationBean(gf_D2cfqTx9);
        lf_kQ7ZbSqh.addUrlMappings(lf_HHcFPBIr);
        log.info("regist APIServlet servelet for {} urlMappings", lf_HHcFPBIr);
        return lf_kQ7ZbSqh;
    }

    @Bean
    public ServletRegistrationBean m_JRs4zpI4() {
        ServletRegistrationBean lf_t8vpiXxu = new ServletRegistrationBean(gf_NPOl35fZ);
        lf_t8vpiXxu.addUrlMappings("/token/generate");
        log.info("regist tokenServlet servelet");
        return lf_t8vpiXxu;
    }
}
