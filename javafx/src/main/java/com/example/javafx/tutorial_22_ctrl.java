package com.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class tutorial_22_ctrl
{
    @FXML MenuBar menuBar;

    @FXML
    private void initialize()
    {
        Menu fileMenu=new Menu("_File");

        MenuItem newFile=new MenuItem("New...");
        newFile.setOnAction(e -> System.out.println("Create a new file..."));
        fileMenu.getItems().add(newFile);

        fileMenu.getItems().add(new MenuItem("Open..."));
        fileMenu.getItems().add(new MenuItem("Save..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Settings..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Exit..."));

        Menu editMenu=new Menu("_Edit");
        editMenu.getItems().add(new MenuItem("Cut"));
        editMenu.getItems().add(new MenuItem("Copy"));

        MenuItem paste=new MenuItem("Paste");
        paste.setOnAction(e -> System.out.println("Pasting..."));
        //paste.setDisable(true);
        editMenu.getItems().add(paste);

        //MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu);
    }
}