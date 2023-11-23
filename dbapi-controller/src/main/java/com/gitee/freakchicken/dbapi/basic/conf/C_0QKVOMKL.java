package com.gitee.freakchicken.dbapi.basic.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class C_0QKVOMKL implements WebMvcConfigurer {

    @Autowired
    C_PA71bOjZ gf_C6bKT5p2;

    @Override
    public void addInterceptors(InterceptorRegistry p_xa406m9R) {
        List<String> lf_AW6P8w6m = new ArrayList<>();
        lf_AW6P8w6m.add("/user/login");
        lf_AW6P8w6m.add("/token/generate");
        lf_AW6P8w6m.add("/access/**");
        lf_AW6P8w6m.add("/js/**");
        lf_AW6P8w6m.add("/css/**");
        lf_AW6P8w6m.add("/fonts/**");
        lf_AW6P8w6m.add("/index.html");
        lf_AW6P8w6m.add("/error");
        p_xa406m9R.addInterceptor(gf_C6bKT5p2).excludePathPatterns(lf_AW6P8w6m).addPathPatterns("/**");
    }
}
