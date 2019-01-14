package com.snailmann.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Slf4j
@Aspect
@Component
public class HelloAspect {

    @Around("execution(* com.snailmann.spring.aop.controller.*.*(..))")
    public Object sayHello(ProceedingJoinPoint joinPoint) throws Throwable {
        log.warn("【Aspect】 - before");
        Object obj = joinPoint.proceed();
        log.warn("【Aspect】 - after");
        return obj;

    }
}
