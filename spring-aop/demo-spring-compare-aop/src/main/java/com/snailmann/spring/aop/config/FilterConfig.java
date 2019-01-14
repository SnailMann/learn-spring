package com.snailmann.spring.aop.config;


import com.snailmann.spring.aop.filter.HelloFilter;
import com.snailmann.spring.aop.filter.HelloFilter2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.io.FileInputStream;

/**
 * Filter的配置类
 * Filter的声明可以通过@Component或者@Bean两种方式去实现
 */
@Configuration
public class FilterConfig {

  /*  @Bean
    public FilterRegistrationBean filterRegistrationBean1(){
        FilterRegistrationBean<HelloFilter> filterRegistrationBean=new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new HelloFilter());
        filterRegistrationBean.addUrlPatterns("/**");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }


    @Order(2)
    @Bean
    public FilterRegistrationBean filterRegistrationBean2() {
        FilterRegistrationBean<HelloFilter2> filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new HelloFilter2());
        filterRegistrationBean.addUrlPatterns("/**");
        return filterRegistrationBean;
    }*/

}
