package com.gitee.freakchicken.dbapi.conf;

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
public class C_uLakL4Rc {

    @Value("${dbapi.api.context}")
    private String gf_pQ563iwN;

    @Autowired
    private C_3GYv6aXr gf_DPISgyQE;

    @Autowired
    private C_cDqwG3fa gf_9BpX86el;

    @Bean
    public ServletRegistrationBean m_ZMat4CJ0() {
        String lf_dtUo2u0Z = String.format("/%s/*", gf_pQ563iwN);
        ServletRegistrationBean lf_AOtPieFn = new ServletRegistrationBean(gf_DPISgyQE);
        lf_AOtPieFn.addUrlMappings(lf_dtUo2u0Z);
        log.info("regist APIServlet servelet for {} urlMappings", lf_dtUo2u0Z);
        return lf_AOtPieFn;
    }

    @Bean
    public ServletRegistrationBean m_8aCjgvv4() {
        ServletRegistrationBean lf_yHHp8BK9 = new ServletRegistrationBean(gf_9BpX86el);
        lf_yHHp8BK9.addUrlMappings("/token/generate");
        log.info("regist tokenServlet servelet ");
        return lf_yHHp8BK9;
    }
}
