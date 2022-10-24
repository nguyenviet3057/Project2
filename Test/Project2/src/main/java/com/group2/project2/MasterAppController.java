package com.group2.project2;

import com.group2.project2.entities.staffEntity;
import com.group2.project2.entities.studentsEntity;
import com.group2.project2.model.staff;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Iterator;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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
    private ImageView img_app;
    
    @FXML
    private Label lbl_header;

    @FXML
    private Label lbl_version;

    @FXML
    private Pane pan_left;
    
    @FXML
    private Pane pan_form;
    
    @FXML
    private TextField tf_usr;
    
    @FXML
    private TextField tf_pwd;

    @FXML
    private Button btn_login;

    @FXML
    private Button btn_forgot;
    
    @FXML
    private Label lbl_error;
    
    private short isLogin = 0;
    
    public static String usr;
    
    public static int id;
    
    public static LocalDateTime DATETIME = LocalDateTime.of(2022, Month.OCTOBER, 03, 07, 45, 10);  

    @FXML
    void changeError() throws IOException {
        lbl_error.setVisible(false);
    }
    
    void resetBtnBackground() {
        Set<Node> nodes = pan_left.lookupAll(".button");
        for (Iterator<Node> iterator = nodes.iterator(); iterator.hasNext();) {
            Node next = iterator.next();
            next.setStyle("-fx-border-style: hidden solid hidden hidden; -fx-border-color: lightgray; -fx-border-width: 2px; -fx-background-color: white; -fx-cursor: hand");
        }
    }
    
    @FXML
    void enableStudentLogin() throws IOException {
        resetBtnBackground();
        btn_studentApp.setStyle("-fx-background-color: #f0f0f0; -fx-cursor: hand; -fx-border: none");
        String url = "file:images/student.png";
        Image img = new Image(url);
        img_app.setImage(img);
        isLogin = 1;
        pan_form.setVisible(true);
        lbl_error.setVisible(false);
        tf_usr.setText("an.dv0001@gmail.com");
        tf_pwd.setText("passandv0001");
    }
    @FXML
    void enableTeacherLogin() throws IOException {
        resetBtnBackground();
        btn_teacherApp.setStyle("-fx-background-color: #f0f0f0; -fx-cursor: hand; -fx-border: none");
        String url = "file:images/teacher.png";
        Image img = new Image(url);
        img_app.setImage(img);
        isLogin = 2;
        pan_form.setVisible(true);
        lbl_error.setVisible(false);
        tf_usr.setText("hung.nv.00@gmail.com");
        tf_pwd.setText("hungnv00");
    }
    @FXML
    void enableStaffLogin() throws IOException {
        resetBtnBackground();
        btn_staffApp.setStyle("-fx-background-color: #f0f0f0; -fx-cursor: hand; -fx-border: none");
        String url = "file:images/staff.png";
        Image img = new Image(url);
        img_app.setImage(img);
        isLogin = 3;
        pan_form.setVisible(true);
        lbl_error.setVisible(false);
        tf_usr.setText("mai.lh.08@gmail.com");
        tf_pwd.setText("mailh08");
    }
    
    @FXML
    void validateLogin() throws IOException {
        switch (isLogin) {
            case 1:
                usr = studentsEntity.findByEmail_Password(tf_usr.getText(), tf_pwd.getText());
                if (usr == null) {
                    lbl_error.setText("Wrong username or password!");
                    lbl_error.setVisible(true);
                } else {
                    App.setRoot("StudentApp");
                }
                break;
            case 2:
                staff teacher = staffEntity.findByEmail_Password(tf_usr.getText(), tf_pwd.getText());
                if (teacher == null || teacher.getPermission_id() != 2) {
                    lbl_error.setText("Wrong username or password!");
                    lbl_error.setVisible(true);
                } else {
                    TeacherController.id = teacher.getId();
                    App.setRoot("TeacherApp");
                }
                break;
            case 3:
                staff sta = staffEntity.findByEmail_Password(tf_usr.getText(), tf_pwd.getText());
                if (sta == null || (sta.getPermission_id() != 1 && sta.getPermission_id() != 3)) {
                    lbl_error.setText("Wrong username or password!");
                    lbl_error.setVisible(true);
                } else {
                    StaffController.id = sta.getId();
                    App.setRoot("StaffApp");
                }
                break;
        }
    }

}
