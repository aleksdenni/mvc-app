package com.aleksdenni.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value="name", required = false)String name,
                            @RequestParam(value="surname", required = false)String surname,
                            Model model){
        //System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a",defaultValue = "0.0")double a,
                             @RequestParam(value = "b", defaultValue = "0.0")double b,
                             @RequestParam(value = "action", defaultValue = "empty")String action,
                             Model model){
        System.out.println(a + " " + b + " " + action);
        String result;
        double res = 0;
        switch (action){
            case "multiplication":
                res=a*b;
                break;
            case "addition":
                res=a+b;
                break;
            case "subtraction":
                res=a-b;
                break;
            case "division":
                res=a/b;
                break;
        }
        result =  String.valueOf(res);
        model.addAttribute("result", result);
        return "first/calculator";
    }
}