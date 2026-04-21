package com.example.javafx;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ShowAnimationcolorController {

    public int RedValue = 0;
    public int GreenValue = 0;
    public int BlueValue = 0;

    @FXML
    private TextField blueValueField;

    @FXML
    private Circle circle;

    @FXML
    private Button enterButton;

    @FXML
    private TextField greenValueField;

    @FXML
    private TextField redValueField;

    @FXML
    void clickEnterButton(ActionEvent event) {
        RedValue = Integer.parseInt(redValueField.getText());
        GreenValue = Integer.parseInt(greenValueField.getText());
        BlueValue = Integer.parseInt(blueValueField.getText());

        Color color1  = Color.rgb(RedValue, GreenValue, BlueValue);

        circle.setFill(color1);
    }

    public void start(Stage primaryStage) {

        Color color1  = Color.rgb(RedValue, GreenValue, BlueValue);

        circle = new Circle(50, 150, 50, color1);

        // change circle.translateXProperty from it's current value to 200
        KeyValue keyValue = new KeyValue(circle.translateXProperty(), 200);

        // over the course of 5 seconds
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(10), keyValue);
        Timeline timeline = new Timeline(keyFrame);

        Scene scene = new Scene(new Pane(circle), 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

        timeline.play();
    }

}

