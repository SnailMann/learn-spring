package com.snailmann.spring.aop;

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



    }

}

