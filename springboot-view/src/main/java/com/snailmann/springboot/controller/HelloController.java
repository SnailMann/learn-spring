package com.snailmann.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(){
        //view 逻辑名称
        return "hello";
    }


    @RequestMapping("/index")
    public String index() {
        System.out.println("index");
        return "index";
    }


    @ModelAttribute("message")
    public String message(){
        return "hello,world";
    }

}
