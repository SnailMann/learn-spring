package com.snailmann.spring.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Spring MVC 配置类
 *
 * 当我们需要自定义组件的使用，就需要实现WebMvcConfigurer接口
 *
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {


    /**
     * 注解方式配置InternalResourceViewResolver，视图解析器
     * 覆盖默认配置
     * 原来是在springmvc的xml文件中配置视图解析器
     *
     * @return
     */
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;

    }

}
