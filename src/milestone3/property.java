/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package milestone3;
import static java.lang.String.valueOf;
import java.text.DecimalFormat;
import java.util.List;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *Purpose to store the values of a single column into a class so the column can be accessed easier
 * this needs a list of the values in the column
 * @authors Ben
 *          Brittina Morgan
 */
public class property {

private final SimpleIntegerProperty accountNum;
    private final SimpleIntegerProperty assessmentYear;
    private final SimpleStringProperty suite;
    private final SimpleStringProperty houseNum;
    private final SimpleStringProperty streetName;
    private final SimpleStringProperty neightbourhood;
    private final double assessedValue;
    private final float latitude;
    private final float longitude;
    private final SimpleStringProperty lotSize;
    private final SimpleIntegerProperty builtYear;
    private final SimpleStringProperty garage;
    private final SimpleStringProperty zoning;
    private final SimpleStringProperty assessmentClass1;
    private final SimpleStringProperty address;
    //private final String assessmentClass3;
    public property(List<String> data){
        this.accountNum= new SimpleIntegerProperty(Integer.parseInt(data.get(0)));
        this.assessmentYear = new SimpleIntegerProperty(Integer.parseInt(data.get(1)));
        this.suite = new SimpleStringProperty(data.get(2));
        this.houseNum = new SimpleStringProperty(data.get(3));
        this.streetName = new SimpleStringProperty(data.get(4));
        this.latitude = (float) Double.parseDouble(data.get(5));
        this.longitude =(float) Double.parseDouble(data.get(6));
        this.neightbourhood = new SimpleStringProperty(data.get(7));
        if (data.get(8).isEmpty()){
            this.builtYear = new SimpleIntegerProperty(0);
        }
        else{
            this.builtYear = new SimpleIntegerProperty(Integer.parseInt(data.get(8)));
        }
        this.garage = new SimpleStringProperty(data.get(9));
        this.zoning = new SimpleStringProperty(data.get(10));
        this.lotSize = new SimpleStringProperty(data.get(11));
        this.assessedValue =  Double.parseDouble(data.get(12));
        this.assessmentClass1 = new SimpleStringProperty(data.get(13));

        this.address = new SimpleStringProperty(data.get(3)+ " " +data.get(4));
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
    purpose: return assessment year
    parameters: non
    return: return assessment year
    */
    public int getAssessmentYear(){
        return assessmentYear.get();
    }
     /*
    purpose: return lotSize
    parameters: non
    return: return lotSize
    */
    public String getLotSize(){
        return lotSize.get();
    }
    /*
    purpose: return builtYear
    parameters: non
    return: return builtYear
    */
    public int getBuiltYear(){
        return builtYear.get();
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
    purpose: return suite num
    parameters: non
    return: return suite num
    */
    public String getZoning(){
        return zoning.get();
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
    purpose: return neighbourhood name
    parameters: non
    return: return neighbourhood name
    */
    public String getNeightbourhood(){
        return neightbourhood.get();
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
