module com.example.csc164_module9_lab2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.csc164_module9_lab2 to javafx.fxml;
    exports com.example.csc164_module9_lab2;
}