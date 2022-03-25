/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package milestone2;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author BEN
 */
public class AddDeleteFXMLController implements Initializable {
    @FXML private TextField addAccountNumberTextField;
    @FXML private TextField addneighbourhoodTextField;
    @FXML private TextField addHouseNumField;
    @FXML private TextField addStreetNumField;
    @FXML private TextField addAssessmentClassField;
    @FXML private TextField addLatField;
    @FXML private TextField addLongField;
    @FXML private TextField addAssessedValueField;
    private List<property> propertyArray;
    public void initData(List<property> array){
        propertyArray = new ArrayList();
    }
    /*
    purpose: change secene to add/ delete secene
    parametes
    return
    */
    public void mainSenceButton(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();loader.setLocation(getClass().getResource("FXML.fxml"));
        Parent mainParent = loader.load();
        FXMLController controller = loader.getController();
        controller.updatePropertyList(this.propertyArray);
        Scene mainScene = new Scene(mainParent);
        Stage window = (Stage)(((Node)event.getSource()).getScene().getWindow());
        window.setScene(mainScene);
        window.show();
    }
    /*
    purpose: to add a new protery
    parametes
    return none
    */
    public void addProperty() throws Exception{
        List<String> data = new ArrayList();
        data.add(addAccountNumberTextField.getText());data.add("suite");data.add(addHouseNumField.getText());data.add(addStreetNumField.getText());data.add("N");data.add("123");data.add(addneighbourhoodTextField.getText());
        data.add("ward");data.add(addAssessedValueField.getText());data.add(addLatField.getText());data.add(addLongField.getText());data.add("1234");data.add("12345");data.add("12346");data.add("1234567");
        data.add(addAssessmentClassField.getText().toUpperCase());data.add("2");data.add("2");
        System.out.println(data);
        //List<property> propertyArray = new ArrayList();
        propertyArray.add(new property(data));
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
