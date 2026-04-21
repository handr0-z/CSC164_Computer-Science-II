module com.example.csc164_module9_assignment1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.csc164_module9_assignment1 to javafx.fxml;
    exports com.example.csc164_module9_assignment1;
}