package com.snailmann.spring.aop.aspect;

import com.snailmann.spring.aop.entity.Student;
import com.snailmann.spring.aop.method.HelloHandler;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class HelloAspect {

    /**
     * 切点1，匹配com.snailmann.spring.aop下的任意类的任意方法
     */
    @Pointcut("execution(* *(com.snailmann.spring.aop.*))")
    public void pointCutA() {
    }

    /**
     * 切点2，匹配任意set开头的方法
     */
    @Pointcut("execution(* set*(..))")
    public void pointCutB() {
    }

    /**
     * 复合切点，匹配com.snailmann.spring.aop包下的任意类的set开头的方法
     */
    @Pointcut("pointCutA() && pointCutB()")
    public void pointCutC() {
    }


    /**
     * 拦截访问修饰符为public，返回类型任意，任意方法名，只要入参有且仅有一个Student类的所有方法
     *
     * @param point
     * @return
     * @throws Throwable
     */
    @Around(value = "execution(public * *(com.snailmann.spring.aop.entity.Student,..)) && args(com.snailmann.spring.aop.entity.Student,..)")
    public Object setExecutionStudent(ProceedingJoinPoint point) throws Throwable {
        setStudent(point);
        Object object = point.proceed();
        return object;
    }


    /**
     * 拦截匹配com.snailmann.spring.aop包下的任意类的set开头的方法
     *
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("pointCutC()")
    public Object setPointCutStudent(ProceedingJoinPoint point) throws Throwable {
        setStudent(point);
        Object object = point.proceed();
        return object;
    }


    /**
     * 拦截匹配com.snailmann.spring.aop包下的任意类的set开头的方法
     *
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("pointCutC() && args(student,string)")
    public Object setPointCutStudent(ProceedingJoinPoint point, Student student, String string) throws Throwable {
        System.out.println(student + " " + string);
        setStudent(point);
        Object object = point.proceed();
        return object;
    }


    @Before("execution(* set*(..)) && this(helloHandler)")
    public void setStudent(JoinPoint joinPoint, HelloHandler helloHandler) {
        System.out.println(helloHandler.getClass());
    }


    private void setStudent(ProceedingJoinPoint point) {
        Object[] args = point.getArgs();
        Student student = null;
        for (Object obj : args) {
            if (obj instanceof Student) {
                student = (Student) obj;
            }
        }
        if (student != null) {
            student.setName("jerry");
            student.setAge(30);
        }

        System.out.println(point.getSignature().getName() + " : " + student);
    }

}
