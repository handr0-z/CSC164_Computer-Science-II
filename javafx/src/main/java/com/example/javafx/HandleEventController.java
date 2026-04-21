package com.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HandleEventController {
    @FXML
    protected void onOKButtonClick() {
        System.out.println("OK Button Click");
    }

    @FXML
    protected void onCancelButtonClick() {
        System.out.println("Cancel Button Click");
    }
}