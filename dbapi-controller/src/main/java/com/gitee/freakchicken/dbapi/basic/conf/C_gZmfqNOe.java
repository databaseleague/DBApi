package com.gitee.freakchicken.dbapi.basic.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class C_gZmfqNOe implements WebMvcConfigurer {

    @Autowired
    C_jWPTkLaW gf_uSkptz7p;

    @Override
    public void addInterceptors(InterceptorRegistry p_NV562bnY) {
        List<String> lf_dWofQehH = new ArrayList<>();
        lf_dWofQehH.add("/user/login");
        lf_dWofQehH.add("/token/generate");
        lf_dWofQehH.add("/access/**");
        lf_dWofQehH.add("/js/**");
        lf_dWofQehH.add("/css/**");
        lf_dWofQehH.add("/fonts/**");
        lf_dWofQehH.add("/index.html");
        lf_dWofQehH.add("/error");
        p_NV562bnY.addInterceptor(gf_uSkptz7p).excludePathPatterns(lf_dWofQehH).addPathPatterns("/**");
    }
}
