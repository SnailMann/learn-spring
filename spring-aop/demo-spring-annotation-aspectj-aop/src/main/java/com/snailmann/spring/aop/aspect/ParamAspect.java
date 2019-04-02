package com.snailmann.spring.aop.aspect;


import com.snailmann.spring.aop.annotation.Param;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 测试获取注解切面的属性值
 */

@Aspect
@Component
@Slf4j
public class ParamAspect {


    /**
     * 拦截目标方法的，获得方法上注解的值
     *
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("@annotation(com.snailmann.spring.aop.annotation.Param)")
    public Object interceptorParam(ProceedingJoinPoint point) throws Throwable {


        //先获得目标代理对象的类类型
        Class<?> targetClazz = point.getTarget().getClass();

        //先获得被代理的方法名称
        String methodName = point.getSignature().getName();
        //获得参数们的类类型数组
        Class[] parameterTypes = ((MethodSignature) point.getSignature()).getParameterTypes();

        //再获得目标代理对象的被代理方法
        Method method = targetClazz.getMethod(methodName, parameterTypes);

        //代理对象的被代理方法上是否存在@Param注解，如果存在
        if (method.isAnnotationPresent(Param.class)) {
            Param param = method.getAnnotation(Param.class);
            String value = param.value();
            log.error("get annotion value = {}", value);
        }
        return point.proceed();
    }

    /**
     * 拦截目标方法，获得方法参数中的注解的值
     * 1. 拦截com.snailmann包以及子包下的所有类的所有方法，只要方法的第一个参数有@Param注解修饰
     * 2. 有坑，@com.snailmann.spring.aop.annotation.Param (*), ..  | Param (*)之间一定要有空格..
     *
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.snailmann..*.*(@com.snailmann.spring.aop.annotation.Param (*), ..))")
    public Object interceptorParam2(ProceedingJoinPoint point) throws Throwable {


        //先获得目标代理对象的类类型
        Class<?> targetClazz = point.getTarget().getClass();

        //先获得被代理的方法名称
        String methodName = point.getSignature().getName();
        //获得参数们的类类型数组
        Class[] parameterTypes = ((MethodSignature) point.getSignature()).getParameterTypes();

        //再获得目标代理对象的被代理方法
        Method method = targetClazz.getMethod(methodName, parameterTypes);

        //遍历目标方法的参数注解二维数组，因为一个方法可能有多个参数，这是第一维，每个参数可以被多个注解修饰，这是第二维
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        //因为可能存在多个参数都有被@Param注解所修饰
        String[] values = new String[parameterAnnotations.length];
        int i = 0;
        for (Annotation[] parameterAnnotation : parameterAnnotations) {
            for (Annotation annotation : parameterAnnotation) {
                if (annotation instanceof Param) {
                    Param param = (Param) annotation;
                    values[i++] = param.value();
                }
            }
        }
        log.error("get annotion value = {}", Arrays.toString(values));
        return point.proceed();
    }

}
