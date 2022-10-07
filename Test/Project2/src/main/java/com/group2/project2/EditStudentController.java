package com.group2.project2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditStudentController implements Initializable{

    @FXML
    private Button btn_back;

    @FXML
    private Button btn_reset;

    @FXML
    private Button btn_save;

    @FXML
    private TextField tf_address;

    @FXML
    private TextField tf_dob;

    @FXML
    private TextField tf_email;

    @FXML
    private TextField tf_fullname;

    @FXML
    private TextField tf_gender;

    @FXML
    private TextField tf_pwd;

    public static boolean onScreen = true;
    
    public void returnToDashboard() {
        onScreen = false;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        reset();
        
    }
    public void reset() {
        //add gender
        tf_fullname.setText(StudentController.stdInstance().getFullname());
        tf_dob.setText(StudentController.stdInstance().getBirthday());
        tf_email.setText(StudentController.stdInstance().getEmail());
        tf_address.setText(StudentController.stdInstance().getAddress());
        tf_pwd.setText(StudentController.stdInstance().getPassword());
    }
}
