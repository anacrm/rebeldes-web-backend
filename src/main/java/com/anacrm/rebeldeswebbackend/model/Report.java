package com.anacrm.rebeldeswebbackend.model;

public class Report {
    private float traitors;
    private float rebels;
    private int lostPoints;

    public Report(float traitors, float rebels, int lostPoints){
        this.traitors=traitors;
        this.rebels=rebels;
        this.lostPoints = lostPoints;
    }

    public float getTraitors() {
        return traitors;
    }

    public void setTraitors(float traitors) {
        this.traitors = traitors;
    }

    public float getRebels() {
        return rebels;
    }

    public void setRebels(float rebels) {
        this.rebels = rebels;
    }
    public int getLostPoints() {
        return lostPoints;
    }

    public void setLostPoints(int lostPoints) {
        this.lostPoints = lostPoints;
    }

}
