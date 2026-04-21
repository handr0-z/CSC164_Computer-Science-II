package com.example.csc164_module9_lab1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Hello World - My name is Alejandro Pantoja-Zurita!");
    }
}