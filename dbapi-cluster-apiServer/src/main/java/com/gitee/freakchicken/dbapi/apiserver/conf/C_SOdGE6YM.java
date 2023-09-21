package com.gitee.freakchicken.dbapi.apiserver.conf;

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
public class C_SOdGE6YM {

    @Value("${dbapi.api.context}")
    String gf_LELnzwoZ;

    @Autowired
    private C_dlPkPNdI gf_6i3TM1rl;

    @Autowired
    private C_wrChm4qv gf_yS0GI1Ld;

    @Bean
    public ServletRegistrationBean m_Pz7MF4L5() {
        String lf_j3FkIEFE = String.format("/%s/*", gf_LELnzwoZ);
        ServletRegistrationBean lf_28NHxi9M = new ServletRegistrationBean(gf_6i3TM1rl);
        lf_28NHxi9M.addUrlMappings(lf_j3FkIEFE);
        log.info("regist APIServlet servelet for {} urlMappings", lf_j3FkIEFE);
        return lf_28NHxi9M;
    }

    @Bean
    public ServletRegistrationBean m_CG2UoJGv() {
        ServletRegistrationBean lf_oWDsH8AX = new ServletRegistrationBean(gf_yS0GI1Ld);
        lf_oWDsH8AX.addUrlMappings("/token/generate");
        log.info("regist tokenServlet servelet");
        return lf_oWDsH8AX;
    }
}
