package com.snailmann.spring.aop.advice;


/**
 * 服务员接口
 */
public interface Waiter {

    /**
     * 问候
     * @param name
     */
    void greetTo(String name);

    /**
     * 服务
     * @param name
     */
    void serveTo(String name);

}
