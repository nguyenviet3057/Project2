package com.group2.project2;

import com.group2.project2.entities.studentsEntity;
import com.group2.project2.model.students;
import java.net.URL;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;

public class EditStudentController implements Initializable{

    @FXML
    private Button btn_changepwd;

    @FXML
    private Button btn_reset;

    @FXML
    private Button btn_save;

    @FXML
    private ComboBox<String> cb_gender;

    @FXML
    private DatePicker dpk_dob;

    @FXML
    private TextField tf_address;

    @FXML
    private TextField tf_cfpwd;

    @FXML
    private TextField tf_email;

    @FXML
    private TextField tf_fullname;

    @FXML
    private TextField tf_newpwd;

    @FXML
    private TextField tf_oldpwd;
    
    @FXML
    private Label lbl_invalid;

    private boolean isChangePwd = false;

    public void reset() {
        //add gender
        tf_fullname.setText(StudentController.stdInstance().getFullname());
        cb_gender.setValue(StudentController.stdInstance().getGender());
        dpk_dob.setValue(StudentController.stdInstance().getBirthday().toLocalDate());
        tf_email.setText(StudentController.stdInstance().getEmail());
        tf_address.setText(StudentController.stdInstance().getAddress());
//        tf_oldpwd.setText(StudentController.stdInstance().getPassword());
        isChangePwd = false;
        btn_changepwd.setVisible(true);
        tf_oldpwd.setText("");
        tf_oldpwd.setDisable(true);
        tf_newpwd.setVisible(false);
        tf_cfpwd.setVisible(false);
        lbl_invalid.setVisible(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> options = 
            FXCollections.observableArrayList(
                "male",
                "female"
            );
        cb_gender.setItems(options);
        reset();
    }
    
    public void changePwd() {
        isChangePwd = true;
        btn_changepwd.setVisible(false);
        tf_oldpwd.setDisable(false);
        tf_newpwd.setVisible(true);
        tf_cfpwd.setVisible(true);
    }
    
    public void save() {
        if (!isChangePwd) {
            students std = StudentController.stdInstance();
            std.setFullname(tf_fullname.getText());
            std.setGender(cb_gender.getValue());
            std.setBirthday(Date.valueOf(dpk_dob.getValue()));
            std.setAddress(tf_address.getText());
            studentsEntity.update(std);
            lbl_invalid.setTextFill(Paint.valueOf("green"));
            lbl_invalid.setText("Save successfully! Please restart this application!!!");
            lbl_invalid.setVisible(true);
        } else {
            if (tf_oldpwd.getText().compareTo(StudentController.stdInstance().getPassword()) == 0) {
                if (tf_newpwd.getText().compareTo(tf_cfpwd.getText()) == 0) {
                    students std = StudentController.stdInstance();
                    std.setFullname(tf_fullname.getText());
                    std.setGender(cb_gender.getValue());
                    std.setBirthday(Date.valueOf(dpk_dob.getValue()));
                    std.setAddress(tf_address.getText());
                    std.setPassword(tf_newpwd.getText());
                    studentsEntity.update(std);
                    lbl_invalid.setTextFill(Paint.valueOf("green"));
                    lbl_invalid.setText("Save successfully! Please restart this application!!!");
                    lbl_invalid.setVisible(true);
                } else {
                    lbl_invalid.setTextFill(Paint.valueOf("red"));
                    lbl_invalid.setText("Incorrect confirm password!");
                    lbl_invalid.setVisible(true);
                }
            } else {
                lbl_invalid.setTextFill(Paint.valueOf("red"));
                lbl_invalid.setText("Incorrect old password!");
                lbl_invalid.setVisible(true);
            }
        }
    }
}
