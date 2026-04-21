package com.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class MouseEventDemoController {
    @FXML
    private Text myText;

    @FXML
    protected void initialize() {
        myText.setOnMouseDragged(e ->{
            myText.setX(e.getX());
            myText.setY(e.getY());
        });
    }
}