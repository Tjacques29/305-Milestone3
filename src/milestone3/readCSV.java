/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package milestone3;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *Purpose of readCSV is to get all of the data from the CSV file into a List of property objects
 * this class only needs the name of the file and access to the property class
 * @authors Ben
 *          Brittina Morgan
 */
public class readCSV {
    /*
    @purpose helps accountNumberAssessment find account number
    @param account number and filename
    @return list with  vaules 
    */
     static List allDatahelper(String name)throws Exception{
        Scanner token = new Scanner(name).useDelimiter(",");
        List<String> data = new ArrayList();
        for (int i =0; i<14; i++){
            data.add(token.next());
        }
        return data;
    }
     /*
    @purpose gets all of the data from the CSV file and returns it
    @param filename
    @return list of all properties
    */
    static List allData(String name)throws Exception{
        Scanner token = new Scanner(Paths.get(name)).useDelimiter(",");
        List<property> data = new ArrayList();
        token.nextLine();
        while(token.hasNextLine()){
            data.add(new property(allDatahelper(token.nextLine())));
        }
       return data;
        
    }
}
