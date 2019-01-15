package com.snailmann.aop.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib代理的MethodInterceptor实现类，定义类似AOP的切面
 */
public class ProxyFoodStop implements MethodInterceptor {

    Object target;


    /**
     * 创建FoodStop的代理对象
     * 依赖目标对象，Enhancer对象和Cglib的MethodInterceptor实现类对象
     *
     * @param target 目标对象
     * @return       cglib动态生成的代理对象
     */
    public Object createProxyFoodStop(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /**
     * 拦截的方法，类似AOP的Around
     * 只需要method和args即可实现动态代理
     *
     * @param o
     * @param method       需要代理的方法
     * @param args         代理方法初入的参数
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        if ("sellSomething".equals(method.getName())){
            System.out.println("selling " + args[0]);
            Object obj = method.invoke(this.target,args);
            return obj;
        }

        System.out.println("advertise...");
        Object obj = method.invoke(this.target,args);
        System.out.println("sell out...");

        return obj;
    }
}
