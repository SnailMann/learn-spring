package com.snailmann.spring.aop.advice;

import org.springframework.stereotype.Component;


/**
 * 菜鸟服务员的实现类
 */
@Component
public class NoobWaiter implements Waiter {
    @Override
    public void greetTo(String name) {
        System.out.println("greet to " + name);
    }

    @Override
    public void serveTo(String name) {
        System.out.println("serve to " + name);
    }
}
