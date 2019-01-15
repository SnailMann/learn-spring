package com.snailmann.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK代理的InvocationHandler的实现类，类似AOP的切面
 */
public class ProxyCompany implements InvocationHandler {

    Object target;

    public Object createProxyCompany(Object target){
        this.target = target;
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),SteamCompany.class.getInterfaces(),this);
    }

    /**
     * 类似AOP的Around
     * 只需要method和args即可
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("advertise...");
        Object obj = method.invoke(this.target,args);
        System.out.println("sell out...");

        return obj ;
    }
}
