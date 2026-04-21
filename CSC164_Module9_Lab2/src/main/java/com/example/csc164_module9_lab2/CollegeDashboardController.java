package com.example.csc164_module9_lab2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CollegeDashboardController {
    @FXML
    private TableView<Announcements> collegewideAnnouncements;

    @FXML
    private TableColumn<Announcements, String> collegeDate;

    @FXML
    private TableColumn<Announcements, String> collegeFrom;

    @FXML
    private TableColumn<Announcements, String> collegeTitle;

    @FXML
    private TableView<Announcements> presidentAnnouncements;

    @FXML
    private TableColumn<Announcements, String> officeDate;

    @FXML
    private TableColumn<Announcements, String> officeFrom;

    @FXML
    private TableColumn<Announcements, String> officeTitle;

    ObservableList<Announcements> presidentList() {
        Announcements president = new Announcements("07/05/25", "There are currently no announcements", "System");
        return FXCollections.<Announcements> observableArrayList(president);
    }

    ObservableList<Announcements> collegeList() {
        Announcements college = new Announcements("06/10/25", "Allied Health Competitive Admissions Applications Have Been Extended!", "Instruction");
        return FXCollections.<Announcements> observableArrayList(college);
    }

    @FXML
    public void initialize() {
        // Learned how to properly set up tableview from video: https://www.youtube.com/watch?v=GNsBTP2ZXrU&ab_channel=KensoftPH

        officeDate.setCellValueFactory(new PropertyValueFactory<Announcements, String>("Date"));
        officeTitle.setCellValueFactory(new PropertyValueFactory<Announcements, String>("Title"));
        officeFrom.setCellValueFactory(new PropertyValueFactory<Announcements, String>("From"));

        collegeDate.setCellValueFactory(new PropertyValueFactory<Announcements, String>("Date"));
        collegeTitle.setCellValueFactory(new PropertyValueFactory<Announcements, String>("Title"));
        collegeFrom.setCellValueFactory(new PropertyValueFactory<Announcements, String>("From"));

        // Learned how to adjust the amount of columns in table view from video: https://www.youtube.com/watch?v=vego72w5kPU&ab_channel=JavaCodeJunkie
        presidentAnnouncements.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        collegewideAnnouncements.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        presidentAnnouncements.setItems(presidentList());
        collegewideAnnouncements.setItems(collegeList());
    }


}