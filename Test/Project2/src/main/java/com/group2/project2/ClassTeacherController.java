package com.group2.project2;

import com.group2.project2.entities.attendanceEntity;
import com.group2.project2.entities.bookingEntity;
import com.group2.project2.entities.scheduleEntity;
import com.group2.project2.entities.studentsEntity;
import com.group2.project2.model.StudentList;
import com.group2.project2.model.students;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
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
//        System.out.println("Before adding columns");
        List<TableColumn<StudentList, String>> day = new ArrayList<>();
//        System.out.println("Current: " + TeacherController.getCurrentSession());

        //Generate old date(s)
        for (int i=0; i<TeacherController.getDisplaySession(); i++) {
//            System.out.println("Display: " + TeacherController.getDisplaySession());
//            System.out.println("Adding columns");
            final int j = i;
//            if (attendanceEntity.currentByScheduleId(scheduleEntity.findBySubject_Class(TeacherController.subjectListInstance().get(0).getId(), TeacherController.getBookingClassId()).getId()) <= i+1)
            day.add(new TableColumn("(" + (i+1) + ") " + bookingEntity.findByScheduleId(TeacherController.getCurentSchedule()).get(i).getBegin_time().toLocalDateTime().toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString().substring(0,5))); //String.valueOf(i+1)
//            day.get(i).setCellValueFactory(new PropertyValueFactory<>("attendance"));
            TableColumn<StudentList, String> attendance1 = new TableColumn<>("Begin");
            TableColumn<StudentList, String> attendance2 = new TableColumn<>("End");
            attendance1.setCellValueFactory(new Callback<CellDataFeatures<StudentList, String>, ObservableValue<String>>() {
                public ObservableValue<String> call(CellDataFeatures<StudentList, String> p) {
                    // p.getValue() returns the Person instance for a particular TableView row
//                    System.out.println(p.getValue().getAttendance1().get(j).toString());
                    return new SimpleStringProperty(p.getValue().getAttendance1().get(j).toString());
                }
            });
            attendance1.setCellFactory(TextFieldTableCell.forTableColumn());
            attendance1.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<StudentList, String>>() {
                @Override
                public void handle(TableColumn.CellEditEvent<StudentList, String> event) {
                    StudentList std = event.getRowValue();
                    std.getAttendance1().set(j, event.getNewValue());
//                    System.out.println("Column 1: " + j);
                    attendanceEntity.updateAttendance1(std, j+1);
//                    System.out.println("1: " + event.getRowValue());
                }
            });
            
            attendance2.setCellValueFactory(new Callback<CellDataFeatures<StudentList, String>, ObservableValue<String>>() {
                public ObservableValue<String> call(CellDataFeatures<StudentList, String> p) {
                    // p.getValue() returns the Person instance for a particular TableView row
                    return new SimpleStringProperty(p.getValue().getAttendance2().get(j).toString());
                }
            });
            attendance2.setCellFactory(TextFieldTableCell.forTableColumn());
            attendance2.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<StudentList, String>>() {
                @Override
                public void handle(TableColumn.CellEditEvent<StudentList, String> event) {
                    StudentList std = event.getRowValue();
                    std.getAttendance2().set(j, event.getNewValue());
//                    System.out.println("Column 2: " + j);
//                    studentsEntity.update(std);
                    attendanceEntity.updateAttendance2(std, j+1);
//                    System.out.println("2: " + event.getRowValue());
                }
            });
            day.get(i).getColumns().addAll(attendance1, attendance2);
            
            tbv_classList.getColumns().add(day.get(i));
        }
        
        //Auto roll up students' attendance
        if (attendanceEntity.currentByScheduleId(scheduleEntity.findBySubject_Class(TeacherController.subjectListInstance().get(0).getId(), 1).getId()) < TeacherController.getTeachSession() && TeacherController.getCurrentSession() < TeacherController.subjectListInstance().get(0).getSessions())
            for (StudentList std : StudentList.getStdTable()) {
//                System.out.println(std);
                attendanceEntity.insert(std, TeacherController.getCurrentSession()+1);
                std.getAttendance1().add("P");
                std.getAttendance2().add("P");
            }
        
        //Generate new dates
        for (int i=TeacherController.getDisplaySession(); i<TeacherController.subjectListInstance().get(0).getSessions(); i++) {
            final int j = i;
            
            day.add(new TableColumn("(" + (i+1) + ") " + bookingEntity.findByScheduleId(TeacherController.getCurentSchedule()).get(i).getBegin_time().toLocalDateTime().toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString().substring(0,5)));
//            day.get(i).setCellValueFactory(new PropertyValueFactory<>("attendance"));
            TableColumn<StudentList, String> attendance1 = new TableColumn<>("Begin");
            attendance1.setCellFactory(TextFieldTableCell.forTableColumn());
            attendance1.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<StudentList, String>>() {
                @Override
                public void handle(TableColumn.CellEditEvent<StudentList, String> event) {
                    StudentList std = event.getRowValue();
                    std.getAttendance1().add(event.getNewValue());
                    
//                    System.out.println("Column 1: " + j);
//                    studentsEntity.update(std);
//                    attendanceEntity.updateAttendance1(std, j);
                    TeacherController.setDisplaySession(TeacherController.getTeachSession());
//                    System.out.println("Teach Session to Display: " + TeacherController.getTeachSession() + " | Display: " + TeacherController.getDisplaySession());
                    if (attendanceEntity.findByStudentRollno_BookingId(std, j+1) != null) {
//                        System.out.println("NOT null");
                        attendanceEntity.updateAttendance1(std, j+1);
                    } else {
//                        System.out.println("Null");
                        attendanceEntity.insertAttendance1(std, j+1);
                    }
//                    System.out.println("new 1: " + event.getRowValue());
                }
            });
            
            TableColumn<StudentList, String> attendance2 = new TableColumn<>("End");
//            attendance2.setEditable(false);
            attendance2.setCellFactory(TextFieldTableCell.forTableColumn());
            attendance2.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<StudentList, String>>() {
                @Override
                public void handle(TableColumn.CellEditEvent<StudentList, String> event) {
                    StudentList std = event.getRowValue();
                    std.getAttendance2().add(event.getNewValue());
//                    System.out.println("Column 2: " + j);
//                    studentsEntity.update(std);
//                    attendanceEntity.updateAttendance2(std, j);
//                    attendanceEntity.insert(std, j);
//                    System.out.println("booking_id: " + j+1);
//                    TeacherController.setCurrentSession(TeacherController.getCurrentSession()+1);
//                    System.out.println("new 2: " + event.getRowValue());
                }
            });
            day.get(i).getColumns().addAll(attendance1, attendance2);
            
            tbv_classList.getColumns().add(day.get(i));
        }
        TableColumn emptyCol = new TableColumn();
        tbv_classList.getColumns().add(emptyCol);
        tbv_classList.setItems(data);
//        System.out.println("After adding columns");
    }

}
