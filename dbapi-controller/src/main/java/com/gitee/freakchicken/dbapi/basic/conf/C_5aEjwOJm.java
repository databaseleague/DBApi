package com.gitee.freakchicken.dbapi.basic.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class C_5aEjwOJm implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry p_rLVqt8Da) {
        p_rLVqt8Da.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS").allowCredentials(true).maxAge(3600).allowedHeaders("*");
    }
}
