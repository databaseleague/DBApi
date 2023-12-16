package com.gitee.freakchicken.dbapi.basic.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class C_hcoi1UE1 implements WebMvcConfigurer {

    @Autowired
    C_ZjARMek1 gf_rY0uF48I;

    @Override
    public void addInterceptors(InterceptorRegistry p_J9M7t76p) {
        List<String> lf_1oBfrxBO = new ArrayList<>();
        lf_1oBfrxBO.add("/user/login");
        lf_1oBfrxBO.add("/token/generate");
        lf_1oBfrxBO.add("/access/**");
        lf_1oBfrxBO.add("/js/**");
        lf_1oBfrxBO.add("/css/**");
        lf_1oBfrxBO.add("/fonts/**");
        lf_1oBfrxBO.add("/index.html");
        lf_1oBfrxBO.add("/error");
        p_J9M7t76p.addInterceptor(gf_rY0uF48I).excludePathPatterns(lf_1oBfrxBO).addPathPatterns("/**");
    }
}
