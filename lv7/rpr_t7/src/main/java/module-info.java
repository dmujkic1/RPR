module com.example.rpr_t7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rpr_t7 to javafx.fxml;
    exports com.example.rpr_t7;
}