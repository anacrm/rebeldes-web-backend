package com.anacrm.rebeldeswebbackend.model;

import java.util.ArrayList;

public class Rebel {

    /**
     * Como nao usarei banco de dados decidi criar uma logica simples
     * para gerar ids unicos.
     */
    static private int idCount = 0;

    private int id;
    private String name;
    private int age;
    private String gender; // tentar usar enum
    private Location location;
    private boolean traitor = false;
    private int reportCount = 0;
    private ArrayList<String> inventory = new ArrayList<>();

    public Rebel(String name,int age, String gender, Location location){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.location= location;
        idCount++;
        id = idCount;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isTraitor() {
        return traitor;
    }

    public void setTraitor(boolean traitor) {
        this.traitor = traitor;
    }

    public int getReportCount() {
        return reportCount;
    }

    public void setReportCount(int reportCount) {
        this.reportCount = reportCount;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<String> inventory) {
        this.inventory = inventory;
    }

    public void addReport() {
        this.reportCount++;
        if (this.reportCount >= 3){
            this.traitor = true;
        }
    }
}

