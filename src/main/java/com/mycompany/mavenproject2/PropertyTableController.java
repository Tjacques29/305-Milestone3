/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import com.mycompany.mavenproject2.Address;
import com.mycompany.mavenproject2.City;
import com.mycompany.mavenproject2.Location;
import com.mycompany.mavenproject2.Property;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * FXML Controller class
 *
 * @author Brittina Morgan
 * 
 * Field            Description
 * txtfldAccount
 * txtfldAddress
 * txtfldNeighbourhood
 * txtStats
 * cmbClass
 * cmbList
 * colAccountNum
 * colAddress
 * colAssClass
 * colAssVal
 * colLat
 * colLong
 * colNeigh
 * propertyTable
 * 
 */
public class PropertyTableController implements Initializable {
   
    // observable lists to store data 
    private final ObservableList<String> cmbList = FXCollections.observableArrayList(
            "All", "Residential", "Other Residential", "Commercial", "Farmland");

    private final ObservableList<Property> dataList = FXCollections.observableArrayList();
 
    // @FXML objects
    @FXML
    private TextField txtfldAccount;
        
    @FXML
    private TextField txtfldAddress;

    @FXML
    private TextField txtfldNeighbourhood;
    
    @FXML
    private Text txtStats;
   
    @FXML
    private ComboBox <String> cmbClass;
    
    @FXML
    private TableColumn<Property, Integer> colAccountNum;

    @FXML
    private TableColumn<Property, Address> colAddress;  
    
    @FXML
    private TableColumn<Property, String> colAssClass;

    @FXML
    private TableColumn<Property, String> colAssVal;

    @FXML
    private TableColumn<Property, Double> colLat;

    @FXML
    private TableColumn<Property, Double> colLong;

    @FXML
    private TableColumn<Property, String> colNeigh;
    
    @FXML
    private TableColumn<Property, String> colYearAss;
    
    @FXML
    private TableView<Property> propertyTable;
      
    @FXML
    private void btnResetPressed(ActionEvent event) throws IOException {
        App.setRoot("propertyTable");
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // setup combo box
        cmbClass.setItems(cmbList);
       
        
        // set value display format
        DecimalFormat currency = new DecimalFormat("$0,000.00");
        DecimalFormat years = new DecimalFormat("0000");
        
        // declare what data will fill each column
        colAccountNum.setCellValueFactory(new PropertyValueFactory<
                Property, Integer>("accountNum"));
        colAddress.setCellValueFactory(new PropertyValueFactory<
                Property, Address>("address"));
        colNeigh.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNeigbourhood()));
        colAssClass.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAssessClass()));
        colAssClass.setCellValueFactory(new PropertyValueFactory<
               Property, String>("assessClass"));        
        colAssVal.setCellValueFactory(data -> {String value = 
                currency.format(data.getValue().getValue());
                return new SimpleStringProperty(value);
        });
        colLat.setCellValueFactory(new PropertyValueFactory<
                Property, Double>("latitude"));     
        colLong.setCellValueFactory(new PropertyValueFactory<
                Property, Double>("longitude"));   
        colYearAss.setCellValueFactory(data -> {String year = 
                years.format(data.getValue().getYear());
                return new SimpleStringProperty(year);
        }); 
        
        // Load City Data
        City newCity = new City();
        String filename = "Property_Assessment_Data_Historical.csv";
        try{
            newCity.readPropertyAssessmentCSV(filename);
            System.out.println("File: " + filename + " loaded.");
        }
        catch(IOException ioEX){
            System.out.println("File: " + filename + " not found.");
            return;
        }
        if (dataList.isEmpty()){
            dataList.addAll(newCity.getPropertyList());
        }
        
        // Wrap ObservableList in FiliteredList
        FilteredList<Property> filteredData = new FilteredList<Property>(
                dataList, p -> true);        
        
        // Set filter Predicate text is changed #TODO change trigger to button
        txtfldAccount.textProperty().addListener((observable, oldValue, newValue) ->{
            filteredData.setPredicate(property-> {
                
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                
                // If filter text is empty display all properties
                String filterText = newValue.toLowerCase();
                
                // Compare Account number to filter text
                if (property.getAccountNum().toString().indexOf(filterText) != -1) {
                    return true;
                }
                return false;
            });

            // Remove City Stats on Change
            txtStats.setText("");
        });
        
         // Set filter Predicate text is changed #TODO change trigger to button       
        txtfldAddress.textProperty().addListener((observable, oldValue, newValue) ->{
            filteredData.setPredicate(property-> {
                
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                
                // If filter text is empty display all properties
                String filterText = newValue.toLowerCase();
                
                // Compare Address to filter text
                if (property.getAddress().toString().toLowerCase().indexOf(filterText) != -1) {
                    return true;
                }
                return false;
            });
            
            // Remove City Stats on Change
            txtStats.setText("");
        });
        
        // Set filter Predicate text is changed #TODO change trigger to button
        txtfldNeighbourhood.textProperty().addListener((observable, oldValue, newValue) ->{
            filteredData.setPredicate(property-> {
                
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                
                // If filter text is empty display all properties
                String filterText = newValue.toLowerCase();
                
                // Compare Neighbourhood to filter text
                if (property.getNeigbourhood().toLowerCase().indexOf(filterText) != -1) {
                    return true;
                }
                else
                    return false; //No Matches
                
            });
            City activefCity = new City();    
            ArrayList<Property> filteredProperties = new ArrayList<Property>(filteredData);
            activefCity.buildCity(filteredProperties);

            // Displays City Stats on Change
            txtStats.setText(activefCity.displayStats());
        });
        
         cmbClass.valueProperty().addListener((observable, oldValue, newValue)-> {
            filteredData.setPredicate(property-> {
                
                if (newValue == null || newValue.isEmpty()|| newValue.equals("All")) {
                    return true;
                }
                
                // If filter text is empty display all properties
                String filterText = newValue.toLowerCase();
                
                // Compare Neighbourhood to filter text
                if (property.getAssessClass().toLowerCase().indexOf(filterText) != -1) {
                    return true;
                }
                else
                    return false; 
            });
            City activefCity = new City();    
            ArrayList<Property> filteredProperties = new ArrayList<Property>(filteredData);
            activefCity.buildCity(filteredProperties);

            // Displays City Stats on Change
            txtStats.setText(activefCity.displayStats());
        });

        
        SortedList<Property> sortedData = new SortedList<Property>(filteredData);
        sortedData.comparatorProperty().bind(propertyTable.comparatorProperty());        
        
        // Display Data
        propertyTable.setItems(sortedData);

        txtStats.setText(newCity.displayStats());
        
    }
    
}
