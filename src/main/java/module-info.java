module java_dict {
    requires javafx.controls;
    requires javafx.fxml;

    opens java_dict to javafx.fxml;
    exports java_dict;
}
