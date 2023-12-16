package com.gitee.freakchicken.dbapi.apiserver.conf;

import com.gitee.freakchicken.dbapi.basic.filter.C_rAueO4PQ;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class C_Yf1wXTs9 {

    @Value("${dbapi.api.context}")
    String gf_EVM8EPpy;

    @Autowired
    private C_rAueO4PQ gf_114S3lCQ;

    @Bean
    public FilterRegistrationBean m_92AWJn6V() {
        int lf_IPOCW7EP = 2;
        String lf_h76A2FQE = String.format("/%s/*", gf_EVM8EPpy);
        FilterRegistrationBean lf_PjNcgn2Y = new FilterRegistrationBean();
        lf_PjNcgn2Y.setFilter(gf_114S3lCQ);
        lf_PjNcgn2Y.addUrlPatterns(lf_h76A2FQE);
        lf_PjNcgn2Y.setOrder(lf_IPOCW7EP);
        lf_PjNcgn2Y.setEnabled(true);
        log.info("regist authFilter for {} UrlPatterns, and order is {}", lf_h76A2FQE, lf_IPOCW7EP);
        return lf_PjNcgn2Y;
    }
}
