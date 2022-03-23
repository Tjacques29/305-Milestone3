/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brittina Morgan
 */


public class Neighborhood implements DisplayStats{
    protected List<Double> valueList = new ArrayList<Double>(); 
    
    protected double lowValue = -1; //minium assesed property value in city's properties
    protected double highValue = -1; //maximum assessed property value in city's properties 
    protected String name;
    private String ID;
    
    /**
     * This is the main constructor for the Neighborhood Class
     * @param name
     * @param ID
     * @param value 
     */
    public Neighborhood(String name, String ID, double value){
        this.name = name;
        this.ID = ID;
        this.highValue = value;
        this.lowValue = value;
        this.valueList.add(value);
    }
    
    /**
     * Returns the difference between the maximum and minimum values
     * @param 
     * @return The difference between min and max
     */
    public double range(){
        // needs exception 

        return this.highValue - this.lowValue;
    }
    
    /**
     * Returns the neighborhood name
     * @return name String the neighborhood name 
     */
    public String getName(){
        return this.name;
    }
   
    /**
     * Outputs the statistics of a neighborhood
     */
    @Override
    public String displayStats(){
        int propCount = valueList.size();
        Stats calcStats = new Stats();
        double cityMean = calcStats.mean(valueList);
        double cityMedian = calcStats.median(valueList);
        double cityStd = calcStats.stdev(valueList);
        
        StringBuilder statsString = new StringBuilder();
        statsString.append("Statistics of Assessed Values: ");
        statsString.append("\n\nNumber of Properties: ");
        statsString.append(propCount);
        statsString.append("\nMin: $");
        statsString.append(this.lowValue);
        statsString.append("\nMax: $");
        statsString.append(this.highValue);
        statsString.append("\nRange: $");
        statsString.append(this.range());   
        statsString.append("\nMean: $");
        statsString.append(cityMean);
        statsString.append("\nMedian: $");
        statsString.append(cityMedian);
        statsString.append("\nStandard deviation: $");
        statsString.append(cityStd);
        statsString.append("\n");
        String neighStats = statsString.toString();
        return neighStats;
    }
    
    /**
     * updates the high and low values in a neighborhood
     * @param value double the assessed value of a property 
     */    
    public void updateValues(double value){
        // if City was empty 
        valueList.add(value);
        if (lowValue == -1){
            lowValue = value;
            highValue = value;
        }
        else{
            if (lowValue > value){
                lowValue = value;
            }
            if (highValue < value){
                highValue = value;
            }
        }
    }


}  