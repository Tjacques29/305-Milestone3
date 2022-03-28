/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package milestone3;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 * Purpose to set up function that are used by the scene 
 * @authors Ben
 *          Brittina Morgan
 */
public final class FXMLController implements Initializable {
    private ObservableList<property> properties;
    private final String name = "Property_Assessment_Data_Historical.CSV";
    @FXML private TableView<property> tableView;
    @FXML private TableColumn<property, Integer>account;
    @FXML private TableColumn<property, String>address;
    @FXML private TableColumn<property, String>assessedValue;
    @FXML private TableColumn<property, String>assessmentClass;
    @FXML private TableColumn<property, String>neighbourhood;
    @FXML private TableColumn<property, Float>latitude;
    @FXML private TableColumn<property, Float>longitude;
    @FXML private TableColumn<property, Integer>colYearAss;
    //for property search
    @FXML private ComboBox assessmentClassComboBox;
    @FXML private TextArea propertyTextArea;
    @FXML private TextField accountNumberTextField;
    @FXML private TextField neighbourhoodTextField;
    @FXML private TextField addressTextField;

    /*
    purpose: to initalize properties ObservableList with the data using getproperty() this is so it does not have 
    to rescan all of the data everytime porpertyAssessments() changes
    parameters: none
    return: none
    */
    public FXMLController() throws Exception {
        this.properties = getproperty();
    }
    /*
    purpose: to update textarea when something is entered
    parameters:none
    return: none
    */
    public void porpertyAssessments() throws Exception{
        boolean isMyComboBoxEmpty = assessmentClassComboBox.getSelectionModel().isEmpty();
        boolean isNeighbourhoodTextFieldTextFieldEmpty = neighbourhoodTextField.getText().trim().isEmpty();
        boolean isMyAccountNumberTextFieldEmpty = accountNumberTextField.getText().trim().isEmpty();
        boolean isMyAddressTextFieldTextFieldEmpty = addressTextField.getText().trim().isEmpty();
        
        if((this.properties.size())>1){
            if (isMyAccountNumberTextFieldEmpty ==false ) {
                this.propertyTextArea.setText(search.accountNumberSearch(accountNumberTextField.getText(),this.properties));
                setPropertyTable(search.accountNumberPropertyFinder(accountNumberTextField.getText(),this.properties));
            }
            else if (isNeighbourhoodTextFieldTextFieldEmpty ==false ) {
                String neighbourhoodName = neighbourhoodTextField.getText().toLowerCase();
                if(isMyComboBoxEmpty==false){
                    List<Double> neighbourhoodDataList = search.neighbourhoodPlusAssessmentClass(neighbourhoodTextField.getText(),assessmentClassComboBox.getValue().toString(),this.properties);
                    setPropertyTable(search.neighbourhoodPlusAssessmentClassPropertyFinder(neighbourhoodTextField.getText(),assessmentClassComboBox.getValue().toString(),this.properties));
                    this.propertyTextArea.setText("""
                                                  Assessment Class:
                                                  """+assessmentClassComboBox.getValue().toString()+"\nNeighbourhood Name: "+neighbourhoodName.substring(0,1).toUpperCase() + neighbourhoodName.substring(1)+"\n"+stats.test(neighbourhoodDataList));
                }
                else{
                    List<Double> neighbourhoodDataList = search.neighbourhoodDataFinder(neighbourhoodTextField.getText(),this.properties);
                    setPropertyTable(search.neighbourhoodDataPropertyFinder(neighbourhoodTextField.getText(),this.properties));
                    this.propertyTextArea.setText("Neighbourhood Name: "+neighbourhoodName.substring(0,1).toUpperCase() + neighbourhoodName.substring(1)+"\n"+stats.test(neighbourhoodDataList));
                }

            }
            else if (isMyAddressTextFieldTextFieldEmpty ==false ) {
                this.propertyTextArea.setText(search.addressSearch(addressTextField.getText(),this.properties));
                setPropertyTable(search.addressPropertyFinder(addressTextField.getText(),this.properties));
            }
            else if(isMyComboBoxEmpty==false){
                List<Double> assessmentClassArray = search.assessmentData(assessmentClassComboBox.getValue().toString(),this.properties);
                setPropertyTable(search.assessmentDataPropertyFinder(assessmentClassComboBox.getValue().toString(),this.properties));
                this.propertyTextArea.setText("""
                                              Assessment Class:
                                              """+(assessmentClassComboBox.getValue().toString())+"\n"+stats.test(assessmentClassArray));
                }
            else{
                List<Double> allDataClass = search.allData(this.properties);
                setPropertyTable(this.properties);
                this.propertyTextArea.setText("""
                                              All data search
                                              """+stats.test(allDataClass));
            }
        }
        accountNumberTextField.clear();
        neighbourhoodTextField.clear();
        addressTextField.clear();
        
    }
    public void reset(){
        this.propertyTextArea.setText("");
        assessmentClassComboBox.getSelectionModel().clearSelection();
        accountNumberTextField.clear();
        neighbourhoodTextField.clear();
        addressTextField.clear();
        try {
            // loads data
            tableView.setItems(this.properties);
        } catch (Exception ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    purpose: change secene to add/ delete secene
    parametes
    return
    */
    public void addDeleteSenceButton(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();loader.setLocation(getClass().getResource("addDeleteFXML.fxml"));
        Parent AddDeleteParent = loader.load();
        AddDeleteFXMLController controller = loader.getController();
        controller.initData(this.properties);
        Scene AddDeleteScene = new Scene(AddDeleteParent);
        Stage window = (Stage)(((Node)event.getSource()).getScene().getWindow());
        window.setScene(AddDeleteScene);
        window.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assessmentClassComboBox.getItems().addAll("Residential","Commercial","Other Residential","FARMLAND");
        // sets up the columns
        account.setCellValueFactory(new PropertyValueFactory<property, Integer>("accountNum"));
        address.setCellValueFactory(new PropertyValueFactory<property, String>("address"));
        assessedValue.setCellValueFactory(new PropertyValueFactory<property, String>("assessedValue"));
        assessmentClass.setCellValueFactory(new PropertyValueFactory<property, String>("assessmentClass1"));
        neighbourhood.setCellValueFactory(new PropertyValueFactory<property, String>("neightbourhood"));
        latitude.setCellValueFactory(new PropertyValueFactory<property, Float>("Latitude"));
        longitude.setCellValueFactory(new PropertyValueFactory<property, Float>("longitude"));
        colYearAss.setCellValueFactory(new PropertyValueFactory<property, Integer>("builtYear"));
        try {
            // loads data
            tableView.setItems(this.properties);
        } catch (Exception ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
    }   
    /*
    purpose get the data from property class
    paramets: none
    return: list of properties
    */
    public ObservableList<property> getproperty() throws Exception{
        ObservableList<property> propertiesArray = FXCollections.observableArrayList();
        List<property> data;
        data = readCSV.allData(name);
        propertiesArray.addAll(data);
        return propertiesArray;
        
    }
    /*
    purpose get the set table as current seatch
    paramets: the list of properties from the list
    return: none
    */
    public void setPropertyTable(List<property> properties) throws Exception{
        try {
            ObservableList<property> propertiesArray = FXCollections.observableArrayList();
            propertiesArray.addAll(properties);
            tableView.setItems(propertiesArray);
        } catch (Exception ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    public void updatePropertyList(List<property> propertiesArray){
        this.properties.addAll(propertiesArray);
    }
    
    /*
    purpose: change secene to add/ delete secene
    parametes
    return
    */
    public void pieChartButton(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();loader.setLocation(getClass().getResource("pieChartFXML.fxml"));
        Parent pieChartParent = loader.load();
        PieChartFXMLController controller = loader.getController();
        controller.initData(this.properties);
        Scene pieChartScene = new Scene(pieChartParent);
        Stage window = (Stage)(((Node)event.getSource()).getScene().getWindow());
        window.setScene(pieChartScene);
        window.show();
    }
    
    /**
     * 
     * @param event
     * @throws IOException 
     */
    public void scatterChartButton(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();loader.setLocation(getClass().getResource("scatterChartFXML.fxml"));
        Parent scatterChartParent = loader.load();
        ScatterChartFXMLController controller = loader.getController();
        controller.initData(this.properties);
        Scene pieChartScene = new Scene(scatterChartParent);
        Stage window = (Stage)(((Node)event.getSource()).getScene().getWindow());
        window.setScene(pieChartScene);
        window.show();
    }
    
}
