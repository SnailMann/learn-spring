package com.snailmann.spring.aop.config;

import com.snailmann.spring.aop.interceptor.HelloInterceptor;
import com.snailmann.spring.aop.interceptor.HelloInterceptor2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 这里的添加顺序就是拦截器的执行执行顺序
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HelloInterceptor2()).addPathPatterns("/**");
        registry.addInterceptor(new HelloInterceptor()).addPathPatterns("/**");

    }
}
