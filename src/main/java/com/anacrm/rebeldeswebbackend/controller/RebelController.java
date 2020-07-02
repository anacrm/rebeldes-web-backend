package com.anacrm.rebeldeswebbackend.controller;

import com.anacrm.rebeldeswebbackend.model.Location;
import com.anacrm.rebeldeswebbackend.model.Rebel;
import com.anacrm.rebeldeswebbackend.model.Report;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController // informa spring que a class é um controller
@RequestMapping("/api")
public class RebelController {

    private ArrayList<Rebel> rebels = new ArrayList<>();

    @GetMapping("/all")
    public ArrayList<Rebel> all(){
        return rebels;
    }


    @PostMapping("/rebel")
    public Rebel createRebel(@RequestBody Rebel rebel) {

        rebels.add(rebel);
        return rebel;
    }

    @PutMapping("/rebel/{id}/location")
    public Rebel updateLocation(@PathVariable("id") int id, @RequestBody Location location) {

        Rebel rebel =  this.getRebel(id);

        rebel.setLocation(location);

        return rebel;
    }

    @PutMapping("/rebel/{id}/report")
    public Rebel reportRebel (@PathVariable("id") int id) {

        Rebel rebel = this.getRebel(id);
        rebel.addReport();
        return rebel;
    }

    @PutMapping("/negotiate")
    public Rebel negotiate(){
        return null;
    }

    @GetMapping("/completeReport")
    public Report completeReport() {

        float amountRebels = this.rebels.size();
        float amountTraitors=0;
        int lostPoints = 0;

        for (Rebel rebel:this.rebels) {
            if(rebel.isTraitor()){
                amountTraitors++;
                lostPoints +=  rebel.getInventory().getPoints();
            }

        }
        float percentTraitors = amountTraitors/amountRebels;



        return new Report(percentTraitors,(1-percentTraitors),lostPoints);
    }

    public Rebel getRebel (int id) {

        for (Rebel rebel:this.rebels) {
            if(rebel.getId() == id){
                return rebel;
            }
        }
        return null;
    }



}
