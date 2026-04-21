package com.example.javafx;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ComboBoxDemoController {

    private ArrayList<String> myList = new ArrayList<>();

    @FXML
    private ComboBox<String> comboButton;

    @FXML
    private Button enterButton;

    @FXML
    void onEnterButtonClick(ActionEvent event) {
        myList.add(comboButton.getValue());
        comboButton.setItems((ObservableList<String>) myList);
    }

    @FXML
    void initialize()
    {
        myList.add("Pizza");
        myList.add("Coke");
        myList.add("Sandwich");

        comboButton.setItems((ObservableList<String>) myList);
    }
}


