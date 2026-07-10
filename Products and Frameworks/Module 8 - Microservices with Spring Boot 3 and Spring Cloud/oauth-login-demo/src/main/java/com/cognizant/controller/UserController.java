package com.cognizant.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    public String home() {
        return "Welcome! Login using Google.";
    }

    @GetMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }
}