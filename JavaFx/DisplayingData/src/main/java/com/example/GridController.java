package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GridController {

    /*TODO 29: Paste the @FXML annotations from gridscene.fxml */
    @FXML
    private Label nameLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Label zipcodeLabel;

    @FXML
    private Button prevButton;

    @FXML
    private Button nextButton;

    @FXML
    private Button switchGridSceneButton;

    private List<String[]> personData;  // List to store fetched records
    private int currentIndex = 0;

    /** TODO 30: Copy the code of fetchPersonData(), displayRecord(), initialize() and 
     nextRecord() methods from VBoxController.java**/

    private List<String[]> fetchPersonData() {
        // TODO 16: Construct a SQL query string SQL Query 
        // to select name, city, zipcode from person
        // TODO 17: store name, city and zipcode in string variables 
        // with resultSet.getString() method

        List<String[]> data = new ArrayList<>();
        String query = "SELECT Name, City, Zipcode FROM person";

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                String city = resultSet.getString("City");
                String zipcode = resultSet.getString("Zipcode");
                data.add(new String[]{name, city, zipcode});
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    private void displayRecord(int index) {
        // TODO 19: fetch information of person at current index 
        // from personData arraylist. Set nameLabel to the name field
        // TODO 20: similarly set cityLabel and zipcodeLabel

        if (index >= 0 && index < personData.size()) {
            String[] person = personData.get(index);
            nameLabel.setText("Name: " + person[0]);
            cityLabel.setText("City: " + person[1]);
            zipcodeLabel.setText("Zipcode: " + person[2]);
        }
    }

    @FXML
    public void initialize() {
        // TODO 22: inside this method, call the fetchPersonData() method first
        // TODO 23: call the displayRecord() method to show the contents of the person data at the currentIndex in the application window.

        personData = fetchPersonData();
        if (!personData.isEmpty()) {
            displayRecord(currentIndex);
        }
    }

    @FXML
    void nextRecord(ActionEvent event) {
        // TODO 24: inside this method, increment currentIndex and call displayRecord() method.

        if (currentIndex < personData.size() - 1) {
            currentIndex++;
            displayRecord(currentIndex);
        }
    }

    @FXML
    void prevRecord(ActionEvent event) {
        // TODO 25: Inside this method, decrement currentIndex and call displayRecord() method.
    }

    @FXML
    void switchVScene(ActionEvent event) throws IOException {
        // TODO 31: set the vboxscene.fxml as the root of application window
        Parent root = FXMLLoader.load(getClass().getResource("vboxscene.fxml"));
        Scene scene = ((Button) event.getSource()).getScene();
        scene.setRoot(root);
    }
}
