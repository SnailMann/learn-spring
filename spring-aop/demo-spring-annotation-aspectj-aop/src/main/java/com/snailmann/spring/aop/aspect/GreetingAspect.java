package com.snailmann.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 使用@Aspect注解声明切面
 */
@Aspect
public class GreetingAspect {

    /**
     * 用注解声明一个切点
     */
    @Pointcut("within(com.snailmann.spring.aop..*)")
    public void doBefore() {

    }


}
