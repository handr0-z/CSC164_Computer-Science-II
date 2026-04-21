package com.example.csc164_module11_lab1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

public class FileInputDemoController {
    private String fileName = "Hello World.txt";
    private String message;

    @FXML
    private Button helloButton;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText(message);
    }

    @FXML
    private void initialize() throws FileNotFoundException {
        // Create file and add text to file.
        try {
            PrintWriter writeFile = new PrintWriter(fileName);
            writeFile.println("Hello World - My name is Alejandro Pantoja-Zurita!");
            writeFile.close();
            System.out.println("File Created successfully.");

            // Obtain text from file created above.
            File readFile = new File(fileName);
            Scanner scanner = new Scanner(readFile);

            while (scanner.hasNextLine()) {message = scanner.nextLine();}
            System.out.println(message);
            scanner.close();
        }
        catch (FileNotFoundException e) {System.out.println("Error! Unable to create or read file.");}
    };
}
