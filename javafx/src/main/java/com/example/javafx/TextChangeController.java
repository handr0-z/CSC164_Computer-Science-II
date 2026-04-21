package com.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class TextChangeController {
    @FXML
    private Text myText;

    @FXML
    private boolean change;

    @FXML
    protected void setMyText() {
        if (change)
        {
            myText.setOnMouseClicked(e ->{
                myText.setText("Java is Fun!");
            });
            change = false;
        }
        else {
            myText.setOnMouseClicked(e -> {
                myText.setText("Java is Powerful!");
            });
            change = true;
        }
    }
}