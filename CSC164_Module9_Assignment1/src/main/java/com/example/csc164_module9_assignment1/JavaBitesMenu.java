/*
 =====================================================================================================
 AUTHOR:        ALEJANDRO PANTOJA-ZURITA
 COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
 COURSE:        CSC 164: COMPUTER SCIENCE II
 INSTRUCTOR:    BRIAN JORGAGE
 DATE:          JULY 6 , 2025
 PROJECT:       MODULE 9 - ASSIGNMENT 1: RESTAURANT MENU
 NOTES:         IMPLEMENT THE RESTAURANT MENU INTO JAVA FX FOR VISUAL DISPLAY.

 ASIDE FROM THE STARTER CODE PROVIDED FOR THIS ASSIGNMENT, I WROTE ALL THE CODE SUBMITTED.
 OTHERWISE, I HAVE PROVIDED CITATIONS AND REFERENCES WHERE APPROPRIATE.
 =====================================================================================================
*/

package com.example.csc164_module9_assignment1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JavaBitesMenu extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(JavaBitesMenu.class.getResource("java-bites-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 1200);
        stage.setTitle("Java Bites Menu");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}