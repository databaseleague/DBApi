package com.gitee.freakchicken.dbapi.conf;

import com.gitee.freakchicken.dbapi.basic.filter.C_4xOee9tS;
import com.gitee.freakchicken.dbapi.basic.filter.C_VvvHxBMc;
import com.gitee.freakchicken.dbapi.basic.filter.C_9hKiJelE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class C_88hTRIot {

    @Value("${dbapi.api.context}")
    private String gf_NlRKim7t;

    @Autowired
    private C_9hKiJelE gf_r6sr1X42;

    @Autowired
    private C_4xOee9tS gf_7xFKEDV6;

    @Bean
    public FilterRegistrationBean m_sJs4IUl6() {
        int lf_OFmdYhuM = 1;
        String lf_WHM0oa0X = String.format("/%s/*", gf_NlRKim7t);
        FilterRegistrationBean lf_ymJxDlwq = new FilterRegistrationBean();
        lf_ymJxDlwq.setFilter(new C_VvvHxBMc());
        lf_ymJxDlwq.addUrlPatterns(lf_WHM0oa0X);
        lf_ymJxDlwq.addUrlPatterns("/token/generate");
        lf_ymJxDlwq.setOrder(lf_OFmdYhuM);
        lf_ymJxDlwq.setEnabled(true);
        log.info("regist apiHeaderFilter for {} UrlPatterns, and order is {}", lf_WHM0oa0X, lf_OFmdYhuM);
        return lf_ymJxDlwq;
    }

    @Bean
    public FilterRegistrationBean m_1BsfMpT8() {
        int lf_CpsnOaQJ = 2;
        String lf_zwc5Vy7d = String.format("/%s/*", gf_NlRKim7t);
        FilterRegistrationBean lf_8YOudtZM = new FilterRegistrationBean();
        lf_8YOudtZM.setFilter(gf_r6sr1X42);
        lf_8YOudtZM.addUrlPatterns(lf_zwc5Vy7d);
        lf_8YOudtZM.setOrder(lf_CpsnOaQJ);
        lf_8YOudtZM.setEnabled(true);
        log.info("regist ipFilter for {} UrlPatterns, and order is {}", lf_zwc5Vy7d, lf_CpsnOaQJ);
        return lf_8YOudtZM;
    }

    @Bean
    public FilterRegistrationBean m_5LAxRmy1() {
        int lf_Ab4za5y7 = 3;
        String lf_g1tRz2Dy = String.format("/%s/*", gf_NlRKim7t);
        FilterRegistrationBean lf_bgdexfbG = new FilterRegistrationBean();
        lf_bgdexfbG.setFilter(gf_7xFKEDV6);
        lf_bgdexfbG.addUrlPatterns(lf_g1tRz2Dy);
        lf_bgdexfbG.setOrder(lf_Ab4za5y7);
        lf_bgdexfbG.setEnabled(true);
        log.info("regist authFilter for {} UrlPatterns, and order is {}", lf_g1tRz2Dy, lf_Ab4za5y7);
        return lf_bgdexfbG;
    }
}
