package com.anacrm.rebeldeswebbackend.model;

public class Report {
    private float traitors;
    private float rebels;
    private int lostPoints;
    private float averageWeapons;
    private float averageAmmo;
    private float averageWater;
    private float averageFood;

    public Report(float traitors, float rebels, int lostPoints, float averageWeapons, float averageAmmo, float averageWater, float averageFood){
        this.traitors=traitors;
        this.rebels=rebels;
        this.lostPoints = lostPoints;
        this.averageWeapons = averageWeapons;
        this.averageAmmo = averageAmmo;
        this.averageWater = averageWater;
        this.averageFood = averageFood;
    }

    public float getTraitors() {
        return traitors;
    }

    public float getRebels() {
        return rebels;
    }

    public int getLostPoints() {
        return lostPoints;
    }

    public float getAverageWeapons() {
        return averageWeapons;
    }

    public float getAverageAmmo() {
        return averageAmmo;
    }

    public float getAverageWater() {
        return averageWater;
    }

    public float getAverageFood() {
        return averageFood;
    }

}
