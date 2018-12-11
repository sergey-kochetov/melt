package ru.com.melt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class HelloController {

    @RequestMapping("/")
    @ResponseBody
    String hello() {
        return "Hello Spring boot!";
    }

    @RequestMapping("/hello")
    public String showHelloWorld() {
        return "hello-world";
    }
}
