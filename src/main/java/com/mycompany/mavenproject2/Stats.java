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
 * This program is a collection of functions that will return metrics 
 * of a given list
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stats {

    private List<Double> list;    
 
    public Stats() {

    }


    /**
     * Returns the number of data items in the given list
     * @param list A list of doubles
     * @return list.size() the size of the list
     */
    public int n(List<Double> list){

        return list.size();

    }


    /**
     * Returns the smallest value in the list
     * @param list A list of doubles
     * @return lowest The minimum value in the list
     */
    public double min(List<Double> list){
        if (list.isEmpty())
            return -0.0;
        Double lowest = list.get(0);
        int y = list.size()-1;
        for (int x = y; x>=0; x--)
        {
            if (list.get(x) <= lowest)
              lowest = list.get(x);  
        }
        
        return lowest;

    }

    /**
     * Returns the largest value in the list
     * @param list A list of doubles
     * @return highest The highest value in the list
     */
    public double max(List<Double> list){
        if (list.isEmpty())
            return -0.0;        
        Double highest = 0.0;
        int y = list.size()-1;
        for (int x = y; x>=0; x--)
        {
            if (list.get(x) >= highest)
              highest = list.get(x);  
        }
        
        return highest;

    }

    /**
     * Returns the difference between the maximum and minimum values
     * @param list A list of doubles
     * @return The difference between min and max
     */
    public double range(List<Double> list){
        if (list.isEmpty())
            return -0.0;        
        Double high = max(list);
        Double low = min(list);
        return high - low;

    }

    /**
     * Returns the mean (average) of the data items
     * @param list A list of doubles
     * @return The average of the list
     */
    public double mean(List<Double> list){
        if (list.isEmpty())
            return -0.0;
        double sum = 0.0;
        for (int x = 0; x<list.size();x++)
            sum = sum + list.get(x);
        
        return sum/list.size();

    }

    /**
     * Returns the population standard deviation of the data items
     * @param list A list of doubles
     * @return res the standard deviation in the list 
     */
    public double stdev(List<Double> list){
        if (list.isEmpty())
            return -0.0;        
        double listMean;
        listMean = mean(list);
        double sum = 0.0;
        double dif = 0.0;
        
        for (int x = 0; x<list.size();x++)
            dif = Math.pow((list.get(x) - listMean), 2);
            sum += dif;
        double res = sum/list.size();
        res = Math.sqrt(res);
        return res;

    }

    /**
     * Returns the median of the list of values
     * @param list A list of doubles
     * @return listMedian the median of the list values
     */
    public double median(List<Double> list){
        if (list.isEmpty())
            return -0.0; 
        int mid;
        Collections.sort(list);    
        double listMedian = 0.0;
        if (list.size()%2 == 0) //list size is even
        {
            mid = Math.floorDiv(list.size(), 2);
            listMedian = ((list.get(mid)+ list.get(mid+1))/2);
        }       
        else //list size is odd
            mid = Math.floorDiv(list.size(), 2);         
            listMedian = list.get(mid);
         
        return listMedian;

    }

    /*
    Testing function used to validate Stats module 
    */
    public void testing(){
        // Test Case Empty List
        List<Double> testingList = new ArrayList<Double>();
        double listSize = n(testingList);
        double listMin = min(testingList);
        double listMax = max(testingList);
        double listRange = range(testingList);
        double listMean = mean(testingList);
        double listStdev = stdev(testingList);
        double listMedian = median(testingList);
        
        System.out.println("Testing Empty List: \nSize: " + listSize +"\nMin: "
                + listMin + "\nMax: "+ listMax+ "\nRange: "+ listRange+ "\nMean"
                + listMean+ "\nStdev:"+ listStdev+ "\nMedian:"+ listMedian); 
        
        
        // Odd Sized List
        
        List<Double> testingList1 = new ArrayList<Double>();
        double newItem= 0.0;
        for(int x=1; x<10;x++)
        {
            newItem = Math.random()*10;
            testingList1.add(newItem);
        }
        double listSize1 = n(testingList1);
        double listMin1 = min(testingList1);
        double listMax1 = max(testingList1);
        double listRange1 = range(testingList1);
        double listMean1 = mean(testingList1);
        double listStdev1 = stdev(testingList1);
        double listMedian1 = median(testingList1);
        
        System.out.println("\nTesting Odd Sized List: \nSize: " + listSize1 +"\nMin: "
                + listMin1 + "\nMax: "+ listMax1+ "\nRange: "+ listRange1+ "\nMean"
                + listMean1+ "\nStdev:"+ listStdev1+ "\nMedian:"+ listMedian1); 
        
                
        // Even Sized List 
        
        List<Double> testingList2 = new ArrayList<Double>();
        double newItem2= 0.0;
        for(int x=1; x<13;x++)
        {
            newItem2 = Math.random()*10;
            testingList2.add(newItem);
        }
        double listSize2 = n(testingList2);
        double listMin2 = min(testingList2);
        double listMax2 = max(testingList2);
        double listRange2 = range(testingList2);
        double listMean2 = mean(testingList2);
        double listStdev2 = stdev(testingList2);
        double listMedian2 = median(testingList2);
        
        System.out.println("\nTesting Even Sized List: \nSize: " + listSize2 +"\nMin: "
                + listMin2 + "\nMax: "+ listMax2+ "\nRange: "+ listRange2+ "\nMean"
                + listMean2+ "\nStdev:"+ listStdev2+ "\nMedian:"+ listMedian2); 
        
        
    }
   }