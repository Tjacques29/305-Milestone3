/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;


/**
 * This Class holds Address information for a property 
 * @author Brittina Morgan
 * 
 * Field        Description
 * suite        String the suite name or number for the address
 * houseNum     String the house number for the address
 * street Name  String the street name for the address
 */


public class Address {
    private String suite = "";
    private String houseNum ="";
    private String streetName ="";
  
    /**
     * This is the main constructor for the Address class
     * @param suite String the suite of the address
     * @param houseNum String the house number of the address
     * @param streetName String the streetName of the address
     */
    public Address(String suite, String houseNum, String streetName){
        this.suite = suite;
        this.houseNum = houseNum;
        this.streetName = streetName;
    }

    /**
     * This returns the suite of the address
     * @return suite String the suit of the address
     */
    public String getSuite(){
    return this.suite;
    }
    
    /**
     * This returns the house number of the address
     * @return houseNum String
     */
    public String gethouseNum(){
    return this.houseNum;
    }
    
    /**
     * This returns the street name of the address
     * @return streetName String
     */
    public String getStreet(){
        return this.streetName;
    }
    
    /**
     * Sets the suit of the address
     * @param suite String the suite of the address
     */
    public void setSuite(String suite){
        this.suite = suite;
    }
    
    /**
     * Sets the houseNum of the address
     * @param houseNum String the houseNum of the address
     */
    public void setHouseNum(String houseNum){
        this.houseNum = houseNum;
    }    
    
    /**
     * Sets the street name of the address
     * @param streetName String the streetName of the address
     */
    public void setStreetName(String streetName){
        this.streetName = streetName;
    }

    /**
     * Returns Property String
     * @return String propertyString
     */
    @Override
    public String toString(){
        StringBuilder addressString = new StringBuilder();
        addressString.append(this.suite);
        addressString.append(" ");
        addressString.append(this.houseNum);
        addressString.append(" ");
        addressString.append(this.streetName);
        return addressString.toString();
    }        
}