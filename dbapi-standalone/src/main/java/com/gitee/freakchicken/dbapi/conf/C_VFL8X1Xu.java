package com.gitee.freakchicken.dbapi.conf;

import com.gitee.freakchicken.dbapi.basic.filter.C_VK9rHJjF;
import com.gitee.freakchicken.dbapi.basic.filter.C_JRt1YU6B;
import com.gitee.freakchicken.dbapi.basic.filter.C_vgXUEg76;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class C_VFL8X1Xu {

    @Value("${dbapi.api.context}")
    private String gf_oZliIYH3;

    @Autowired
    private C_vgXUEg76 gf_CBUZoiog;

    @Autowired
    private C_VK9rHJjF gf_SIFb5W3n;

    @Bean
    public FilterRegistrationBean m_V5EOoTVO() {
        int lf_nIo5b5wE = 1;
        String lf_QVlZsaPz = String.format("/%s/*", gf_oZliIYH3);
        FilterRegistrationBean lf_NjzrXMOX = new FilterRegistrationBean();
        lf_NjzrXMOX.setFilter(new C_JRt1YU6B());
        lf_NjzrXMOX.addUrlPatterns(lf_QVlZsaPz);
        lf_NjzrXMOX.addUrlPatterns("/token/generate");
        lf_NjzrXMOX.setOrder(lf_nIo5b5wE);
        lf_NjzrXMOX.setEnabled(true);
        log.info("regist apiHeaderFilter for {} UrlPatterns, and order is {}", lf_QVlZsaPz, lf_nIo5b5wE);
        return lf_NjzrXMOX;
    }

    @Bean
    public FilterRegistrationBean m_Q4hALnJp() {
        int lf_TghGB7Ly = 2;
        String lf_vNOGTEJT = String.format("/%s/*", gf_oZliIYH3);
        FilterRegistrationBean lf_Wurp8JBH = new FilterRegistrationBean();
        lf_Wurp8JBH.setFilter(gf_CBUZoiog);
        lf_Wurp8JBH.addUrlPatterns(lf_vNOGTEJT);
        lf_Wurp8JBH.setOrder(lf_TghGB7Ly);
        lf_Wurp8JBH.setEnabled(true);
        log.info("regist ipFilter for {} UrlPatterns, and order is {}", lf_vNOGTEJT, lf_TghGB7Ly);
        return lf_Wurp8JBH;
    }

    @Bean
    public FilterRegistrationBean m_kLAIJ4tq() {
        int lf_8zoPcDdq = 3;
        String lf_VG5BSxdh = String.format("/%s/*", gf_oZliIYH3);
        FilterRegistrationBean lf_nbzPTjf3 = new FilterRegistrationBean();
        lf_nbzPTjf3.setFilter(gf_SIFb5W3n);
        lf_nbzPTjf3.addUrlPatterns(lf_VG5BSxdh);
        lf_nbzPTjf3.setOrder(lf_8zoPcDdq);
        lf_nbzPTjf3.setEnabled(true);
        log.info("regist authFilter for {} UrlPatterns, and order is {}", lf_VG5BSxdh, lf_8zoPcDdq);
        return lf_nbzPTjf3;
    }
}
