package com.gitee.freakchicken.dbapi.apiserver.conf;

import com.gitee.freakchicken.dbapi.basic.filter.C_at6U0t7u;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class C_ve4S2nVT {

    @Value("${dbapi.api.context}")
    String gf_MFtSCyjT;

    @Autowired
    private C_at6U0t7u gf_EmcsDRIY;

    @Bean
    public FilterRegistrationBean m_oyqJfGgo() {
        int lf_XVayo5Hl = 2;
        String lf_uiwQ8dCH = String.format("/%s/*", gf_MFtSCyjT);
        FilterRegistrationBean lf_bKuhV8z4 = new FilterRegistrationBean();
        lf_bKuhV8z4.setFilter(gf_EmcsDRIY);
        lf_bKuhV8z4.addUrlPatterns(lf_uiwQ8dCH);
        lf_bKuhV8z4.setOrder(lf_XVayo5Hl);
        lf_bKuhV8z4.setEnabled(true);
        log.info("regist authFilter for {} UrlPatterns, and order is {}", lf_uiwQ8dCH, lf_XVayo5Hl);
        return lf_bKuhV8z4;
    }
}
