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
    public String calculator(@RequestParam(value = "a",required = false)String a,
                             @RequestParam(value = "b", required = false)String b,
                             @RequestParam(value = "action", defaultValue = "empty")String action,
                             Model model){
        System.out.println(a + " " + b + " " + action);
        String result;
        double a1 = Double.parseDouble(a);
        double a2 = Double.parseDouble(b);
        double res = 0;

        switch (action){
            case "multiplication":
                res=a1*a2;
                break;
            case "addition":
                res=a1+a2;
                break;
            case "subtraction":
                res=a1-a2;
                break;
            case "division":
                res=Math.round(a1/a2);
                break;
        }
        result =  String.valueOf(res);
        model.addAttribute("result", result);
        return "first/calculator";
    }
}