/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package milestone2;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

/**
 *purpose to preform stats on data
 * needs a list of doubles of the data
 * @author BEN
 */
public class stats {
    /*
    @param list of values
    @return length of list
    */
    static int n(List<Double> myList){
        int len = myList.size();
        return len;
    }
    /*
    @param list of values
    @return min value in list
    */
    static double min(List<Double> myList){
        int index = 0;
        double minimum = Double.MAX_VALUE;
        for(double ele: myList){
            if (ele < minimum)
            {
                minimum = ele;
            }
            index++;
        }
        return minimum;
    }
    /*
    @param list of values
    @return max value in list
    */
    static double max(List<Double> myList){
        int index = 0;
        double maximum = Double.MIN_VALUE;
        
        for(double ele: myList){
            if (ele > maximum)
            {

                maximum = ele;
            }
            index++;
        }
        return maximum;
    }
    /*
    @param list of values
    @return the different between max and min values
    */
    static double range(List<Double> myList){
        double maximum = max(myList);
        double minimum = min(myList);
        return maximum - minimum;
    }
    /*
    @param list of values
    @return the mean of the list
    */
    static double mean(List<Double> myList){
        int len = n(myList);
        double sum = 0;
        for(double ele: myList){
            sum = sum + ele;
        }
        double total = (sum/len);
        return total;
    }
    /*
    @param list of values
    @return standard devation
    */
    static double stdev(List<Double> myList){
        int len = n(myList);
        double sum = 0;
        double average = mean(myList);
        for(double ele: myList){
            double tempSum = Math.abs(ele - average);
            sum = sum + Math.pow(tempSum,2);
        }
        sum = sum/len;
        sum = Math.sqrt(sum);
        
        return sum;
    }
    /*
    @param list of values
    @return median
    */
    static double median(List<Double> myList){
        Collections.sort(myList);
        int len = n(myList);
        int mid = 0;
        double median = 0;
        int index = 0;
        mid = len/2;
        if (len%2==0){
            for(double ele: myList){
                if (index == mid-1){
                    median = median + ele;
                }
                if (index == mid){
                    median = median + ele;
                }
                index++;
            }
        median = median/2;
        return median;
        }
        else{
            for(double el: myList){
                if (index ==mid){
                    median = median + el;
                }
                index++;
            }
            return median;
        }
    }
    /*
    @purpose to test all descriptive statistics on a list
    @param list of values
    @return none
    */
    static String test(List<Double> myList){
        String data = "Number of Properties = " + addComma(n(myList)) +"\n"+"min = $" + addComma(min(myList))+"\n"+"max = $" +addComma(max(myList))+"\n"+"range = $" +addComma(range(myList))+"\n"+"mean = $" + addComma(mean(myList))+"\n"+"sd = $" +addComma(stdev(myList))+"\n"+"median = $" +addComma(median(myList));
        return data;
        
    }
    /*
    @purpose to add commas to numbers
    @param the number itself
    @return number with commas
    */
    static String addComma(double vaule){
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(vaule);
    }
    
}
