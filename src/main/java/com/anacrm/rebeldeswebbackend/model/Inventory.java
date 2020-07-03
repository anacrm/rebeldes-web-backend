package com.anacrm.rebeldeswebbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Inventory {

    //constantes para representar os valores dos itens
    public static final int VALUE_WEAPON = 4;
    public static final int VALUE_AMMO = 3;
    public static final int VALUE_WATER = 2;
    public static final int VALUE_FOOD = 1;
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

    public int getAmmo() {
        return ammo;
    }

    public int getWater() {
        return water;
    }

    public int getFood() {
        return food;
    }


    @JsonIgnore // ignora ao criar Json para resposta
    public int getPoints(){
        int total = (VALUE_WEAPON *this.weapons + VALUE_AMMO*this.ammo + VALUE_WATER *this.water + VALUE_FOOD *this.food);
        return total;
    }

    public void subtract(Inventory offer){
        this.weapons -= offer.getWeapons();
        this.ammo -=offer.getAmmo();
        this.water -= offer.getWater();
        this.food -= offer.getFood();
    }

    public void add(Inventory offer){
        this.weapons += offer.getWeapons();
        this.ammo +=offer.getAmmo();
        this.water += offer.getWater();
        this.food += offer.getFood();
    }

}


