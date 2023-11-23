package com.gitee.freakchicken.dbapi.apiserver.conf;

import com.gitee.freakchicken.dbapi.basic.filter.C_eMKjcoVp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class C_XrEFaHuN {

    @Value("${dbapi.api.context}")
    String gf_F3YSNlOr;

    @Autowired
    private C_eMKjcoVp gf_zdJNSQ5u;

    @Bean
    public FilterRegistrationBean m_lzHIMKGo() {
        int lf_USFNKYFz = 2;
        String lf_Kj4b4qCg = String.format("/%s/*", gf_F3YSNlOr);
        FilterRegistrationBean lf_aCeSXZlM = new FilterRegistrationBean();
        lf_aCeSXZlM.setFilter(gf_zdJNSQ5u);
        lf_aCeSXZlM.addUrlPatterns(lf_Kj4b4qCg);
        lf_aCeSXZlM.setOrder(lf_USFNKYFz);
        lf_aCeSXZlM.setEnabled(true);
        log.info("regist authFilter for {} UrlPatterns, and order is {}", lf_Kj4b4qCg, lf_USFNKYFz);
        return lf_aCeSXZlM;
    }
}
