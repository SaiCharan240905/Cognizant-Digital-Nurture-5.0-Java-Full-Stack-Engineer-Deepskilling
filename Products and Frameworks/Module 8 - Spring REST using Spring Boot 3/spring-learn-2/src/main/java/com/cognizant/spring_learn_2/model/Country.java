package com.cognizant.spring_learn_2.model;

import jakarta.validation.constraints.NotBlank;
public class Country {

    @NotBlank(message = "Country code cannot be empty")
    private String code;

    @NotBlank(message = "Country name cannot be empty")
    private String name;

    public Country() {
    }

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}