package com.example.sqch10ex2.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    @GetMapping("/ciao")
    public String ciao(){
        return "Ciao!";
    }
}
