package com.gitee.freakchicken.dbapi.apiserver.conf;

import com.gitee.freakchicken.dbapi.basic.filter.C_4xOee9tS;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class C_igGifI6L {

    @Value("${dbapi.api.context}")
    String gf_64CyTr7w;

    @Autowired
    private C_4xOee9tS gf_udnHHaPc;

    @Bean
    public FilterRegistrationBean m_ptadUU35() {
        int lf_yGOSiyNT = 2;
        String lf_pLkK7Obs = String.format("/%s/*", gf_64CyTr7w);
        FilterRegistrationBean lf_P2I402nI = new FilterRegistrationBean();
        lf_P2I402nI.setFilter(gf_udnHHaPc);
        lf_P2I402nI.addUrlPatterns(lf_pLkK7Obs);
        lf_P2I402nI.setOrder(lf_yGOSiyNT);
        lf_P2I402nI.setEnabled(true);
        log.info("regist authFilter for {} UrlPatterns, and order is {}", lf_pLkK7Obs, lf_yGOSiyNT);
        return lf_P2I402nI;
    }
}
