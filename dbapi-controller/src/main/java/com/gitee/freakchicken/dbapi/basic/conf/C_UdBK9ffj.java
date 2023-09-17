package com.gitee.freakchicken.dbapi.basic.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class C_UdBK9ffj implements WebMvcConfigurer {

    @Autowired
    C_P3PWPmXO gf_nlRnIok1;

    @Override
    public void addInterceptors(InterceptorRegistry p_KGHwEM3v) {
        List<String> lf_mg3Z8KIl = new ArrayList<>();
        lf_mg3Z8KIl.add("/user/login");
        lf_mg3Z8KIl.add("/token/generate");
        lf_mg3Z8KIl.add("/access/**");
        lf_mg3Z8KIl.add("/js/**");
        lf_mg3Z8KIl.add("/css/**");
        lf_mg3Z8KIl.add("/fonts/**");
        lf_mg3Z8KIl.add("/index.html");
        lf_mg3Z8KIl.add("/error");
        p_KGHwEM3v.addInterceptor(gf_nlRnIok1).excludePathPatterns(lf_mg3Z8KIl).addPathPatterns("/**");
    }
}
