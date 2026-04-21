module com.example.csc164_module11_assignment1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.csc164_module11_assignment1 to javafx.fxml;
    exports com.example.csc164_module11_assignment1;
}