module com.example.rpr_t6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rpr_t6 to javafx.fxml;
    exports com.example.rpr_t6;
}