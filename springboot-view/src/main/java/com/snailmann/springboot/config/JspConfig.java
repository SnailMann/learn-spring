package com.snailmann.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * 为了让jsp的internalResourceResolver视图解析器在thymeleaf之前，也就是修改order
 */
@Configuration
public class JspConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver internalResourceResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        //因为thymeleafResolver是最低优先级-5，即倒数第5个顺序，所以我们让jsp的视图解析器在倒数第6个加载，只要在thymeleaf前加载即可
        viewResolver.setOrder(Ordered.LOWEST_PRECEDENCE - 6);

        return viewResolver;
    }

}
