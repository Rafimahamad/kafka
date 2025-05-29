package com.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String method1(){
        return "Congartulations !";
    }

    @GetMapping("/hi")
    public String returnmessage(){
        return "hello welcome";
    }

}
