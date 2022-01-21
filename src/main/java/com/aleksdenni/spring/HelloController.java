package com.aleksdenni.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

    //@GetMapping("/")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sayHello(){
        return "hello_world";
    }
}
