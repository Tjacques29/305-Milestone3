package com.mycompany.mavenproject2;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


/**
 * This class holds information about individual properties
 * 
 * accountNum       The unique identifier for each property
 * address          The Address object for each property
 * garage           A Boolean indicating if a property has a garage
 * neighborhood     The name of the neighborhood the property belongs to
 * neighID          The ID of the neighborhood the property belongs to
 * ward             The ward the property belongs to
 * value            The assessed dollar value of the property
 * location         The GPS location of the property
 * assessClass      The assessed class of the property
 * 
 * @author Brittina Morgan
 */
public class Property {
    private SimpleIntegerProperty accountNum;
    private Address address;
    private boolean garage;     
    private SimpleStringProperty  neighbourhood;
    private double lotSize;
    private double yearBuilt;
    private double value;
    private Location location;
    private SimpleStringProperty assessClass;
    private double year;
    private double latitude;
    private double longitude;


    /**
     * The main constructor for the Property Class
     * @param accountNum String Unique ID of property
     * @param address   Address object for property
     * @param garage    Boolean indicating if Property has a garage
     * @param neighborhood String name of neighborhood
     * @param neighID String ID of neighborhood
     * @param ward  String Ward property belongs to
     * @param value Double the assessed value of the property
     * @param location  Location the GPS location of the property
     * @param assessClass   The assessed Class of the property 
     */
    public Property(int accountNum, Address address, boolean garage, 
            String neighbourhood, double lotSize, double yearBuilt, double value, 
            Location location, String assessClass, double year ){
        
        this.accountNum = new SimpleIntegerProperty(accountNum);
        this.address = address;
        this.garage = garage;
        this.neighbourhood = new SimpleStringProperty(neighbourhood);
        this.lotSize = lotSize;
        this.yearBuilt = yearBuilt;
        this.value = value;
        this.year = year;
        this.location = location;
        this.latitude = location.getLat();
        this.longitude = location.getLong();
        this.assessClass = new SimpleStringProperty(assessClass);
    }
    
    /**
    * This returns the property account number. 
    * @return accountNum int A unique identifier for properties 
    */
    public final Integer getAccountNum(){
    return this.accountNum.get();
    }
       
    /**
    * This returns the property Address. 
    * @return address Address the class that holds the property address info
    */
    public final Address getAddress(){
        return this.address;
    }
    
    /**
    * This returns true if the property has a garage and false if it does not. 
    * @return garage Boolean 
    */
    public boolean getGarage(){
    return this.garage;
    }
    
    /**
    * This returns name of the Neighborhood the property is in 
    * @return neighborhood String A neighborhood name 
    */
    public final String getNeigbourhood(){
        return this.neighbourhood.get();
    }
        
    
    /**
    * This returns the value of the property 
    * @return value double the value of the property
    */
    public final double getValue(){
        return this.value;
    }
    
    /**
    * This returns location information for the property
    * @return location Location the lat and long of the property
    */
    public Location getLocation(){
        return this.location;
    }
    
    
    public final double getLatitude() {
        return latitude;
    }

    public final double getLongitude() {
        return longitude;
    }

    /**
    * This returns Assessment Class of the property
    * @return assessClass String the class the property was assessed to be
    */
    public final String getAssessClass(){
        return this.assessClass.get();
    }
    
        /**
    * This sets the property account number. 
    * @param accountNum int A unique identifier for properties 
    */
    public final void setAccountNum(int accountNum){
        this.accountNum = new SimpleIntegerProperty(accountNum);
    }
 
    /**
    * This sets the property Address. 
    * @param address Address the class that holds the property address info
    */
    public void setAddress(Address address){
        this.address = address;
    }
    
    
    /**
    * This sets true if the property has a garage and false if it does not. 
    * @param garage Boolean 
    */
    public void setGarage(boolean garage){
        this.garage = garage;
    }
    
    /**
    * This sets the name of the Neighborhood the property is in 
    * @param neighbourhood String A neighborhood name 
    */
    public void setNeig(String neighbourhood){
        this.neighbourhood = new SimpleStringProperty(neighbourhood);
    }
        
    
    /**
    * This sets the value of the property 
    * @param value double the value of the property
    */
    public void setValue(double value){
        this.value = value;
    }
    
    /**
    * This sets the location information for the property
    * @param location Location the lat and long of the property
    */
    public void setLocation(Location location){
        this.location = location;
    }
     
    /**
    * This sets the Assessment Class of the property
    * @param assessClass String the class the property was assessed to be
    */
    public void setAssessClass(String assessClass){
        this.assessClass = new SimpleStringProperty(assessClass);
    }
    
      public void setLotSize(double lotSize) {
        this.lotSize = lotSize;
    }

    public void setYearBuilt(double yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public void setYear(double year) {
        this.year = year;
    }

    public double getLotSize() {
        return lotSize;
    }

    public double getYearBuilt() {
        return yearBuilt;
    }

    public final double getYear() {
        return year;
    }  
    
    
    
    
    
    
    /**
     * Class implements equality check 
     * @param other Object being compared
     * @return True if they are equal, else False
     */
    @Override
    public boolean equals(Object other){
        Property otherProperty = (Property) other;
        return this.accountNum == otherProperty.accountNum;
    }

    /**
     * Returns Property String
     * @return String propertyString
     */
    @Override
    public String toString(){
        StringBuilder propertyString = new StringBuilder();
        propertyString.append("Account Number =  ");
        propertyString.append(this.accountNum);
        propertyString.append("\nAddress = ");
        propertyString.append(this.address);
        propertyString.append("\nAssessed value = $");
        propertyString.append(this.value);
        propertyString.append("\nAssessment Class = ");
        propertyString.append(this.assessClass);
        propertyString.append("\nNeighborhood = ");
        propertyString.append(this.neighbourhood);
        propertyString.append("(");
        propertyString.append(this.year);
        propertyString.append("}");
        propertyString.append("\nLocation = ");
        propertyString.append(this.location);
        return propertyString.toString();
    }      
}