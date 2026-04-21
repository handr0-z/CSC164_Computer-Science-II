package com.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

import java.awt.*;

public class CircleSizeController {
    @FXML
    private Circle myCircle;

    @FXML
    protected void onEnlargeButtonClick() { myCircle.setRadius(myCircle.getRadius() + 2 );}

    @FXML
    protected void onShrinkButtonClick() { myCircle.setRadius( myCircle.getRadius() - 2);}
}