package com.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {
    @FXML
    private Button addButton;

    @FXML
    private Button divideButton;

    @FXML
    private Button multiplyButton;

    @FXML
    private Button subtractButton;

    @FXML
    private TextField result;

    @FXML
    private TextField number1;

    @FXML
    private TextField number2;

    @FXML
    private double num1 = 12;

    @FXML
    private double num2 = 3;

    @FXML
    private double endResult;

    @FXML
    protected void onAddButtonClick() {
        num1 = Double.parseDouble(number1.getText());
        num2 = Double.parseDouble(number2.getText());
        endResult = num1 + num2;
        result.setText(String.valueOf(endResult));
    }

    @FXML
    protected void onSubtractButtonClick() {
        num1 = Double.parseDouble(number1.getText());
        num2 = Double.parseDouble(number2.getText());
        endResult = num1 - num2;
        result.setText(String.valueOf(endResult));
    }

    @FXML
    protected void onMultiplyButtonClick() {
        num1 = Double.parseDouble(number1.getText());
        num2 = Double.parseDouble(number2.getText());
        endResult = num1 * num2;
        result.setText(String.valueOf(endResult));
    }

    @FXML
    protected void onDivideButtonClick() {
        num1 = Double.parseDouble(number1.getText());
        num2 = Double.parseDouble(number2.getText());
        endResult = num1 / num2;
        result.setText(String.valueOf(endResult));
    }
}