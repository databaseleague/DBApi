package com.gitee.freakchicken.dbapi.apiserver.conf;

import com.gitee.freakchicken.dbapi.basic.filter.C_VK9rHJjF;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class C_lzj6PFWS {

    @Value("${dbapi.api.context}")
    String gf_t01eaY1X;

    @Autowired
    private C_VK9rHJjF gf_SM8Md6db;

    @Bean
    public FilterRegistrationBean m_oMfrVolM() {
        int lf_ImaHMUtL = 2;
        String lf_c4u3JTRB = String.format("/%s/*", gf_t01eaY1X);
        FilterRegistrationBean lf_DJyilTKq = new FilterRegistrationBean();
        lf_DJyilTKq.setFilter(gf_SM8Md6db);
        lf_DJyilTKq.addUrlPatterns(lf_c4u3JTRB);
        lf_DJyilTKq.setOrder(lf_ImaHMUtL);
        lf_DJyilTKq.setEnabled(true);
        log.info("regist authFilter for {} UrlPatterns, and order is {}", lf_c4u3JTRB, lf_ImaHMUtL);
        return lf_DJyilTKq;
    }
}
