package com.gitee.freakchicken.dbapi.basic.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class C_I7ptAmPM implements WebMvcConfigurer {

    @Autowired
    C_831vsS6x gf_91JLwifB;

    @Override
    public void addInterceptors(InterceptorRegistry p_duoUOjZx) {
        List<String> lf_8x9Z8Y5p = new ArrayList<>();
        lf_8x9Z8Y5p.add("/user/login");
        lf_8x9Z8Y5p.add("/token/generate");
        lf_8x9Z8Y5p.add("/access/**");
        lf_8x9Z8Y5p.add("/js/**");
        lf_8x9Z8Y5p.add("/css/**");
        lf_8x9Z8Y5p.add("/fonts/**");
        lf_8x9Z8Y5p.add("/index.html");
        lf_8x9Z8Y5p.add("/error");
        p_duoUOjZx.addInterceptor(gf_91JLwifB).excludePathPatterns(lf_8x9Z8Y5p).addPathPatterns("/**");
    }
}
