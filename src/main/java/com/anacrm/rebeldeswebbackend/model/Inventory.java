package com.anacrm.rebeldeswebbackend.model;

public class Inventory {

    private int weapons;
    private int ammo;
    private int water;
    private int food;


    public Inventory (int weapons,int ammo, int water, int food){
        this.weapons = weapons;
        this.ammo= ammo;
        this.water= water;
        this.food= food;
    }

    public int getWeapons() {
        return weapons;
    }

    public void setWeapons(int weapons) {
        this.weapons = weapons;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getPoints(){
        int total = (4*this.weapons + 3*this.ammo + 2*this.water + this.food);
        return total;
    }

}


