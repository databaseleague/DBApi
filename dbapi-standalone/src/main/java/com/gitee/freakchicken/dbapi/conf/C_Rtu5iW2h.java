package com.gitee.freakchicken.dbapi.conf;

import com.gitee.freakchicken.dbapi.basic.filter.C_plKIrOLB;
import com.gitee.freakchicken.dbapi.basic.filter.C_McBgbR7Z;
import com.gitee.freakchicken.dbapi.basic.filter.C_91YaCBqs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class C_Rtu5iW2h {

    @Value("${dbapi.api.context}")
    private String gf_P62spgC9;

    @Autowired
    private C_91YaCBqs gf_nwb85D8W;

    @Autowired
    private C_plKIrOLB gf_rAD9YvEx;

    @Bean
    public FilterRegistrationBean m_0wxOx4UJ() {
        int lf_uUdedTEi = 1;
        String lf_ZOMoBojE = String.format("/%s/*", gf_P62spgC9);
        FilterRegistrationBean lf_NKeIeNfz = new FilterRegistrationBean();
        lf_NKeIeNfz.setFilter(new C_McBgbR7Z());
        lf_NKeIeNfz.addUrlPatterns(lf_ZOMoBojE);
        lf_NKeIeNfz.addUrlPatterns("/token/generate");
        lf_NKeIeNfz.setOrder(lf_uUdedTEi);
        lf_NKeIeNfz.setEnabled(true);
        log.info("regist apiHeaderFilter for {} UrlPatterns, and order is {}", lf_ZOMoBojE, lf_uUdedTEi);
        return lf_NKeIeNfz;
    }

    @Bean
    public FilterRegistrationBean m_4EhVC2ik() {
        int lf_v5kQMV8Q = 2;
        String lf_72tuTyO1 = String.format("/%s/*", gf_P62spgC9);
        FilterRegistrationBean lf_wgCYP0Jr = new FilterRegistrationBean();
        lf_wgCYP0Jr.setFilter(gf_nwb85D8W);
        lf_wgCYP0Jr.addUrlPatterns(lf_72tuTyO1);
        lf_wgCYP0Jr.setOrder(lf_v5kQMV8Q);
        lf_wgCYP0Jr.setEnabled(true);
        log.info("regist ipFilter for {} UrlPatterns, and order is {}", lf_72tuTyO1, lf_v5kQMV8Q);
        return lf_wgCYP0Jr;
    }

    @Bean
    public FilterRegistrationBean m_MGBVPlnN() {
        int lf_JOuEA6a2 = 3;
        String lf_DHUanp2k = String.format("/%s/*", gf_P62spgC9);
        FilterRegistrationBean lf_P8HoEcER = new FilterRegistrationBean();
        lf_P8HoEcER.setFilter(gf_rAD9YvEx);
        lf_P8HoEcER.addUrlPatterns(lf_DHUanp2k);
        lf_P8HoEcER.setOrder(lf_JOuEA6a2);
        lf_P8HoEcER.setEnabled(true);
        log.info("regist authFilter for {} UrlPatterns, and order is {}", lf_DHUanp2k, lf_JOuEA6a2);
        return lf_P8HoEcER;
    }
}
