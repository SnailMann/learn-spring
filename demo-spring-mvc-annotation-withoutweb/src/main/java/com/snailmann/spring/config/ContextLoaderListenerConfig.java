package com.snailmann.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/**
 * ContextLoderListener的注解配置方式 - 配置类
 */
@Configuration
@ComponentScan(basePackages={"com.snailmann.spring"},
excludeFilters={@ComponentScan.Filter(type= FilterType.ANNOTATION ,value= EnableWebMvc.class)})
public class ContextLoaderListenerConfig {

}
