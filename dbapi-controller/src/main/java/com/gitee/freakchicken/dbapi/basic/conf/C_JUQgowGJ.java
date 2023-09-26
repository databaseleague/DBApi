package com.gitee.freakchicken.dbapi.basic.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class C_JUQgowGJ implements WebMvcConfigurer {

    @Autowired
    C_mVqlya6Y gf_NI3t3uqn;

    @Override
    public void addInterceptors(InterceptorRegistry p_QpgwWRVB) {
        List<String> lf_rFdW0ESF = new ArrayList<>();
        lf_rFdW0ESF.add("/user/login");
        lf_rFdW0ESF.add("/token/generate");
        lf_rFdW0ESF.add("/access/**");
        lf_rFdW0ESF.add("/js/**");
        lf_rFdW0ESF.add("/css/**");
        lf_rFdW0ESF.add("/fonts/**");
        lf_rFdW0ESF.add("/index.html");
        lf_rFdW0ESF.add("/error");
        p_QpgwWRVB.addInterceptor(gf_NI3t3uqn).excludePathPatterns(lf_rFdW0ESF).addPathPatterns("/**");
    }
}
