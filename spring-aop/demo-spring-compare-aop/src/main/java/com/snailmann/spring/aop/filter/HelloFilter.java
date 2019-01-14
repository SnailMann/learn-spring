package com.snailmann.spring.aop.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Order(2)
@Slf4j

public class HelloFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.warn("【filter】 - before");
        filterChain.doFilter(servletRequest, servletResponse);
        log.warn("【filter】 - after");
    }

    @Override
    public void destroy() {

    }
}
