module com.group2.eproject2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.group2.eproject2 to javafx.fxml;
    exports com.group2.eproject2;
}
