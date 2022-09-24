package com.group2.project2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;

public class DashboardController implements Initializable{

    @FXML
    private BarChart<String, Number> chart_avgmark;

    @FXML
    private CategoryAxis xAxis;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        //Initialize layout
        
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
//        System.out.println(chart_avgmark.getData().size() + " " + chart_avgmark.getCategoryGap() + " " + avilableBarSpace + " " + barWidth);
        
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
