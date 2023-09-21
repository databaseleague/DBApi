package com.gitee.freakchicken.dbapi.basic.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class C_lY9ZjSXF implements WebMvcConfigurer {

    @Autowired
    C_PFeTZYuk gf_TaEhKJlj;

    @Override
    public void addInterceptors(InterceptorRegistry p_Lp4UaQ4k) {
        List<String> lf_1HTZEGzK = new ArrayList<>();
        lf_1HTZEGzK.add("/user/login");
        lf_1HTZEGzK.add("/token/generate");
        lf_1HTZEGzK.add("/access/**");
        lf_1HTZEGzK.add("/js/**");
        lf_1HTZEGzK.add("/css/**");
        lf_1HTZEGzK.add("/fonts/**");
        lf_1HTZEGzK.add("/index.html");
        lf_1HTZEGzK.add("/error");
        p_Lp4UaQ4k.addInterceptor(gf_TaEhKJlj).excludePathPatterns(lf_1HTZEGzK).addPathPatterns("/**");
    }
}
