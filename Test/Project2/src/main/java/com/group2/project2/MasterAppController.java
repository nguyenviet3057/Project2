package com.group2.project2;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class MasterAppController {

    @FXML
    private Button btn_staffApp;

    @FXML
    private Button btn_studentApp;

    @FXML
    private Button btn_teacherApp;

    @FXML
    private GridPane container;

    @FXML
    private ImageView img_header;

    @FXML
    private Label lbl_header;

    @FXML
    private Label lbl_version;

    @FXML
    private Pane pan_left;

    @FXML
    void switchToStaffApp() throws IOException {
        App.setRoot("StaffApp");
    }

    @FXML
    void switchToStudentApp() throws IOException {
        App.setRoot("StudentApp");
    }

    @FXML
    void switchToTeacherApp() throws IOException {
        App.setRoot("TeacherApp");
    }

}
