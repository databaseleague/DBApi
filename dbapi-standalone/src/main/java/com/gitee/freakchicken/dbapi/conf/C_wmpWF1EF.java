package com.gitee.freakchicken.dbapi.conf;

import com.gitee.freakchicken.dbapi.basic.filter.C_iyc134pU;
import com.gitee.freakchicken.dbapi.basic.filter.C_LwL56PNq;
import com.gitee.freakchicken.dbapi.basic.filter.C_Hu3QaGGq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class C_wmpWF1EF {

    @Value("${dbapi.api.context}")
    private String gf_cNTtffsR;

    @Autowired
    private C_Hu3QaGGq gf_mTVjoT5M;

    @Autowired
    private C_iyc134pU gf_lU0e7eqi;

    @Bean
    public FilterRegistrationBean m_h7PaLIGP() {
        int lf_2uKCCVLo = 1;
        String lf_KjvF7kNu = String.format("/%s/*", gf_cNTtffsR);
        FilterRegistrationBean lf_ELCl4M9z = new FilterRegistrationBean();
        lf_ELCl4M9z.setFilter(new C_LwL56PNq());
        lf_ELCl4M9z.addUrlPatterns(lf_KjvF7kNu);
        lf_ELCl4M9z.addUrlPatterns("/token/generate");
        lf_ELCl4M9z.setOrder(lf_2uKCCVLo);
        lf_ELCl4M9z.setEnabled(true);
        log.info("regist apiHeaderFilter for {} UrlPatterns, and order is {}", lf_KjvF7kNu, lf_2uKCCVLo);
        return lf_ELCl4M9z;
    }

    @Bean
    public FilterRegistrationBean m_RkP09ImE() {
        int lf_U6RcnGIi = 2;
        String lf_lguV0ovV = String.format("/%s/*", gf_cNTtffsR);
        FilterRegistrationBean lf_lDCO3TqD = new FilterRegistrationBean();
        lf_lDCO3TqD.setFilter(gf_mTVjoT5M);
        lf_lDCO3TqD.addUrlPatterns(lf_lguV0ovV);
        lf_lDCO3TqD.setOrder(lf_U6RcnGIi);
        lf_lDCO3TqD.setEnabled(true);
        log.info("regist ipFilter for {} UrlPatterns, and order is {}", lf_lguV0ovV, lf_U6RcnGIi);
        return lf_lDCO3TqD;
    }

    @Bean
    public FilterRegistrationBean m_1BASNDNQ() {
        int lf_3UOsmVgO = 3;
        String lf_GNKbzvoA = String.format("/%s/*", gf_cNTtffsR);
        FilterRegistrationBean lf_Eq0VFFk0 = new FilterRegistrationBean();
        lf_Eq0VFFk0.setFilter(gf_lU0e7eqi);
        lf_Eq0VFFk0.addUrlPatterns(lf_GNKbzvoA);
        lf_Eq0VFFk0.setOrder(lf_3UOsmVgO);
        lf_Eq0VFFk0.setEnabled(true);
        log.info("regist authFilter for {} UrlPatterns, and order is {}", lf_GNKbzvoA, lf_3UOsmVgO);
        return lf_Eq0VFFk0;
    }
}
