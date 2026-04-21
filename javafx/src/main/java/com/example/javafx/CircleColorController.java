package com.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class CircleColorController {
    @FXML
    private boolean change;

    @FXML
    private Circle myCircle;

    @FXML
    protected void onMouseHold() {
        myCircle.setOnMousePressed(e ->{
            myCircle.setFill(Color.BLACK);
        });
    }

    @FXML
    protected void onMouseRelease() {
        myCircle.setOnMouseReleased(e ->{
            myCircle.setFill(Color.WHITE);
        });
    }
}