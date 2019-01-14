package com.snailmann.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Slf4j
@Aspect
@Component
public class HelloAspect2 {

    @Around("execution(* com.snailmann.spring.aop.controller.*.*(..))")
    public Object sayHello(ProceedingJoinPoint joinPoint) throws Throwable {
        log.warn("【Aspect2】 - before");
        Object obj = joinPoint.proceed();
        log.warn("【Aspect2】 - after");
        return obj;

    }
}
