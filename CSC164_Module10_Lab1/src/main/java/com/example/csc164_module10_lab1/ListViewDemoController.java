package com.example.csc164_module10_lab1;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.util.Collections;

public class ListViewDemoController {
    private ArrayList<String> myList = new ArrayList<>();

    @FXML
    private TextField addToListTextField;

    @FXML
    private Button addtoListButton;

    @FXML
    private ListView<String> displayListView;

    @FXML
    private Label listName;

    @FXML
    private Button sortListButton;

    @FXML
    void initialize()
    {
        listName.setText("Name List");

        myList.add("Edgar");
        myList.add("Katelyn");
        myList.add("Lisa");
        myList.add("Alejandro");
        myList.add("Vicky");
        myList.add("Thomas");
        displayListView.setItems(FXCollections.observableArrayList(myList));
        System.out.println("hello");

        displayListView.setOnMouseClicked(event -> {
            String strItem = displayListView.getSelectionModel().getSelectedItem();
            System.out.println(strItem);
        });
    }

    @FXML
    void addtoListHandler(ActionEvent event) {
        String infoFromTextField = addToListTextField.getText();
        myList.add(infoFromTextField);
        displayListView.getItems().add(infoFromTextField);
    }

    @FXML
    void sortListHandler(ActionEvent event) {
        Collections.sort(myList);
        displayListView.getItems().clear();
        displayListView.setItems(FXCollections.observableArrayList(myList));
    }

}
