package com.snailmann.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {


    @RequestMapping("")
    public String print() {
        System.out.println("hello");
        return "hello";
    }

    /**
     * 测试 {@link HelloWorldControllerAdvice}
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        System.out.println("index");
        return "index";
    }


    /**
     *
     * 测试 {@link HelloWorldControllerExceptionAdvice}
     * 我们测试时不传入value，但是RequestParam是必传的，所以会抛异常
     * 所以会被{@link HelloWorldControllerExceptionAdvice}所拦截
     *
     * @param value
     * @param model
     * @return
     */
    @RequestMapping("/exception/index")
    public String exceptionIndex(@RequestParam int value ,Model model) {
        System.out.println("exception index");
        return "index";
    }


    /**
     * 使用@RequestHeader获取指定请求头
     * 使用@CookieValue获取指定cookie
     * 使用Model与jsp交互数据
     *
     * @param accessLanguage
     * @param jsessionId
     * @param model
     * @return
     */
    @RequestMapping("/test")
    public String test(@RequestHeader("Accept-Language") String accessLanguage,
                      @CookieValue("JSESSIONID") String jsessionId, Model model) {
        model.addAttribute("accessLanguage",accessLanguage);
        model.addAttribute("jsessionId",jsessionId);

        return "index";
    }


}
