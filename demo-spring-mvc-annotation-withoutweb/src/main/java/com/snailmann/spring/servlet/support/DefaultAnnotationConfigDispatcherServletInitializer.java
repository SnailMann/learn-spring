package com.snailmann.spring.servlet.support;

import com.snailmann.spring.config.DispatcherServletConfig;
import com.snailmann.spring.config.ContextLoaderListenerConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**
 * 这里采用注解驱动的方式
 * Spring Web Mvc 自动装配 默认实现
 * 继承AbstractAnnotationConfigDispatcherServletInitializer便可以声明DispatcherServlet和ContextLoaderListener
 *
 */
public class DefaultAnnotationConfigDispatcherServletInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {


    /**
     * 针对web.xml
     * 针对ContextLoaderListener配置
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ContextLoaderListenerConfig.class};
    }

    /**
     * 针对 DispatcherServlet
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{DispatcherServletConfig.class};
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
