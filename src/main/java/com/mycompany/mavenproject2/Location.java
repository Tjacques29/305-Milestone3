/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 * 
 * @author Brittina Morgan
 * 
 * 
 * This program a class that holds the Longitude and Latitude of a property
 * 
 * Field        Description
 * latitude     double The latitude of the property
 * longitude    double The longitude of the property
 * 
 */

public class Location {
    
    private double latitude;
    private double longitude;
    
    /**
     * This is the main constructor for the Location class
     * @param lat double the latitude of a the location 
     * @param longitude double the longitude of the location
     */
    public Location(double lat, double longitude){
        this.latitude = lat;
        this.longitude = longitude;
    }
    
    /**
     * Returns the latitude for the location 
     * @return latitude double the location's latitude 
     */
    public double getLat(){
        return this.latitude;
    }
    
    /**
     * Returns the latitude for the location 
     * @return latitude double the location's latitude 
     */
    public double getLong(){
        return this.longitude;
    }
    
    /**
     * Sets the latitude for the location 
     * @param latitude double the location's latitude 
     */
    public void setLat(double latitude){
        this.latitude = latitude;
    }
    
    /**
     * Sets the longitude for the location 
     * @param longitude double the location's latitude 
     */
    public void setLong(double longitude){
        this.longitude = longitude;
    }
    
    /**
     * Returns Location String
     * @return String locationString
     */
    @Override
    public String toString(){
        StringBuilder locationString = new StringBuilder();
        locationString.append("(");
        locationString.append(this.latitude);
        locationString.append(", ");
        locationString.append(this.longitude);
        locationString.append(")");
        return locationString.toString();
    }    
    
    
}
