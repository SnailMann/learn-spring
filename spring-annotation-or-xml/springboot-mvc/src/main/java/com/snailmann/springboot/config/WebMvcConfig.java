package com.snailmann.springboot.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Spring MVC 配置类
 *
 * 当我们需要自定义组件的使用，就需要实现WebMvcConfigurer接口
 * 为了让SpringBoot自动化装配成功，所以我们要去除掉@EnableWebMvc，他们两者只能取其一
 */

/*@EnableWebMvc*/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

}
