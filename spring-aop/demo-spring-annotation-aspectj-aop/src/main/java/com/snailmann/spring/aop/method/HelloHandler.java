package com.snailmann.spring.aop.method;

import com.snailmann.spring.aop.annotation.Hello;
import com.snailmann.spring.aop.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class HelloHandler {

    public void getStudent(Student student){ }
    public void getStudent(Student student,String str){ }
    public void getAnnotationStudent( Student student){ }
    public void setPointCutStudent(Student student){}
    public Student returnStudent(Student student){return student;}

}
