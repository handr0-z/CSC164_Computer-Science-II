package com.example.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.util.ArrayList;

public class ChoiceboxDemoController {

    private String choice1 = "Pizza";
    private String choice2 = "Cheeseburger";
    private String choice3 = "Wings";
    private String choice4 = "Sub";
    private String choice5 = "Hot Dog";

    @FXML
    private ChoiceBox<String> choiceBox1;

    @FXML
    private Button orderButton;

    @FXML
    void onOrderButtonClick(ActionEvent event) {
        System.out.println("Items Ordered");
        System.out.println(choiceBox1.getValue() + "\n");
    }

    @FXML
    void initialize()
    {
        choiceBox1.getItems().add(choice1);
        choiceBox1.getItems().add(choice2);
        choiceBox1.getItems().add(choice3);
        choiceBox1.getItems().add(choice4);
        choiceBox1.getItems().add(choice5);

    }
}
