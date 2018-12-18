package com.snailmann.spring.servlet.support;

import com.snailmann.spring.config.DispatcherServletConfiguration;
import com.snailmann.spring.config.WebMvcConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**
 * 这里采用注解驱动的方式
 * Spring Web Mvc 自动装配 默认实现
 *
 */
public class DefaultAnnotationConfigDispatcherServletInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {


    /**
     * 针对web.xml
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    /**
     * 针对 DispatcherServlet
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{DispatcherServletConfiguration.class};
    }

    /**
     * Servlet映射，就对应servlet-mapping
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
