package com.gitee.freakchicken.dbapi.apiserver.conf;

import com.gitee.freakchicken.dbapi.basic.filter.C_iyc134pU;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class C_OW3sYina {

    @Value("${dbapi.api.context}")
    String gf_fZLziFoa;

    @Autowired
    private C_iyc134pU gf_geHQSOji;

    @Bean
    public FilterRegistrationBean m_qdNO3rri() {
        int lf_snHMOsXY = 2;
        String lf_FutOYK7k = String.format("/%s/*", gf_fZLziFoa);
        FilterRegistrationBean lf_gCKRL7lI = new FilterRegistrationBean();
        lf_gCKRL7lI.setFilter(gf_geHQSOji);
        lf_gCKRL7lI.addUrlPatterns(lf_FutOYK7k);
        lf_gCKRL7lI.setOrder(lf_snHMOsXY);
        lf_gCKRL7lI.setEnabled(true);
        log.info("regist authFilter for {} UrlPatterns, and order is {}", lf_FutOYK7k, lf_snHMOsXY);
        return lf_gCKRL7lI;
    }
}
