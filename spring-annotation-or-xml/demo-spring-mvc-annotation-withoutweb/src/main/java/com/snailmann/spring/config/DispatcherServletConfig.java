package com.snailmann.spring.config;

import com.snailmann.spring.servlet.support.DefaultAnnotationConfigDispatcherServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.DispatcherServlet;


/**
 *
 *
 * 1. {@link DispatcherServlet}配置类
 * 2. @ComponentScan(basePackages = "com.snailmann.spring.controller")可以代替app-context.xml的包扫描
 * 这个注解能生效是因为{@link DefaultAnnotationConfigDispatcherServletInitializer}加载了
 */
@ComponentScan(basePackages = "com.snailmann.spring")
public class DispatcherServletConfig {
}
