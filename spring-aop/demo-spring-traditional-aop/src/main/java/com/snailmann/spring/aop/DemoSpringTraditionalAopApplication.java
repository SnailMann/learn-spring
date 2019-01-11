package com.snailmann.spring.aop;

import com.snailmann.spring.aop.advice.GreetingBeforeAdvice;
import com.snailmann.spring.aop.advice.NoobWaiter;
import com.snailmann.spring.aop.advice.Waiter;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoSpringTraditionalAopApplication {

    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(DemoSpringTraditionalAopApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);


        /**
         * 1. 编程模式: ProxyFactory
         */
        //noobWaiterAdviceMethod(context);

        /**
         * 2. Xml模式：ProxyFactoryBean
         */
        xmlNoobWaiterAdviceMethod();




    }


    /**
     * 菜鸟服务员被代理后成为熟练服务员
     */
    public static void xmlNoobWaiterAdviceMethod(){
        //通过使用ClassPathXmlApplicationContext将Xml声成的Bean注册到容器中
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:xml/beans.xml");
        //获取Bean id叫waiter的Bean
        Waiter waiter = (Waiter) context.getBean("waiter");
        waiter.greetTo("Mark");
        waiter.serveTo("Mark");
    }


    /**
     * 菜鸟服务员被代理后成为熟练服务员
     * @param context
     */
    public static void noobWaiterAdviceMethod(ApplicationContext context){
        //待代理对象
        Waiter noobWaiter = new NoobWaiter();
        //前置增强
        BeforeAdvice beforeAdvice = new GreetingBeforeAdvice();
        //代理工厂
        ProxyFactory proxyFactory = new ProxyFactory();

        //通过代理工厂设入目标代理对象，和增强
        proxyFactory.setTarget(noobWaiter);
        proxyFactory.addAdvice(beforeAdvice);


        //通过代理工厂获得代理对象，熟练服务员
        Waiter proxyWaiter = (Waiter) proxyFactory.getProxy();

        proxyWaiter.greetTo("Jerry");
        proxyWaiter.serveTo("Jerry");
    }


}

