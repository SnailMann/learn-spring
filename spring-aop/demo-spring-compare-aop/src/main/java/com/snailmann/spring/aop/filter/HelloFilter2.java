package com.snailmann.spring.aop.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Order(1)
@Slf4j
@Component
public class HelloFilter2 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.warn("【filter2】 - before");
        filterChain.doFilter(servletRequest,servletResponse);
        log.warn("【filter2】 - after");
    }
}
