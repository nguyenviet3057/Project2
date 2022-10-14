package com.group2.project2;

import com.group2.project2.entities.attendanceEntity;
import com.group2.project2.entities.subjectsEntity;
import com.group2.project2.model.StudentList;
import com.group2.project2.model.mark;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class MarkTeacherController implements Initializable{

    @FXML
    private TableColumn<StudentList, String> col_name;

    @FXML
    private TableColumn<StudentList, Number> col_no;

    @FXML
    private TableColumn<StudentList, Number> col_theory;

    @FXML
    private TableColumn<StudentList, Number> col_practice;

    @FXML
    private TableColumn<StudentList, String> col_rollno;

    @FXML
    private Text lbl_currentSession;

    @FXML
    private Text lbl_subject;

    @FXML
    private Text lbl_teacher;

    @FXML
    private TableView<StudentList> tbv_classList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        if (StudentList.getStdTable() == null) StudentList.setStdTable(StudentList.stdTableInstance(1));
        for (StudentList std : StudentList.getStdTable())
            for (mark mk : StudentList.markListInstance(std.getRollno())) {
                if (mk.getSubject_id() == TeacherController.subjectListInstance().get(0).getId()) {
                    if (mk.getMark_t2() == 0) std.setTheory(mk.getMark_t1());
                    else std.setTheory(mk.getMark_t2());
                    if (mk.getMark_p2() == 0) std.setPractice(mk.getMark_p1());
                    else std.setPractice(mk.getMark_p2());
                }
            }
        
        ObservableList<StudentList> data = FXCollections.observableArrayList(StudentList.stdTableInstance(1));
        col_no.setCellValueFactory(new PropertyValueFactory<>("no"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        col_rollno.setCellValueFactory(new PropertyValueFactory<>("rollno"));
        col_theory.setCellValueFactory(new PropertyValueFactory<>("theory"));
        col_theory.setCellFactory(TextFieldTableCell.<StudentList, Number>forTableColumn(new NumberStringConverter()));
        col_theory.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<StudentList, Number>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<StudentList, Number> event) {
                
            }
        });
        col_practice.setCellValueFactory(new PropertyValueFactory<>("practice"));
        col_practice.setCellFactory(TextFieldTableCell.<StudentList, Number>forTableColumn(new NumberStringConverter()));
        col_practice.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<StudentList, Number>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<StudentList, Number> event) {
                
            }
        });
        
        tbv_classList.setItems(data);
    }

}
