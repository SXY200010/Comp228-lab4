module com.example.comp228lab4 {
    requires javafx.controls;
    requires javafx.fxml;


//    opens com.example.comp228lab4 to javafx.fxml;
//    exports com.example.comp228lab4;

    opens lab4 to javafx.fxml;
    exports lab4;
}