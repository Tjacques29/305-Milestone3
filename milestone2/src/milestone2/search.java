/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package milestone2;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**Purpose to search the list of properties and find the correct values based on the data given
 *
 * @author BEN
 */
public class search {
    /*
    purpose: to find all of the neighbourhood assessed value given the parametes
    parameters: String of what neighbourhood to find and a ObservableList<property> of all the data in the csv file
    return: return only the values of the specific neighbourhood
    */
    static List neighbourhoodDataFinder(String neighbourhood,ObservableList<property>data){
        List<Double> neighbourhoodDataList = new ArrayList();
        for(int i=0;i<data.size();i++){
            if((data.get(i).getNeightbourhood()).equals(neighbourhood.toUpperCase())){
                neighbourhoodDataList.add(data.get(i).getIntAssessed());
            }
        }
        return neighbourhoodDataList;
    }
    /*
    purpose: to find all of the neighbourhood properties based on the search
    parameters: String of what neighbourhood to find and a ObservableList<property> of all the data in the csv file
    return: return only the properties of the specific neighbourhood
    */
    static List neighbourhoodDataPropertyFinder(String neighbourhood,ObservableList<property>data){
        List<property> neighbourhoodDataList = new ArrayList();
        for(int i=0;i<data.size();i++){
            if((data.get(i).getNeightbourhood()).equals(neighbourhood.toUpperCase())){
                neighbourhoodDataList.add(data.get(i));
            }
        }
        return neighbourhoodDataList;
    }
    /*
    purpose: to find all data assessed value given the parametes
    parameters: a ObservableList<property> of all the data in the csv file
    return: return all assessed values
    */
    static List allData(ObservableList<property>data){
        List<Double> allDataList = new ArrayList();
        for(int i = 0;i<data.size();i++){
            allDataList.add(data.get(i).getIntAssessed());
        }
        return allDataList;
    }
    /*
    purpose: to find assessmentclass datas assessed value given the parametes
    parameters: assessmentName, a ObservableList<property> of all the data in the csv file
    return: return all assessed values of specific assessmentclass
    */
    static List assessmentData(String assessmentName,ObservableList<property>data){
        List<Double> assessmentNameDataList = new ArrayList();
        for(int i=0;i<data.size();i++){
            if((data.get(i).getAssessmentClass1()).equals(assessmentName.toUpperCase())){
                assessmentNameDataList.add(data.get(i).getIntAssessed());
            }
        }
        return assessmentNameDataList;
    }
    /*
    purpose: to find assessmentclass datas properties given the parametes
    parameters: assessmentName, a ObservableList<property> of all the data in the csv file
    return: return all properties of specific assessmentclass
    */
    static List assessmentDataPropertyFinder(String assessmentName,ObservableList<property>data){
        List<property> assessmentNameDataList = new ArrayList();
        for(int i=0;i<data.size();i++){
            if((data.get(i).getAssessmentClass1()).equals(assessmentName.toUpperCase())){
                assessmentNameDataList.add(data.get(i));
            }
        }
        return assessmentNameDataList;
    }
    /*
    purpose: to find account number datas assessed value given the parametes
    parameters: accountNum, a ObservableList<property> of all the data in the csv file
    return: return account number data
    */
    static String accountNumberSearch(String accountNum,ObservableList<property>data){
        String accountNumInfo = null;
        for(int i = 0;i<data.size();i++){
            if(Integer.parseInt(accountNum)==data.get(i).getAccountNum()){
                 accountNumInfo="Account number = " +data.get(i).getAccountNum()+"\n"+"Address = " + data.get(i).getAddress() +"\n"+"Assessment value = $" +stats.addComma(data.get(i).getIntAssessed())+"\n"+"Assessment class = " +data.get(i).getAssessmentClass1()+"\n"+"Neighbourhood = " + data.get(i).getNeightbourhood() + " (" + data.get(i).getWard() + ")" +"\n"+"Location = (" +data.get(i).getLongitude() + ", " + data.get(i).getLatitude() +")";
                 break;
            }
        }
        return accountNumInfo;
        
    }
    /*
    purpose: to find account number datas property given the parametes
    parameters: accountNum, a ObservableList<property> of all the data in the csv file
    return: return account number property
    */
    static List accountNumberPropertyFinder(String accountNum,ObservableList<property>data){
        List<property> accountNumProperty = new ArrayList();
        for(int i=0;i<data.size();i++){
            if(Integer.parseInt(accountNum)==data.get(i).getAccountNum()){
                accountNumProperty.add(data.get(i));
            }
        }
        return accountNumProperty;
    }
    /*
    purpose to get the data from address into a string
    parameters address, ObservableList<property> of all the data in the csv file
    return: string of data
    */
    static String addressSearch(String address,ObservableList<property>data){
        String addressData = null;
        for(int i = 0;i<data.size();i++){
            if((address.toUpperCase()).equals(data.get(i).getAddress())){
                addressData = "Address = "+data.get(i).getAddress()+"\n"+"Account number = " +data.get(i).getAccountNum()+"\n"+"Assessment value = $" +stats.addComma(data.get(i).getIntAssessed())+"\n"+"Assessment class = " +data.get(i).getAssessmentClass1()+"\n"+"Neighbourhood = " + data.get(i).getNeightbourhood() + " (" + data.get(i).getWard() + ")" +"\n"+"Location = (" +data.get(i).getLongitude() + ", " + data.get(i).getLatitude() +")";
            }
        }
        return addressData;
    }
    /*
    purpose to get the property from address 
    parameters address, ObservableList<property> of all the data in the csv file
    return: return: return address property
    */
    static List addressPropertyFinder(String address,ObservableList<property>data){
        List<property> addressProperty = new ArrayList();
        for(int i=0;i<data.size();i++){
            if((address.toUpperCase()).equals(data.get(i).getAddress())){
                addressProperty.add(data.get(i));
            }
        }
        return addressProperty;
    }
    /*
    purpose: to find all of the neighbourhood name and assessment class assessed value given the parametes
    parameters: String of what neighbourhood and what assessment class to find and a ObservableList<property> of all the data in the csv file
    return: return only the values of the specific neighbourhood and assessment class
    */
    static List neighbourhoodPlusAssessmentClass(String neighbourhood,String assessmentName,ObservableList<property>data){
        List<Double> neighbourhoodPlusAssessmentClassDataList = new ArrayList();
        for(int i=0;i<data.size();i++){
            if((data.get(i).getNeightbourhood()).equals(neighbourhood.toUpperCase())&&(data.get(i).getAssessmentClass1()).equals(assessmentName.toUpperCase())){
                neighbourhoodPlusAssessmentClassDataList.add(data.get(i).getIntAssessed());
            }
        }
        return neighbourhoodPlusAssessmentClassDataList;
    }
    /*
    purpose: to find all of the neighbourhood name and assessment class assessed value given the parametes
    parameters: String of what neighbourhood and what assessment class to find and a ObservableList<property> of all the data in the csv file
    return: return only the values of the specific neighbourhood and assessment class
    */
    static List neighbourhoodPlusAssessmentClassPropertyFinder(String neighbourhood,String assessmentName,ObservableList<property>data){
        List<property> addressProperty = new ArrayList();
        for(int i=0;i<data.size();i++){
            if((data.get(i).getNeightbourhood()).equals(neighbourhood.toUpperCase())&&(data.get(i).getAssessmentClass1()).equals(assessmentName.toUpperCase())){
                addressProperty.add(data.get(i));
            }
        }
        return addressProperty;
    }
 }
