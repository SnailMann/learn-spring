package com.snailmann.springboot.controller;



import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * assignableTypes意思就是专门提供给HelloController使用
 * 这里的作用就是为HelloController类实现的Controller层切面，将重复代码从HelloController抽离出来
 * @author liwenjie
 */
@ControllerAdvice(assignableTypes = HelloController.class)
public class HelloWorldControllerAdvice {

    @ModelAttribute("message")
    public String message() {
        return "hello world";
    }

    @ModelAttribute("acceptLanguage")
    public String acceptLanguage(@RequestHeader("Accept-Language") String acceptLanguage) {
        return acceptLanguage;
    }


    @ModelAttribute("jsessionId")
    public String jsessionId(@CookieValue("JSESSIONID") String jsessionId) {
        return jsessionId;
    }



}
