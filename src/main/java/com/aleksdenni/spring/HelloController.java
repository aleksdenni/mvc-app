package com.aleksdenni.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HelloController {

    @GetMapping("/")
    public String sayHello(){
        return "hello_world";
    }

    @ModelAttribute("headerMessage")
    public String someMessage(){
        return "It`s my message";
    }
}
