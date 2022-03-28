/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package milestone3;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 *
 * @authors Brittina Morgan
 */
public class ScatterChartFXMLController implements Initializable {
    
    @FXML ScatterChart scatterChart;
    @FXML Label lblScatterPlot;
    @FXML Label lblXAxis;
    @FXML Label lblYAxis;
    @FXML Label lblYear;
    @FXML ComboBox cmbX;
    @FXML ComboBox cmbYear;
    @FXML Button btnShow;
    @FXML Button btmHome;

    private List<property> assessmentData;
    
    // observable lists to store data 
    private final ObservableList<String> cmbListX = FXCollections.observableArrayList(
            "Assessment Class", "Neighbourhood", "Year Built", "Lot Size");
    private final ObservableList<String> cmbListYear = FXCollections.observableArrayList(
            "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021");

    /**
     * Gets array of data 
     * @param array array of properties
     */
    public void initData(List<property> array){
        assessmentData = array;
    }

    /**
     *  Changes scene back to main scene
     * @param event
     * @throws IOException 
     */
    public void pressHomeButton(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();loader.setLocation(getClass().getResource("FXML.fxml"));
        Parent mainParent = loader.load();
        Scene mainScene = new Scene(mainParent);
        Stage window = (Stage)(((Node)event.getSource()).getScene().getWindow());
        window.setScene(mainScene);
        window.show();
    }
    
    /*
    public void assessmentClassButton(){
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        List<Integer> CountAssessment = search.pieChartAssessmentClassPlusNeighbourhoodSearch(this.assessmentData,neighbourhoodTextField.getText());
        pieChartData.add(new PieChart.Data("Residential",CountAssessment.get(0)));
        pieChartData.add(new PieChart.Data("Commercial",CountAssessment.get(1)));
        pieChartData.add(new PieChart.Data("Other Residential",CountAssessment.get(2)));
        pieChartData.add(new PieChart.Data("FarmLand",CountAssessment.get(3)));
        pieChart.setData(pieChartData);pieChart.setTitle(neighbourhoodTextField.getText().substring(0,1).toUpperCase() + neighbourhoodTextField.getText().substring(1).toLowerCase()+" distribution of assessment classes");
    }
    
    */
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // setup combo boxes
        cmbX.setItems(cmbListX);
        cmbYear.setItems(cmbListYear);
        
    }    
    
}