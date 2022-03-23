package com.mycompany.mavenproject2;

import java.io.BufferedReader;  
import java.io.FileReader;            
import java.io.*;
import java.util.Scanner; 
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import ScannerIO.Input;
import java.nio.file.Paths;
import java.text.DecimalFormat;



/**
 * This class holds all of the data associated with the City. It includes
 * the file reader and all search methods
 * 
 * @author Brittina Morgan
 * 
 * Constant         Description
 * ACCOUNT          Index in CSV file line for property Account Number
 * SUITE            Index in CSV file line for property Suite
 * HOUSE            Index in CSV file line for House Number
 * STREET           Index in CSV file line for property Street Name
 * GARAGE           Index in CSV file line for if property has garage
 * NEIGHBOURHOODID    Index in CSV file line for property Neighborhood Id
 * NEIGHBOURHOOD    Index in CSV file line for property Neighborhood Name
 * WARD             Index in CSV file line for property Ward
 * VALUE            Index in CSV file line for Assessed Value of property
 * LATITUDE         Index in CSV file line for property Latitude
 * LONGITUDE        Index in CSV file line for property Longitude
 * CLASS            Index in CSV file line for property Assessment Class
 * 
 * QUIT             Menu option to quit the program
 * 
 * Field            Description
 * propertyList     List containing all properties in City
 * valueList        List containing all assessed values of properties in City
 * neighborhoodList List containing all Neighborhoods in City
 * lowValue         Value of lowest assessed property in City,when City is 
 *                  empty lowValue is -1
 * highValue        Value of hightest assessed property in City, when city is 
 *                  empty highValue is -1
 */

public class City implements DisplayStats{
    
    //CSV Indicies for Property Assessment Data
    private static final int ACCOUNT = 0;
    private static final int SUITE = 1;
    private static final int HOUSE = 2;
    private static final int STREET = 3;
    private static final int GARAGE = 4;
    private static final int NEIGHBOURHOODID = 5;
    private static final int NEIGHBOURHOOD = 6;
    private static final int WARD = 7;
    private static final int VALUE = 8;
    private static final int LATITUDE = 9;
    private static final int LONGITUDE = 10;
    private static final int CLASS = 15;
    

    // Lists to hold Properies, Neighbourhoods, Assessed Class and Vlaues
    private static List<Property> propertyList = new ArrayList<Property>();


    private static List<Neighborhood> neighbourhoodList = new ArrayList<Neighborhood>();
    //private static List<Assessment> assessmentList = new ArrayList<Assessment>();
    private static List<Double> valueList = new ArrayList<Double>(); 
    
    // High and Low values in City
    private static double lowValue = -1; //minium assesed property value in city's properties
    private static double highValue = -1; //maximum assessed property value in city's properties 
    
    /**
     * This is the main constructor for the City class.
     */
    public City(){}

    /**
     * This is the secondary constructor for the City class.
     * @param properties An list of properties that will be added to the city
     */
    public void buildCity(ArrayList<Property> properties){
        
        for (Property property : properties){
            valueList.add(property.getValue());
            if (lowValue == -1){
            lowValue = property.getValue();
            highValue = property.getValue();
            }
            else{
            if (lowValue > property.getValue()){
                lowValue = property.getValue();
            }
            if (highValue < property.getValue()){
                highValue = property.getValue();
            }
            }
            propertyList.add(property);         
        }
    }
    
    /**
     * Returns the difference between the maximum and minimum values
     * @return The difference between min and max
     */
    public double range(){
        // needs exception 

        return this.highValue - this.lowValue;
    }
    

    /**
     * This takes a filename of a csv file, iterates through the rows and 
     * extracts property information for a given City. 
     * @param filename
     * @throws IOException 
     */
    public void readPropertyAssessmentCSV(String filename) throws IOException{
        
        BufferedReader buff = new BufferedReader(new FileReader(filename));
        String row = "";
        buff.readLine();
        //Address propertyAdress;
        while ((row = buff.readLine()) != null){   //returns a Boolean value  
            String[] property = row.split(",");
            Address propertyAddress = new Address(property[SUITE], property[HOUSE], property[STREET]);
            
            //Convert latitidue and longitude to double
            double latitude = Double.parseDouble(property[LATITUDE]);
            double longitude = Double.parseDouble(property[LONGITUDE]);            
            Location propertyLoc = new Location(latitude, longitude);
            
            // account number and value 
            int accountNum = Integer.parseInt(property[ACCOUNT]); 
            double value = Double.parseDouble(property[VALUE]);
            
            // get garage value
            boolean garage = false;
            if (property[GARAGE] == "Y"){
                garage = true;
            }            
            Property newProperty;
            newProperty = new Property(accountNum, propertyAddress, garage, 
                    property[NEIGHBOURHOOD], property[NEIGHBOURHOODID], 
                    property[WARD],value, propertyLoc, property[CLASS] );
            // Update City Values              
            updateCity(value, newProperty);
            
            //Update Neighbourhood
            int result = isThereN(property[NEIGHBOURHOOD]);
            if (result >=0){
                Neighborhood tempNe = neighbourhoodList.get(result);
                tempNe.updateValues(value);
                neighbourhoodList.set(result,tempNe);
            }
            else{
                Neighborhood newNe = new Neighborhood(property[NEIGHBOURHOOD], 
                        property[NEIGHBOURHOODID], value);
                neighbourhoodList.add(newNe);
            }
        }
    }
   
    
    /**
     * Updates the high and low property values and adds new property to the
     * city
     * @param value double the assessed property value
     * @param newProperty the new property object to add to the city
     */
    public void updateCity(double value, Property newProperty){
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
        propertyList.add(newProperty);         
    }
  
    /**
     * This outputs the stats of the City Class 
     */
    @Override
    public String displayStats(){
        int propCount = valueList.size();
        Stats calcStats = new Stats();
        double cityMean = calcStats.mean(valueList);
        double cityMedian = calcStats.median(valueList);
        double cityStd = calcStats.stdev(valueList);
        DecimalFormat currency = new DecimalFormat("$0,000.00");
        //String value = currency.format(data.getValue().getValue());
        StringBuilder statsString = new StringBuilder();
        statsString.append("Statistics of Assessed Values: ");
        statsString.append("\n\nNumber of Properties: ");
        statsString.append(propCount);
        statsString.append("\nMin: ");
        statsString.append(currency.format(this.lowValue));
        statsString.append("\nMax: ");
        statsString.append(currency.format(this.highValue));
        statsString.append("\nRange: ");
        statsString.append(currency.format(this.range()));   
        statsString.append("\nMean: ");
        statsString.append(currency.format(cityMean));
        statsString.append("\nMedian: ");
        statsString.append(currency.format(cityMedian));
        statsString.append("\nStandard deviation: ");
        statsString.append(currency.format(cityStd));
        statsString.append("\n");
        String cityStats = statsString.toString();
        return cityStats;
    }
    
    /**
     * This returns true if the property id is in the city
     * @param account String the property Id being searched
     * @return Boolean true if there false if not
     */
    public static boolean isThere(String account){
        int searchAccount = Integer.parseInt(account);
        for (Property property : propertyList ){
            int propNum = property.getAccountNum();
            if (propNum == searchAccount){
                return true;
            }
        }
        return false;
    }
    
    /**
     * This returns true if the Neighborhood is in the city
     * @param name String the neighborhood being searched
     * @return index int index of neighborhood, -1 if not found
     */
    public static int isThereN(String name){
        int index =0;
        for (Neighborhood hood : neighbourhoodList ){
            String hoodName = hood.getName();
            if (hoodName.equals(name)){
                return index;
            }
            index ++;
        }
        return -1;
    }
    
    
    /**
     * This returns a property object if it is in the city
     * @param account String the property Id being searched
     * @return property Property the property matching the searched Id
     */
    public Property getProperty(String account){
        int searchAccount = Integer.parseInt(account);
        for (Property property : propertyList ){
            int propNum = property.getAccountNum();
            if (propNum == searchAccount){
                return property;
            }
        } 
        return null;
    }
    
    /**
     * This returns a property object if it is in the city
     * @param name String the name of the neighborhood being searched
     * @return neighborhood Neighborhood the neighborhood object that 
     * matches the searched name
     */
    public Neighborhood getNeighborhood(String name){
        for (Neighborhood hood : neighbourhoodList ){
            String hoodName = hood.getName();
            if (hoodName.equals(name)){
                return hood;
            }
        } 
        return null;
    }
    
    /**
     * This returns the List of properties in the City
     * @return propertyList List the list of properties held within the city
     * class
     */
    public static List<Property> getPropertyList() {
        return propertyList;
    }

}
