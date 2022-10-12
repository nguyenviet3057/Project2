package com.group2.project2;

import com.group2.project2.entities.attendanceEntity;
import com.group2.project2.entities.scheduleEntity;
import com.group2.project2.model.StudentList;
import com.group2.project2.model.students;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class ClassTeacherController implements Initializable{

    @FXML
    private TableColumn<StudentList, String> col_name;

    @FXML
    private TableColumn<StudentList, Number> col_no;

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
        ObservableList<StudentList> data = FXCollections.observableArrayList(StudentList.stdTableInstance(1));
        col_no.setCellValueFactory(new PropertyValueFactory<>("no"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        col_rollno.setCellValueFactory(new PropertyValueFactory<>("rollno"));
//        TableColumn<StudentList, ComboBox> day1 = new TableColumn<>("1");
//        day1.setCellValueFactory(new PropertyValueFactory<>("attendance"));
//        tbv_classList.getColumns().add(day1);
        List<TableColumn<StudentList, String>> day = new ArrayList<>();
        for (int i=0; i<TeacherController.getCurrentSession(); i++) {
            
            final int j = i;
//            if (attendanceEntity.currentByScheduleId(scheduleEntity.findBySubject_Class(TeacherController.subjectListInstance().get(0).getId(), TeacherController.getBookingClassId()).getId()) <= i+1)
            day.add(new TableColumn(String.valueOf(i+1)));
//            day.get(i).setCellValueFactory(new PropertyValueFactory<>("attendance"));
            TableColumn<StudentList, String> attendance1 = new TableColumn<>("1");
            TableColumn<StudentList, String> attendance2 = new TableColumn<>("2");
            attendance1.setCellValueFactory(new Callback<CellDataFeatures<StudentList, String>, ObservableValue<String>>() {
                public ObservableValue<String> call(CellDataFeatures<StudentList, String> p) {
                    // p.getValue() returns the Person instance for a particular TableView row
                    return new SimpleStringProperty(p.getValue().getAttendance1().get(j).toString());
                }
            });
            attendance2.setCellValueFactory(new Callback<CellDataFeatures<StudentList, String>, ObservableValue<String>>() {
                public ObservableValue<String> call(CellDataFeatures<StudentList, String> p) {
                    // p.getValue() returns the Person instance for a particular TableView row
                    return new SimpleStringProperty(p.getValue().getAttendance2().get(j).toString());
                }
            });
            day.get(i).getColumns().addAll(attendance1, attendance2);
            
            tbv_classList.getColumns().add(day.get(i));
        }
        for (int i=TeacherController.getCurrentSession(); i<TeacherController.subjectListInstance().get(0).getSessions(); i++) {
            day.add(new TableColumn(String.valueOf(i+1)));
//            day.get(i).setCellValueFactory(new PropertyValueFactory<>("attendance"));
            TableColumn<StudentList, String> attendance1 = new TableColumn<>("1");
            TableColumn<StudentList, String> attendance2 = new TableColumn<>("2");
            day.get(i).getColumns().addAll(attendance1, attendance2);
            
            tbv_classList.getColumns().add(day.get(i));
        }
        TableColumn emptyCol = new TableColumn();
        tbv_classList.getColumns().add(emptyCol);
        tbv_classList.setItems(data);
    }

}
