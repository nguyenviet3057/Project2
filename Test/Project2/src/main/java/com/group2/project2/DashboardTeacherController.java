package com.group2.project2;

import com.group2.project2.entities.attendanceEntity;
import com.group2.project2.entities.scheduleEntity;
import com.group2.project2.entities.subjectsEntity;
import com.group2.project2.model.ClassList;
import com.group2.project2.model.StudentList;
import com.group2.project2.model.students;
import com.group2.project2.model.subjects;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class DashboardTeacherController implements Initializable{

    @FXML
    private TableColumn<ClassList, String> col_day;

    @FXML
    private TableColumn<ClassList, String> col_name;

    @FXML
    private TableColumn<ClassList, Number> col_no;

    @FXML
    private TableColumn<ClassList, String> col_time;

    @FXML
    private Label lbl_booking;

    @FXML
    private Label lbl_class;

    @FXML
    private Label lbl_semester;

    @FXML
    private Pane pan_content;

    @FXML
    private TableView<ClassList> tbv_classList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        //Initialize layout
        String now = LocalDateTime.now().toLocalTime().toString().substring(0, 5);
        switch (LocalDateTime.now().getDayOfWeek().toString()) {
            case "MONDAY":
            case "WEDNESDAY":
            case "FRIDAY":
                if (now.compareTo("00:00") >= 0 && now.compareTo("11:00") <= 0) {
                    for (ClassList cl : ClassList.classTableInstance()) {
                        if (cl.getDay().compareTo("Monday/Wednesday/Friday") == 0 && cl.getTime().compareTo("07:00 - 11:00") == 0) {
                            lbl_booking.setText(cl.getName() + " - " + subjectsEntity.findByStaffId(TeacherController.teacherInstance().getId()).get(0).getName() + " | " + cl.getTime());
                            TeacherController.setBookingClassId(cl.getId());
                            break;
                        }
                    }
                } else {
                    if (now.compareTo("11:00") > 0 && now.compareTo("17:30") <= 0) {
                        for (ClassList cl : ClassList.classTableInstance()) {
                            if (cl.getDay().compareTo("Monday/Wednesday/Friday") == 0 && cl.getTime().compareTo("13:30 - 17:30") == 0) {
                                lbl_booking.setText(cl.getName() + " - " + subjectsEntity.findByStaffId(TeacherController.teacherInstance().getId()).get(0).getName() + " | " + cl.getTime());
                                TeacherController.setBookingClassId(cl.getId());
                                break;
                            }
                            System.out.println("Checked");
                        }
                    } else {
                        lbl_booking.setText("No class");
                    }
                }
                break;
            default:
                if (now.compareTo("00:00") >= 0 && now.compareTo("11:00") <= 0) {
                    for (ClassList cl : ClassList.classTableInstance()) {
                        if (cl.getDay().compareTo("Tuesday/Thursday/Saturday") == 0 && cl.getTime().compareTo("07:00 - 11:00") == 0) {
                            lbl_booking.setText(cl.getName() + " - " + subjectsEntity.findByStaffId(TeacherController.teacherInstance().getId()).get(0).getName() + " | " + cl.getTime());
                            TeacherController.setBookingClassId(cl.getId());
                            break;
                        }
                    }
                } else {
                    if (now.compareTo("11:00") > 0 && now.compareTo("17:30") <= 0) {
                        for (ClassList cl : ClassList.classTableInstance()) {
                            if (cl.getDay().compareTo("Tuesday/Thursday/Saturday") == 0 && cl.getTime().compareTo("13:30 - 17:30") == 0) {
                                TeacherController.setBookingClassId(cl.getId());
                                lbl_booking.setText(cl.getName() + " - " + subjectsEntity.findByStaffId(TeacherController.teacherInstance().getId()).get(0).getName() + " | " + cl.getTime());
                                break;
                            }
                        }
                    } else {
                        lbl_booking.setText("No class");
                    }
                }
                break;
        }
        
        TeacherController.setCurrentSession(attendanceEntity.currentByScheduleId(scheduleEntity.findBySubject_Class(TeacherController.subjectListInstance().get(0).getId(), 1).getId())); //Change 1 to TeacherController.getBookingClassId()
//        System.out.println("ID: " + attendanceEntity.currentByScheduleId(1)); //scheduleEntity.findBySubject_Class(TeacherController.subjectListInstance().get(0).getId(), TeacherController.getBookingClassId()).getId()
//        if (StudentController.bookingInstance() != null)
//            lbl_booking.setText(StudentController.subjectInstance().getName() + " | " + StudentController.bookingInstance().getBegin_time().toLocalDateTime().toLocalTime().toString() + " - " + StudentController.bookingInstance().getEnd_time().toLocalDateTime().toLocalTime().toString());
//        else lbl_booking.setText("No class today");
        
        ObservableList<ClassList> data = FXCollections.observableArrayList(ClassList.classTableInstance());
//        System.out.println(data.toString());
        col_no.setCellValueFactory(new PropertyValueFactory<>("no"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_day.setCellValueFactory(new PropertyValueFactory<>("day"));
        col_time.setCellValueFactory(new PropertyValueFactory<>("time"));
        
        tbv_classList.setItems(data);
    }
}
