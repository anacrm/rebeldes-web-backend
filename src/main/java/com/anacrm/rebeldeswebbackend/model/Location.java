package com.anacrm.rebeldeswebbackend.model;

public class Location {

    private float latitude;
    private float longitude;
    private String name;

    public Location( float latitude,float longitude,String name){
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }

}
