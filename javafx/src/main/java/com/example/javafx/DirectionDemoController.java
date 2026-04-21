package com.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class DirectionDemoController {


    @FXML
    private Line myLine;

    @FXML
    private Pane myPane;
    private String keyInput;

    private double xStartValue = 100;
    private double yStartValue = 100;
    Color paint = new Color(0.0799, 0.3097, 0.5395, 1.0);

    @FXML
    protected void initialize() {
        myLine.setFocusTraversable(true);

        myLine.setOnKeyPressed(KeyEvent ->{
            switch (KeyEvent.getCode())
            {
                case DOWN:
                    System.out.println("Down");
                    myLine = new Line(xStartValue, yStartValue, xStartValue, yStartValue+30);
                    myLine.setStroke(paint);
                    yStartValue = yStartValue + 30;
                    break;
                case UP:
                    System.out.println("Up");
                    myLine = new Line(xStartValue, yStartValue, xStartValue, yStartValue-30);
                    myLine.setStroke(paint);
                    yStartValue = yStartValue - 30;
                    break;
                case LEFT:
                    System.out.println("Left");
                    myLine = new Line(xStartValue, yStartValue, xStartValue-30, yStartValue);
                    myLine.setStroke(paint);
                    xStartValue = xStartValue - 30;
                    break;
                case RIGHT:
                    System.out.println("Right");
                    myLine = new Line(xStartValue, yStartValue, xStartValue+30, yStartValue);
                    myLine.setStroke(paint);
                    xStartValue = xStartValue + 30;
                    break;
                default: ;
            }
            myPane.getChildren().add(myLine);
        });
    }
}