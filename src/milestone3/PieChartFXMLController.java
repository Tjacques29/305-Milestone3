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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**PURPOSE TO MAKE A PIECHART
 * FXML Controller class
 *
 * @authors Ben
 *          Brittina Morgan 
 */
public class PieChartFXMLController implements Initializable {
    @FXML PieChart pieChart;
    private List<property> assessmentData;
    @FXML private TextField neighbourhoodTextField;
    
    
    /*
    purpose to get the array of data to 
    parametes the array of properties
    return none
    */
    public void initData(List<property> array){
        assessmentData = array;
    }
    /*
    purpose: change secene to main secene
    parametes
    return
    */
    public void mainSenceButton(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();loader.setLocation(getClass().getResource("FXML.fxml"));
        Parent mainParent = loader.load();
        Scene mainScene = new Scene(mainParent);
        Stage window = (Stage)(((Node)event.getSource()).getScene().getWindow());
        window.setScene(mainScene);
        window.show();
    }
    public void assessmentClassButton(){
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        List<Integer> CountAssessment = search.pieChartAssessmentClassPlusNeighbourhoodSearch(this.assessmentData,neighbourhoodTextField.getText());
        pieChartData.add(new PieChart.Data("Residential",CountAssessment.get(0)));
        pieChartData.add(new PieChart.Data("Commercial",CountAssessment.get(1)));
        pieChartData.add(new PieChart.Data("Other Residential",CountAssessment.get(2)));
        pieChartData.add(new PieChart.Data("FarmLand",CountAssessment.get(3)));
        pieChart.setData(pieChartData);pieChart.setTitle(neighbourhoodTextField.getText().substring(0,1).toUpperCase() + neighbourhoodTextField.getText().substring(1).toLowerCase()+" distribution of assessment classes");
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}