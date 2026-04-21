package com.example.javafx;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import java.util.ArrayList;

public class CheckboxDemoController {

    private String item1 = "Pizza";
    private String item2 = "Salad";
    private ArrayList<String> order = new ArrayList<>();

    @FXML
    private CheckBox checkBox1;

    @FXML
    private CheckBox checkBox2;

    @FXML
    private Button orderButton;

    @FXML
    void onCheckBox1Click(ActionEvent event) {
        order.add(item1);
    }

    @FXML
    void onCheckBox2Click(ActionEvent event) {
        order.add(item2);
    }

    @FXML
    void onOrderButtonClick(ActionEvent event) {
        System.out.println("Items Ordered");
        for (int i=0; i < order.size(); i++)
        {
            System.out.println( (i+1) + ") " + order.get(i));
        }
        order.clear();
    }

    @FXML
    void initialize()
    {
        checkBox1.setText(item1);
        checkBox2.setText(item2);
    }

}
