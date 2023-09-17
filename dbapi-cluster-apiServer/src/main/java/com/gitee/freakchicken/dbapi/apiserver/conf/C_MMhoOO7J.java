package com.gitee.freakchicken.dbapi.apiserver.conf;

import com.gitee.freakchicken.dbapi.basic.filter.C_plKIrOLB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class C_MMhoOO7J {

    @Value("${dbapi.api.context}")
    String gf_Tv2ETUEl;

    @Autowired
    private C_plKIrOLB gf_jlTjkhDL;

    @Bean
    public FilterRegistrationBean m_EIIGqTkf() {
        int lf_C4IAXcOA = 2;
        String lf_s6Y8w7B8 = String.format("/%s/*", gf_Tv2ETUEl);
        FilterRegistrationBean lf_7SySfMwu = new FilterRegistrationBean();
        lf_7SySfMwu.setFilter(gf_jlTjkhDL);
        lf_7SySfMwu.addUrlPatterns(lf_s6Y8w7B8);
        lf_7SySfMwu.setOrder(lf_C4IAXcOA);
        lf_7SySfMwu.setEnabled(true);
        log.info("regist authFilter for {} UrlPatterns, and order is {}", lf_s6Y8w7B8, lf_C4IAXcOA);
        return lf_7SySfMwu;
    }
}
