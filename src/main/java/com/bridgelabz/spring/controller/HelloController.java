package com.bridgelabz.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // UC1: GET /hello - returns simple hello message
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from BridgeLabz";
    }
}
