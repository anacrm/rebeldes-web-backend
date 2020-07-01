package com.anacrm.rebeldeswebbackend.controller;

import com.anacrm.rebeldeswebbackend.model.Rebel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController // informa spring que a class é um controller
@RequestMapping("/api")
public class RebelController {

    private ArrayList<Rebel> rebels = new ArrayList<>();

    @PostMapping("/rebel")
    public Rebel createRebel(@RequestBody Rebel rebel) {

        rebels.add(rebel);
        return rebel;
    }

    @GetMapping("/reports/traitors")
    public float reportsTraitors() {
        return 0f;
    }



}
