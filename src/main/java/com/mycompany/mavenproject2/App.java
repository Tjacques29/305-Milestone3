package com.mycompany.mavenproject2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Edmonton Property Assessment JavaFX Application
 * 
 * This is the main class that runs the Edmonton Property Assessment App for 
 * Milestone 2 of 305
 * 
 * @author Brittina Morgan
 * 
 * 
 * 
 * Field    Description
 * scene    Scene object to hold FXML propertyTable  
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("propertyTable"));
        stage.setTitle("Edmonton Property Assessments");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Sets the root of the scene displaying the passed fxml file
     * @param fxml the fxml filename 
     * @throws IOException 
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * This loads the fxml page
     * @param fxml the fxml filename
     * @return fxmlLoading loads the page
     * @throws IOException 
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * The main function that initiates the program
     * @param args 
     */
    public static void main(String[] args) {
        launch();
    }

}