package com.keycloak.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/home")
@RestController
@Slf4j
public class FreeController {

    @GetMapping
    public String msg(){
        log.info("msg method called");
        return "hello Welcome !";
    }
}
