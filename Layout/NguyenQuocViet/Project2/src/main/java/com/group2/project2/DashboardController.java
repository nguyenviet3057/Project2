package com.group2.project2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;

public class DashboardController implements Initializable{

    @FXML
    private Arc arc_avatar;

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
    private BarChart<String, Number> chart_avgmark;

    @FXML
    private Circle cir_avatar;

    @FXML
    private DatePicker dpk_date;

    @FXML
    private ImageView img_header;

    @FXML
    private Label lbl_header;

    @FXML
    private Pane pan_content;

    @FXML
    private Pane pan_left;

    @FXML
    private Pane pan_right;

    @FXML
    private Pane pan_title;

    @FXML
    void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private CategoryAxis xAxis;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        XYChart.Series<String, Number> mark_T = new XYChart.Series<>(); 
        mark_T.setName("Theory"); 
        mark_T.getData().add(new XYChart.Data<>("<subject_1>", 10)); 
        mark_T.getData().add(new XYChart.Data<>("<subject_2>", 12)); 
        mark_T.getData().add(new XYChart.Data<>("<subject_3>", 8)); 
        mark_T.getData().add(new XYChart.Data<>("<subject_4>", 9));
        
        XYChart.Series<String, Number> mark_P = new XYChart.Series<>(); 
        mark_P.setName("Practice"); 
        mark_P.getData().add(new XYChart.Data<>("<subject_1>", 12)); 
        mark_P.getData().add(new XYChart.Data<>("<subject_2>", 15)); 
        mark_P.getData().add(new XYChart.Data<>("<subject_3>", 10)); 
        mark_P.getData().add(new XYChart.Data<>("<subject_4>", 12));
        
        XYChart.Series<String, Number> average_markT = new XYChart.Series<>(); 
        average_markT.setName("Average Theory"); 
        average_markT.getData().add(new XYChart.Data<>("<subject_1>", 11)); 
        average_markT.getData().add(new XYChart.Data<>("<subject_2>", 12)); 
        average_markT.getData().add(new XYChart.Data<>("<subject_3>", 6)); 
        average_markT.getData().add(new XYChart.Data<>("<subject_4>", 12));
        
        XYChart.Series<String, Number> average_markP = new XYChart.Series<>(); 
        average_markP.setName("Average Practice"); 
        average_markP.getData().add(new XYChart.Data<>("<subject_1>", 15)); 
        average_markP.getData().add(new XYChart.Data<>("<subject_2>", 17)); 
        average_markP.getData().add(new XYChart.Data<>("<subject_3>", 10)); 
        average_markP.getData().add(new XYChart.Data<>("<subject_4>", 7));   
        chart_avgmark.getData().addAll(mark_T, mark_P, average_markT, average_markP);
    }

}
