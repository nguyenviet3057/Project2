package com.group2.project2;

import com.group2.project2.entities.bookingEntity;
import com.group2.project2.entities.subjectsEntity;
import com.group2.project2.model.mark;
import com.group2.project2.model.subjects;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class DashboardController implements Initializable{

    @FXML
    private BarChart<String, Number> chart_avgmark;

    @FXML
    private CategoryAxis xAxis;
    
    @FXML
    private Label lbl_class;

    @FXML
    private Label lbl_semester;
    
    @FXML
    private Label lbl_booking;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        //Initialize layout
        lbl_class.setText("Class: " + StudentController.classInstance().getName());
        lbl_semester.setText("Semester: " + StudentController.semInstance().getSemester_id()%10);
        if (StudentController.bookingInstance() != null)
            lbl_booking.setText(StudentController.subjectInstance().getName() + " | " + StudentController.bookingInstance().getBegin_time().toLocalDateTime().toLocalTime().toString() + " - " + StudentController.bookingInstance().getEnd_time().toLocalDateTime().toLocalTime().toString());
        else lbl_booking.setText("No class today");
        
        //Display marks
        
        XYChart.Series<String, Number> mark_T = new XYChart.Series<>(); 
        mark_T.setName("Theory"); 
        XYChart.Series<String, Number> mark_P = new XYChart.Series<>();
        mark_P.setName("Practice"); 
        
        for (subjects sj : StudentController.subjectListInstance()) {
            for (mark mk : StudentController.markListInstance()) {
                if (mk.getSubject_id() == sj.getId()) {
                    if (mk.getMark_t2() == 0) mark_T.getData().add(new XYChart.Data<>(subjectsEntity.findByID(mk.getSubject_id()).getName(), mk.getMark_t1()));
                    else mark_T.getData().add(new XYChart.Data<>(subjectsEntity.findByID(mk.getSubject_id()).getName(), mk.getMark_t2()));
                    if (mk.getMark_p2() == 0) mark_P.getData().add(new XYChart.Data<>(subjectsEntity.findByID(mk.getSubject_id()).getName(), mk.getMark_p1()));
                    else mark_P.getData().add(new XYChart.Data<>(subjectsEntity.findByID(mk.getSubject_id()).getName(), mk.getMark_p2()));
                }
            }
        }
        chart_avgmark.getData().addAll(mark_T, mark_P);
        
        /*
        *
        * //Example
        *
        */
/*
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
*/
        
        //Config particular column's color in bar chart -> WORKED
        if (mark_T.getData().size()>0) {
            double maxBarWidth=-50;
            double minCategoryGap=40;
            double catSpace = xAxis.getCategorySpacing();
            chart_avgmark.setCategoryGap(160/mark_T.getData().size()*1.5);
            double avilableBarSpace = catSpace - (chart_avgmark.getCategoryGap() + chart_avgmark.getBarGap());
            double barWidth = (avilableBarSpace / chart_avgmark.getData().size()) - chart_avgmark.getBarGap();
    //        System.out.println(chart_avgmark.getData().size() + " " + chart_avgmark.getCategoryGap() + " " + avilableBarSpace + " " + barWidth);
        }
        
        Node chart_bg = chart_avgmark.lookup(".chart-legend");
        chart_bg.setStyle("-fx-background-color: transparent");
        for (int i=0; i<mark_T.getData().size(); i++) {
            Node n = chart_avgmark.lookup(".chart-bar.data"+i+".series0");
            n.setStyle("-fx-bar-fill: gold;");
            n = chart_avgmark.lookup(".chart-bar.data"+i+".series1");
            n.setStyle("-fx-bar-fill: gold; -fx-opacity: 0.5;");
            //Only 2 series: mark_T and mark_P
//            n = chart_avgmark.lookup(".chart-bar.data"+i+".series2");
//            n.setStyle("-fx-bar-fill: red;");
//            n = chart_avgmark.lookup(".chart-bar.data"+i+".series3");
//            n.setStyle("-fx-bar-fill: red; -fx-opacity: 0.5;");
        }
        
//        Node m = chart_avgmark.lookup(".bar-chart");
//        System.out.println(m.getCssMetaData());

//        System.out.println(StudentController.stdInstance().toString());
    }

}
