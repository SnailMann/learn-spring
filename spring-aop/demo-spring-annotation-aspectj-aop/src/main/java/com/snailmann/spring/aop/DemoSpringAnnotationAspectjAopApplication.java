package com.snailmann.spring.aop;

import com.snailmann.spring.aop.entity.Student;
import com.snailmann.spring.aop.method.HelloHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoSpringAnnotationAspectjAopApplication {

    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(DemoSpringAnnotationAspectjAopApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        HelloHandler helloHandler = context.getBean(HelloHandler.class);
        Student student = new Student();

        helloHandler.getStudent(student);
        helloHandler.getStudent(student,"hello");
        helloHandler.getAnnotationStudent(student);
        helloHandler.setPointCutStudent(student);
        helloHandler.returnStudent(student);

    }

}

