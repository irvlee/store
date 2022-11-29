package com.my.store.config;

import com.my.store.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoginIntercepterConfig implements WebMvcConfigurer {

    @Autowired
    HandlerInterceptor interceptor;

    /**
     * 添加拦截器选项
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        HandlerInterceptor interceptor = new LoginInterceptor();
        List<String> patterns = new ArrayList<>();

        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        patterns.add("/web/register.html");
        patterns.add("/web/login.html");
        patterns.add("/web/index.html");
        patterns.add("/users/**");

        registry.addInterceptor(interceptor).
                addPathPatterns("/**").excludePathPatterns(patterns);
    }
}
