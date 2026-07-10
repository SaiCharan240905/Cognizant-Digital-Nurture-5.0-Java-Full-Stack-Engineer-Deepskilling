package com.cognizant.jwt_demo.controller;

import com.cognizant.jwt_demo.service.JwtService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        if (username.equals("admin") &&
                password.equals("admin123")) {

            return jwtService.generateToken(username);

        }

        return "Invalid Credentials";

    }

}