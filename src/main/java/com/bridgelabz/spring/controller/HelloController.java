package com.bridgelabz.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.spring.dto.UserDTO;

@RestController
public class HelloController {

    // UC1: GET /hello - returns simple hello message
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from BridgeLabz";
    }

    // UC2: GET /hello/query?name=... - returns hello with name from query parameter
    @GetMapping("/hello/query")
    public String sayHelloWithQuery(@RequestParam String name) {
        return "Hello " + name + " from BridgeLabz";
    }

    // UC3: GET /hello/param/{name} - returns hello with name from path variable
    @GetMapping("/hello/param/{name}")
    public String sayHelloWithParam(@PathVariable String name) {
        return "Hello " + name + " from BridgeLabz";
    }

    // UC4: POST /hello/post - returns hello with first and last name from request body
    @PostMapping("/hello/post")
    public String sayHelloWithPost(@RequestBody UserDTO user) {
        return "Hello " + user.getFirstName() + " " + user.getLastName() + " from BridgeLabz";
    }

    // UC5: PUT /hello/put/{firstName}?lastName=... - returns hello using path variable and query parameter
    @PutMapping("/hello/put/{firstName}")
    public String sayHelloWithPut(@PathVariable String firstName, @RequestParam String lastName) {
        return "Hello " + firstName + " " + lastName + " from BridgeLabz";
    }
}
