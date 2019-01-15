package com.snailmann.spring.aop.aspect;

import com.snailmann.spring.aop.entity.Student;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class HelloAspect {


    @Around("args(com.snailmann.spring.aop.entity.Student)")
    public Object setStudent(ProceedingJoinPoint point){

        Object[] args = point.getArgs();
        Student student = null;
        for (Object obj : args ){
            if (obj instanceof Student){
                student = (Student) obj;
            }
        }

        if (student != null){
            student.setName("jerry");
            student.setAge(30);
        }





        return null;
    }

}
