package com.snailmann.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {


    @RequestMapping("")
    public String print(){
        System.out.println("hello");
        return "hello";
    }

}
