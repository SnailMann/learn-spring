package com.snailmann.spring.aop.method;

import com.snailmann.spring.aop.annotation.Hello;
import com.snailmann.spring.aop.entity.Student;

public class HelloHandler {

    public void getStudent(Student student){
        System.out.println(student);
    }


    public void getAnnotationStudent(@Hello Student student){
        System.out.println("annotation :" + student);
    }

}
