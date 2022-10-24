package com.group2.project2;

import com.group2.project2.entities.subjectsEntity;
import com.group2.project2.model.mark;
import com.group2.project2.model.subjects;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;

public class MarkController implements Initializable{

    @FXML
    private BarChart<String, Number> chart_avgmark;

    @FXML
    private CategoryAxis xAxis;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Display marks
        
        XYChart.Series<String, Number> mark_T = new XYChart.Series<>(); 
        mark_T.setName("Theory"); 
        XYChart.Series<String, Number> mark_P = new XYChart.Series<>();
        mark_P.setName("Practice"); 
        
        for (subjects sj : StudentController.subjectListInstance()) {
            for (mark mk : StudentController.markListInstance()) {
                if (mk.getSubject_id() == sj.getId()) {
                    if (mk.getMark_t2() == -1) mark_T.getData().add(new XYChart.Data<>(subjectsEntity.findByID(mk.getSubject_id()).getName(), mk.getMark_t1()));
                    else mark_T.getData().add(new XYChart.Data<>(subjectsEntity.findByID(mk.getSubject_id()).getName(), mk.getMark_t2()));
                    if (mk.getMark_p2() == -1) mark_P.getData().add(new XYChart.Data<>(subjectsEntity.findByID(mk.getSubject_id()).getName(), mk.getMark_p1()));
                    else mark_P.getData().add(new XYChart.Data<>(subjectsEntity.findByID(mk.getSubject_id()).getName(), mk.getMark_p2()));
                }
            }
        }
        chart_avgmark.getData().addAll(mark_T, mark_P);
    }

}
