package com.example.javafx;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class tutorial_21_ctrl
{
    @FXML MenuBar menuBar;

    @FXML
    private void initialize()
    {
        Menu fileMenu=new Menu("File");
        fileMenu.getItems().add(new MenuItem("New Project..."));
        fileMenu.getItems().add(new MenuItem("New Module..."));
        fileMenu.getItems().add(new MenuItem("Import Project..."));

        menuBar.getMenus().addAll(fileMenu);
    }
}