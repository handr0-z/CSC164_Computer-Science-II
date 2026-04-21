/*
 =====================================================================================================
 AUTHOR:        ALEJANDRO PANTOJA-ZURITA
 COLLEGE:       DELAWARE TECHNICAL COMMUNITY COLLEGE
 COURSE:        CSC 164: COMPUTER SCIENCE II
 INSTRUCTOR:    BRIAN JORGAGE
 DATE:          JULY 15, 2025
 PROJECT:       MODULE 11 - LAB 1: FILE INPUT
 NOTES:         THIS LAB IS FOCUSED ON CREATING A SIMPLE JAVA FX PROGRAM THAT TAKES INPUT FROM A FILE.

 ASIDE FROM THE STARTER CODE PROVIDED FOR THIS ASSIGNMENT, I WROTE ALL THE CODE SUBMITTED.
 OTHERWISE, I HAVE PROVIDED CITATIONS AND REFERENCES WHERE APPROPRIATE.
 =====================================================================================================
*/

package com.example.csc164_module11_lab1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FileInputDemo extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FileInputDemo.class.getResource("file-input-demo.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Hello World!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}