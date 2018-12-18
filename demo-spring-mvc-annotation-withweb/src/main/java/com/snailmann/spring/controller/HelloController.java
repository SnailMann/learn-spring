package com.snailmann.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {


    @RequestMapping("")
    public String print() {
        System.out.println("hello");
        return "hello";
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


    /**
     * 不管请求是什么，会将message的值插入到所有请求跳转的jsp模板中
     *
     * @return
     */
    @ModelAttribute("message")
    public String message() {
        return "hello world";
    }


}
