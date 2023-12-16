package com.gitee.freakchicken.dbapi.conf;

import com.gitee.freakchicken.dbapi.basic.filter.C_rAueO4PQ;
import com.gitee.freakchicken.dbapi.basic.filter.C_JF9BuKDl;
import com.gitee.freakchicken.dbapi.basic.filter.C_d2YsshBs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class C_4hqt8caG {

    @Value("${dbapi.api.context}")
    private String gf_nJxfSDLJ;

    @Autowired
    private C_d2YsshBs gf_wDQ10MMp;

    @Autowired
    private C_rAueO4PQ gf_OwD13Dxd;

    @Bean
    public FilterRegistrationBean m_MoV8b7ka() {
        int lf_DTSDfaZV = 1;
        String lf_XYw76SCE = String.format("/%s/*", gf_nJxfSDLJ);
        FilterRegistrationBean lf_SGMAckTn = new FilterRegistrationBean();
        lf_SGMAckTn.setFilter(new C_JF9BuKDl());
        lf_SGMAckTn.addUrlPatterns(lf_XYw76SCE);
        lf_SGMAckTn.addUrlPatterns("/token/generate");
        lf_SGMAckTn.setOrder(lf_DTSDfaZV);
        lf_SGMAckTn.setEnabled(true);
        log.info("regist apiHeaderFilter for {} UrlPatterns, and order is {}", lf_XYw76SCE, lf_DTSDfaZV);
        return lf_SGMAckTn;
    }

    @Bean
    public FilterRegistrationBean m_WNiloZJj() {
        int lf_azHYrISE = 2;
        String lf_qPHg0N42 = String.format("/%s/*", gf_nJxfSDLJ);
        FilterRegistrationBean lf_ngmAF1y0 = new FilterRegistrationBean();
        lf_ngmAF1y0.setFilter(gf_wDQ10MMp);
        lf_ngmAF1y0.addUrlPatterns(lf_qPHg0N42);
        lf_ngmAF1y0.setOrder(lf_azHYrISE);
        lf_ngmAF1y0.setEnabled(true);
        log.info("regist ipFilter for {} UrlPatterns, and order is {}", lf_qPHg0N42, lf_azHYrISE);
        return lf_ngmAF1y0;
    }

    @Bean
    public FilterRegistrationBean m_YPRG1PhC() {
        int lf_8Q0JiTJQ = 3;
        String lf_iP5TNKDL = String.format("/%s/*", gf_nJxfSDLJ);
        FilterRegistrationBean lf_Fk9xZTkz = new FilterRegistrationBean();
        lf_Fk9xZTkz.setFilter(gf_OwD13Dxd);
        lf_Fk9xZTkz.addUrlPatterns(lf_iP5TNKDL);
        lf_Fk9xZTkz.setOrder(lf_8Q0JiTJQ);
        lf_Fk9xZTkz.setEnabled(true);
        log.info("regist authFilter for {} UrlPatterns, and order is {}", lf_iP5TNKDL, lf_8Q0JiTJQ);
        return lf_Fk9xZTkz;
    }
}
