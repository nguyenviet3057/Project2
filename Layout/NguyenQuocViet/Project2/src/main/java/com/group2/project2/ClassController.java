package com.group2.project2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class ClassController implements Initializable{

    @FXML
    private Button btn_class;

    @FXML
    private Button btn_dashboard;

    @FXML
    private Button btn_form;

    @FXML
    private Button btn_mark;

    @FXML
    private Button btn_news;

    @FXML
    private Button btn_setting;
    
    @FXML
    private GridPane container;

    @FXML
    private Label dt_current;

    @FXML
    private ImageView img_header;

    @FXML
    private Label lbl_header;

    @FXML
    private Pane pan_left;

    @FXML
    private Pane pan_title;

    @FXML
    private TableView<?> tbv_classList;

    @FXML
    void switchToDashboard() throws IOException {
        App.setRoot("dashboard");
    }
    @FXML
    void switchToMark() throws IOException {
        App.setRoot("mark");
    }
    @FXML
    void switchToNews() throws IOException {
        App.setRoot("news");
    }
    @FXML
    void switchToForm() throws IOException {
        App.setRoot("form");
    }
    @FXML
    void switchToSetting() throws IOException {
        App.setRoot("setting");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("right_pane.fxml"));
            container.add(newLoadedPane,2,0);
        } catch (IOException ex) {
            Logger.getLogger(ClassController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
