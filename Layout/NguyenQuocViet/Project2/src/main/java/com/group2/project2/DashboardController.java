package com.group2.project2;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
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
    private GridPane container;

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
    private Label dt_current;

    @FXML
    void switchToClass() throws IOException {
        App.setRoot("class");
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

    @FXML
    private CategoryAxis xAxis;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        //Initialize layout
        try {
            Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("right_pane.fxml"));
            container.add(newLoadedPane,2,0);
        } catch (IOException ex) {
            Logger.getLogger(ClassController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Create thread for clock
        dt_current.setText(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE) + " " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME).substring(0,8));
        
        
        
        XYChart.Series<String, Number> mark_T = new XYChart.Series<>(); 
        mark_T.setName("Theory"); 
        mark_T.getData().add(new XYChart.Data<>("<subject_1>", 10)); 
        mark_T.getData().add(new XYChart.Data<>("<subject_2>", 12)); 
        mark_T.getData().add(new XYChart.Data<>("HTML/CSS/JS/PHP", 8)); 
        mark_T.getData().add(new XYChart.Data<>("<subject_4>", 9));
        
        XYChart.Series<String, Number> mark_P = new XYChart.Series<>(); 
        mark_P.setName("Practice"); 
        mark_P.getData().add(new XYChart.Data<>("<subject_1>", 12)); 
        mark_P.getData().add(new XYChart.Data<>("<subject_2>", 15)); 
        mark_P.getData().add(new XYChart.Data<>("HTML/CSS/JS/PHP", 10)); 
        mark_P.getData().add(new XYChart.Data<>("<subject_4>", 12));
        
        XYChart.Series<String, Number> average_markT = new XYChart.Series<>(); 
        average_markT.setName("Average\nTheory"); 
        average_markT.getData().add(new XYChart.Data<>("<subject_1>", 11)); 
        average_markT.getData().add(new XYChart.Data<>("<subject_2>", 12)); 
        average_markT.getData().add(new XYChart.Data<>("HTML/CSS/JS/PHP", 6)); 
        average_markT.getData().add(new XYChart.Data<>("<subject_4>", 12));
        
        XYChart.Series<String, Number> average_markP = new XYChart.Series<>(); 
        average_markP.setName("Average\nPractice");
        average_markP.getData().add(new XYChart.Data<>("<subject_1>", 15)); 
        average_markP.getData().add(new XYChart.Data<>("<subject_2>", 17)); 
        average_markP.getData().add(new XYChart.Data<>("HTML/CSS/JS/PHP", 10)); 
        average_markP.getData().add(new XYChart.Data<>("<subject_4>", 7));   
        chart_avgmark.getData().addAll(mark_T, average_markT, mark_P, average_markP);
        
        //Config particular column's color in bar chart -> WORKED
        double maxBarWidth=-50;
        double minCategoryGap=40;
        double catSpace = xAxis.getCategorySpacing();
        chart_avgmark.setCategoryGap(160/mark_T.getData().size()*1.5);
        double avilableBarSpace = catSpace - (chart_avgmark.getCategoryGap() + chart_avgmark.getBarGap());
        double barWidth = (avilableBarSpace / chart_avgmark.getData().size()) - chart_avgmark.getBarGap();
        System.out.println(chart_avgmark.getData().size() + " " + chart_avgmark.getCategoryGap() + " " + avilableBarSpace + " " + barWidth); 
        
        Node chart_bg = chart_avgmark.lookup(".chart-legend");
        chart_bg.setStyle("-fx-background-color: transparent");
        for (int i=0; i<mark_T.getData().size(); i++) {
            Node n = chart_avgmark.lookup(".chart-bar.data"+i+".series0");
            n.setStyle("-fx-bar-fill: gold;");
            n = chart_avgmark.lookup(".chart-bar.data"+i+".series1");
            n.setStyle("-fx-bar-fill: gold; -fx-opacity: 0.5;");
            n = chart_avgmark.lookup(".chart-bar.data"+i+".series2");
            n.setStyle("-fx-bar-fill: red;");
            n = chart_avgmark.lookup(".chart-bar.data"+i+".series3");
            n.setStyle("-fx-bar-fill: red; -fx-opacity: 0.5;");
        }
        
//        Node m = chart_avgmark.lookup(".bar-chart");
//        System.out.println(m.getCssMetaData());
    }

}
