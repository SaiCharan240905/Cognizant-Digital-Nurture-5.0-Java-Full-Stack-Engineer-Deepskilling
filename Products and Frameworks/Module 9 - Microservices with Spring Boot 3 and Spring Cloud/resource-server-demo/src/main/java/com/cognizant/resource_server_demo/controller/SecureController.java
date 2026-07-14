package com.cognizant.resource_server_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {

    @GetMapping("/")
    public String home() {
        return "Public Endpoint";
    }

    @GetMapping("/secure")
    public String secure() {
        return "This is a secure endpoint";
    }
}
