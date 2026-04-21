package com.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class MoveCircleController {


    @FXML
    private Circle myCircle;

    @FXML
    private Pane myPane;

    private double xStartValue = 100;
    private double yStartValue = 100;

    @FXML
    protected void initialize() {
        myCircle.setFocusTraversable(true);

        myCircle.setOnKeyPressed(KeyEvent ->{
            switch (KeyEvent.getCode())
            {
                case DOWN:
                    System.out.println("Down");
                    yStartValue = yStartValue + 30;
                    myCircle.setCenterY(yStartValue);
                    myCircle.setCenterX(xStartValue);
                    break;
                case UP:
                    System.out.println("Up");
                    yStartValue = yStartValue - 30;
                    myCircle.setCenterY(yStartValue);
                    myCircle.setCenterX(xStartValue);
                    break;
                case LEFT:
                    System.out.println("Left");
                    xStartValue = xStartValue - 30;
                    myCircle.setCenterX(xStartValue);
                    myCircle.setCenterY(yStartValue);
                    break;
                case RIGHT:
                    System.out.println("Right");
                    xStartValue = xStartValue + 30;
                    myCircle.setCenterX(xStartValue);
                    myCircle.setCenterY(yStartValue);
                    break;
                default: ;
            }
        });
    }
}