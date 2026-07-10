package com.cognizant.jwt_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {

    @GetMapping("/")
    public String home() {

        return "Welcome to JWT Authentication Demo";

    }

    @GetMapping("/secure")
    public String secureAPI() {

        return "JWT Authentication Successful";

    }

}