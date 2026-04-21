package com.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;

public class RotateRectangleController {
    @FXML
    private Rectangle myRectangle;

    @FXML
    protected void onRotateButtonClick() { myRectangle.setRotate(myRectangle.getRotate()+15);}
}