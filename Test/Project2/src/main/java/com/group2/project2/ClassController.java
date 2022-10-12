package com.group2.project2;

import com.group2.project2.entities.attendanceEntity;
import com.group2.project2.model.StudentList;
import com.group2.project2.model.students;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class ClassController implements Initializable{
    
    @FXML
    private Label lbl_class;

    @FXML
    private Label lbl_semester;
    
    @FXML
    private TableColumn<StudentList, Number> col_no;
    
    @FXML
    private TableColumn<StudentList, String> col_name;

    @FXML
    private TableColumn<StudentList, String> col_email;

    @FXML
    private TableColumn<StudentList, String> col_phone;

    @FXML
    private TableColumn<StudentList, String> col_rollno;
    
    @FXML
    private TableColumn<StudentList, Number> col_totalAbsent;
    
    @FXML
    private Text lbl_subject;
    
    @FXML
    private Text lbl_teacher;
    
    @FXML
    private Text lbl_currentSession;
    
    @FXML
    private TableView<StudentList> tbv_classList;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Initialize layout
        lbl_class.setText("Class: " + StudentController.classInstance().getName());
        lbl_semester.setText("Semester: " + StudentController.semInstance().getSemester_id()%10);
        lbl_subject.setText("Subject: " + StudentController.subjectInstance().getName() + " (" + StudentController.subjectInstance().getSessions() + " sessions)");
        lbl_teacher.setText("Teacher: " + StudentController.staffInstance().getFullname());
        lbl_currentSession.setText("Current Session: " + String.valueOf(attendanceEntity.currentByScheduleId(StudentController.scheduleInstance().getId())));
//        List<StudentList> stdTable = new ArrayList<>();
//        for (students student : StudentController.stdListInstance()) {
//            stdTable.add(new StudentList(student.getRollno(), student.getFullname(), student.getBirthday(), student.getPhonenumber(), student.getAddress(), student.getEmail(), student.getPassword(), student.getPicture(), student.getStatus_id(), student.getSemester_id(), student.getClass_id()));
//        }

        ObservableList<StudentList> data = FXCollections.observableArrayList(StudentList.stdTableInstance(0));
//        System.out.println(data.toString());
        col_no.setCellValueFactory(new PropertyValueFactory<>("no"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        col_rollno.setCellValueFactory(new PropertyValueFactory<>("rollno"));
        col_phone.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        col_totalAbsent.setCellValueFactory(new PropertyValueFactory<>("totalAbsent"));
        
        tbv_classList.setItems(data);
        
    }
}


