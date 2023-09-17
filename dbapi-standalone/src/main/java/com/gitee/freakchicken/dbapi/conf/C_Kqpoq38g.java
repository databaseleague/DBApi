package com.gitee.freakchicken.dbapi.conf;

import com.gitee.freakchicken.dbapi.basic.filter.C_at6U0t7u;
import com.gitee.freakchicken.dbapi.basic.filter.C_rJaKNctr;
import com.gitee.freakchicken.dbapi.basic.filter.C_wm36KnqW;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class C_Kqpoq38g {

    @Value("${dbapi.api.context}")
    private String gf_t7oC8I8D;

    @Autowired
    private C_wm36KnqW gf_y6ID7VSG;

    @Autowired
    private C_at6U0t7u gf_V497p7B4;

    @Bean
    public FilterRegistrationBean m_1EmlIIzN() {
        int lf_00vNSK7s = 1;
        String lf_tiRFtRQ4 = String.format("/%s/*", gf_t7oC8I8D);
        FilterRegistrationBean lf_s3cKWYdd = new FilterRegistrationBean();
        lf_s3cKWYdd.setFilter(new C_rJaKNctr());
        lf_s3cKWYdd.addUrlPatterns(lf_tiRFtRQ4);
        lf_s3cKWYdd.addUrlPatterns("/token/generate");
        lf_s3cKWYdd.setOrder(lf_00vNSK7s);
        lf_s3cKWYdd.setEnabled(true);
        log.info("regist apiHeaderFilter for {} UrlPatterns, and order is {}", lf_tiRFtRQ4, lf_00vNSK7s);
        return lf_s3cKWYdd;
    }

    @Bean
    public FilterRegistrationBean m_SMgkIzYR() {
        int lf_CmfTdup6 = 2;
        String lf_W89M9LlV = String.format("/%s/*", gf_t7oC8I8D);
        FilterRegistrationBean lf_ffnxnlCZ = new FilterRegistrationBean();
        lf_ffnxnlCZ.setFilter(gf_y6ID7VSG);
        lf_ffnxnlCZ.addUrlPatterns(lf_W89M9LlV);
        lf_ffnxnlCZ.setOrder(lf_CmfTdup6);
        lf_ffnxnlCZ.setEnabled(true);
        log.info("regist ipFilter for {} UrlPatterns, and order is {}", lf_W89M9LlV, lf_CmfTdup6);
        return lf_ffnxnlCZ;
    }

    @Bean
    public FilterRegistrationBean m_03xEuJIc() {
        int lf_bGxeD3w4 = 3;
        String lf_6qP1PyXd = String.format("/%s/*", gf_t7oC8I8D);
        FilterRegistrationBean lf_YvjJFrHR = new FilterRegistrationBean();
        lf_YvjJFrHR.setFilter(gf_V497p7B4);
        lf_YvjJFrHR.addUrlPatterns(lf_6qP1PyXd);
        lf_YvjJFrHR.setOrder(lf_bGxeD3w4);
        lf_YvjJFrHR.setEnabled(true);
        log.info("regist authFilter for {} UrlPatterns, and order is {}", lf_6qP1PyXd, lf_bGxeD3w4);
        return lf_YvjJFrHR;
    }
}
