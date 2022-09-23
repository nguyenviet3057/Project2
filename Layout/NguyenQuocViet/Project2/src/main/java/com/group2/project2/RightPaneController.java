package com.group2.project2;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class RightPaneController implements Initializable{

    @FXML
    private Circle cir_avatar;

    @FXML
    private DatePicker dpk_date;

    @FXML
    private Label lbl_std_dob;

    @FXML
    private Label lbl_std_email;

    @FXML
    private Label lbl_std_phone;

    @FXML
    private Label lbl_std_rollno;

    @FXML
    private Pane pan_right;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lbl_std_rollno.setText("R001");
        lbl_std_dob.setText("01/01/2003");
        lbl_std_phone.setText("0987654321");
        lbl_std_email.setText("abcdefg654321@aptechlearning.edu.vn");
        
        //Set current time for datepicker
        dpk_date.setPromptText(LocalDate.now().toString());
        
        //Add cir_avatar's background
        String url = "images/avatar.jpg";
        Image img = new Image(url);
//        System.out.println("Dashboard: "+ img.getException());
        ImagePattern imagePattern = new ImagePattern(img);
        cir_avatar.setFill(imagePattern);
    }

}
