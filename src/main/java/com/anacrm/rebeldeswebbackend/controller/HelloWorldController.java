package com.anacrm.rebeldeswebbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/sayHello")
    public String sayHelloWorld(){

        return "Hello World";
    }
}
