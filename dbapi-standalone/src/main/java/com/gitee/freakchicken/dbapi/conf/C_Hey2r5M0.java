package com.gitee.freakchicken.dbapi.conf;

import com.gitee.freakchicken.dbapi.basic.filter.C_eMKjcoVp;
import com.gitee.freakchicken.dbapi.basic.filter.C_7if65gdx;
import com.gitee.freakchicken.dbapi.basic.filter.C_RjRxv4ql;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class C_Hey2r5M0 {

    @Value("${dbapi.api.context}")
    private String gf_0psbojaj;

    @Autowired
    private C_RjRxv4ql gf_U1xHgSAz;

    @Autowired
    private C_eMKjcoVp gf_Ynh9MkC7;

    @Bean
    public FilterRegistrationBean m_5saJE5Bn() {
        int lf_nhic1de2 = 1;
        String lf_0u6j3kJE = String.format("/%s/*", gf_0psbojaj);
        FilterRegistrationBean lf_8e48uqP5 = new FilterRegistrationBean();
        lf_8e48uqP5.setFilter(new C_7if65gdx());
        lf_8e48uqP5.addUrlPatterns(lf_0u6j3kJE);
        lf_8e48uqP5.addUrlPatterns("/token/generate");
        lf_8e48uqP5.setOrder(lf_nhic1de2);
        lf_8e48uqP5.setEnabled(true);
        log.info("regist apiHeaderFilter for {} UrlPatterns, and order is {}", lf_0u6j3kJE, lf_nhic1de2);
        return lf_8e48uqP5;
    }

    @Bean
    public FilterRegistrationBean m_qPb7ZNOX() {
        int lf_09gdaEUj = 2;
        String lf_kcHluWBI = String.format("/%s/*", gf_0psbojaj);
        FilterRegistrationBean lf_p1BsDpIN = new FilterRegistrationBean();
        lf_p1BsDpIN.setFilter(gf_U1xHgSAz);
        lf_p1BsDpIN.addUrlPatterns(lf_kcHluWBI);
        lf_p1BsDpIN.setOrder(lf_09gdaEUj);
        lf_p1BsDpIN.setEnabled(true);
        log.info("regist ipFilter for {} UrlPatterns, and order is {}", lf_kcHluWBI, lf_09gdaEUj);
        return lf_p1BsDpIN;
    }

    @Bean
    public FilterRegistrationBean m_3ID9FDOe() {
        int lf_iRY32FsO = 3;
        String lf_eGOqK8dC = String.format("/%s/*", gf_0psbojaj);
        FilterRegistrationBean lf_rRQ4r2vx = new FilterRegistrationBean();
        lf_rRQ4r2vx.setFilter(gf_Ynh9MkC7);
        lf_rRQ4r2vx.addUrlPatterns(lf_eGOqK8dC);
        lf_rRQ4r2vx.setOrder(lf_iRY32FsO);
        lf_rRQ4r2vx.setEnabled(true);
        log.info("regist authFilter for {} UrlPatterns, and order is {}", lf_eGOqK8dC, lf_iRY32FsO);
        return lf_rRQ4r2vx;
    }
}
