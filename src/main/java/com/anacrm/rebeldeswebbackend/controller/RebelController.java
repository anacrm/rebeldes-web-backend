package com.anacrm.rebeldeswebbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // informa spring que a class é um controller
public class RebelController {

    @GetMapping("/reports/traitors")
    public float reportsTraitors() {
        return 0f;
    }

}
