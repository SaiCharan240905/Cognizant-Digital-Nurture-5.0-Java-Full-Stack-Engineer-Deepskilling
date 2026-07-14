package com.cognizant.gateway_resilience.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/fallback")
    public String fallback() {

        return "Employee Service is currently unavailable. Please try again later.";

    }

}