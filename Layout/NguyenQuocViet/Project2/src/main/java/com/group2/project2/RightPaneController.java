/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.project2;

import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 *
 * @author nguye
 */
public class RightPaneController extends Pane{
    @FXML
    private Circle cir_avatar;

    @FXML
    private DatePicker dpk_date;
    
    @FXML
    private Label lbl_std_rollno;
    
    @FXML
    private Pane pan_right;
    
    private RightPaneController() {
//        String url = "images/avatar.jpg";
//        File file = new File(url);
//        System.out.println(file.exists());
//        Image img = new Image(url);
//        ImagePattern imagePattern = new ImagePattern(img);
//        System.out.println(img.getException());
////        cir_avatar.setFill();
//        System.out.println(lbl_std_rollno.getCssMetaData());
//        lbl_std_rollno.setText("R001");
    }
    
    private static RightPaneController instance;
    
    public static RightPaneController getInstance() {
        if (instance == null) {
            instance = new RightPaneController();
        }
        return instance;
    }
}