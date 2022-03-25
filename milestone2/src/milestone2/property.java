/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package milestone2;

import static java.lang.String.valueOf;
import java.text.DecimalFormat;
import java.util.List;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 *Purpose to store the values of a single column into a class so the column can be accessed easier
 * this needs a list of the values in the column
 * @author BEN
 */
public class property {
    private final SimpleIntegerProperty accountNum;
    private final SimpleStringProperty suite;
    private final SimpleStringProperty houseNum;
    private final SimpleStringProperty streetName;
    private final SimpleStringProperty garage;
    private final SimpleStringProperty neighbourhoodID;
    private final SimpleStringProperty neightbourhood;
    private final SimpleStringProperty ward;
    private final double assessedValue;
    private final float latitude;
    private final float longitude;
    private final SimpleStringProperty pointLocation;
    private final SimpleIntegerProperty assessmentClassper1;
    private final SimpleStringProperty assessmentClassper2;
    private final SimpleStringProperty assessmentClassper3;
    private final SimpleStringProperty assessmentClass1;
    private final SimpleStringProperty assessmentClass2;
    private final SimpleStringProperty address;
    //private final String assessmentClass3;
    public property(List<String> data){
        this.accountNum= new SimpleIntegerProperty(Integer.parseInt(data.get(0)));
        this.suite = new SimpleStringProperty(data.get(1));
        this.houseNum = new SimpleStringProperty(data.get(2));
        this.streetName = new SimpleStringProperty(data.get(3));
        this.garage = new SimpleStringProperty (data.get(4));
        this.neighbourhoodID = new SimpleStringProperty(data.get(5));
        this.neightbourhood = new SimpleStringProperty(data.get(6));
        this.ward = new SimpleStringProperty(data.get(7));
        this.assessedValue =  Double.parseDouble(data.get(8));
        this.latitude = (float) Double.parseDouble(data.get(10));
        this.longitude =(float) Double.parseDouble(data.get(9));
        this.pointLocation = new SimpleStringProperty(data.get(11));
        this.assessmentClassper1 = new SimpleIntegerProperty(Integer.parseInt(data.get(12)));
        this.assessmentClassper2 = new SimpleStringProperty(data.get(13));
        this.assessmentClassper3 = new SimpleStringProperty(data.get(14));
        this.assessmentClass1 = new SimpleStringProperty(data.get(15));
        this.assessmentClass2 = new SimpleStringProperty(data.get(16));
        this.address = new SimpleStringProperty(data.get(2)+ " " +data.get(3));
        //this.assessmentClass3 = (data.get(17));
    }
     /*
    purpose: return account num
    parameters: non
    return: return account num
    */
    public int getAccountNum(){
        return accountNum.get();
    }
    /*
    purpose: return suite num
    parameters: non
    return: return suite num
    */
    public String getSuite(){
        return suite.get();
    }
    /*
    purpose: return house num
    parameters: non
    return: return house num
    */
    public String getHouseNum(){
        return houseNum.get();
    }
    /*
    purpose: return if garage is persent
    parameters: non
    return: return if garage is persent
    */
    public String getGarage(){
        return garage.get();
    }
    /*
    purpose: return street name 
    parameters: non
    return: return street name
    */
    public String getStreetName(){
        return streetName.get();
    }
    /*
    purpose: return neighbourhood id
    parameters: non
    return: return neighbourhood id
    */
    public String getNeighbourhoodID(){
        return neighbourhoodID.get();
    }
    /*
    purpose: return neighbourhood name
    parameters: non
    return: return neighbourhood name
    */
    public String getNeightbourhood(){
        return neightbourhood.get();
    }
    /*
    purpose: return ward
    parameters: non
    return: return ward
    */
    public String getWard(){
        return ward.get();
    }
    /*
    purpose: return assessed value
    parameters: non
    return: return assessed value
    */
    public String getAssessedValue(){
        return "$"+stats.addComma(assessedValue);
    }
    public double getIntAssessed(){
        return assessedValue;
    }
    /*
    purpose: return latitude
    parameters: non
    return: return latitude
    */
    public float getLatitude(){
        return latitude;
    }
    /*
    purpose: return longitude
    parameters: non
    return: return longitude
    */
    public float getLongitude(){
        return longitude;
    }
    /*
    purpose: return point location
    parameters: non
    return: return point lcoation
    */
    public String getPointLocation(){
        return pointLocation.get();
    }
    /*
    purpose: return assessment class %1
    parameters: non
    return: return assessment class %1
    */
    public int getAssessmentClassper1(){
        return assessmentClassper1.get();
    }
    /*
    purpose: return assessment class %2
    parameters: non
    return: return assessment class %2
    */
    public String getAssessmentClassper2(){
        return assessmentClassper2.get();
    }
    /*
    purpose: return assessment class %3
    parameters: non
    return: return assessment class %3
    */
    public String getAssessmentClassper3(){
        return assessmentClassper3.get();
    }
    /*
    purpose: return assessment class
    parameters: non
    return: return assessment class
    */
    public String getAssessmentClass1(){
        return assessmentClass1.get();
    }
    /*
    purpose: return address
    parameters: non
    return: return address
    */
    public String getAddress(){
        return address.get();
    }
    

  
}
