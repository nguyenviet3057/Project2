package com.group2.project2;

import com.group2.project2.entities.attendanceEntity;
import com.group2.project2.entities.bookingEntity;
import com.group2.project2.entities.classesEntity;
import com.group2.project2.entities.scheduleEntity;
import com.group2.project2.entities.studentsEntity;
import com.group2.project2.entities.subjectsEntity;
import com.group2.project2.model.StudentList;
import com.group2.project2.model.booking;
import com.group2.project2.model.students;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
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
    private Text lbl_class;
    
    @FXML
    private Label lbl_error;

    @FXML
    private TableView<StudentList> tbv_classList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        ObservableList<String> rollUp = FXCollections.observableArrayList(
                "P", "PA", "A"
        );
        
        lbl_class.setText("Class: " + classesEntity.findById(TeacherController.getBookingClassId()).getName());
        lbl_subject.setText("Subject: " + subjectsEntity.findByStaffId(TeacherController.teacherInstance().getId()).get(0).getName());
        lbl_currentSession.setText("Current Session: " + String.valueOf(TeacherController.getCurrentSession()));
        
        ObservableList<StudentList> data = FXCollections.observableArrayList(StudentList.stdTableInstance(1));
        List<StudentList> stdList = StudentList.stdTableInstance(TeacherController.getBookingClassId());
        col_no.setCellValueFactory(new PropertyValueFactory<>("no"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        col_rollno.setCellValueFactory(new PropertyValueFactory<>("rollno"));
//        TableColumn<StudentList, ComboBox> day1 = new TableColumn<>("1");
//        day1.setCellValueFactory(new PropertyValueFactory<>("attendance"));
//        tbv_classList.getColumns().add(day1);
//        System.out.println("Before adding columns");
        List<TableColumn<StudentList, String>> day = new ArrayList<>();
//        System.out.println("Current: " + TeacherController.getCurrentSession());

        
        //Auto roll up students' attendance
//        System.out.println(bookingEntity.findByScheduleId(scheduleEntity.findBySubject_Class(TeacherController.subjectListInstance().get(0).getId(), 1).getId()).get(TeacherController.currentSessionInstance()).getId());
        if (!TeacherController.isIsRollUp() && MasterAppController.DATETIME.isAfter(bookingEntity.findByScheduleId(scheduleEntity.findBySubject_Class(TeacherController.subjectListInstance().get(0).getId(), 1).getId()).get(TeacherController.currentSessionInstance()).getBegin_time().toLocalDateTime()) && MasterAppController.DATETIME.isBefore(bookingEntity.findByScheduleId(scheduleEntity.findBySubject_Class(TeacherController.subjectListInstance().get(0).getId(), 1).getId()).get(TeacherController.currentSessionInstance()).getEnd_time().toLocalDateTime()) && TeacherController.getCurrentSession() < TeacherController.subjectListInstance().get(0).getSessions()) {
            for (StudentList std : StudentList.getStdTable()) {
//                System.out.println(std);
                attendanceEntity.insert(std, TeacherController.getCurrentSession()+1);
                std.getAttendance1().add("P");
                std.getAttendance2().add("P");
            }
            TeacherController.setIsRollUp(true);
            TeacherController.setDisplaySession(TeacherController.getTeachSession());
        }

        //Generate old date(s)
//        System.out.println("Display: " + TeacherController.getDisplaySession());
//        System.out.println(stdList.get(0).getAttendance1().size());
        for (int i=0; i<TeacherController.getDisplaySession(); i++) {
//            System.out.println("Display: " + TeacherController.getDisplaySession());
//            System.out.println("Adding columns");
            final int j = i;
//            List<booking> bkList = bookingEntity.findByScheduleId(TeacherController.getCurentSchedule());
//            if (attendanceEntity.currentByScheduleId(scheduleEntity.findBySubject_Class(TeacherController.subjectListInstance().get(0).getId(), TeacherController.getBookingClassId()).getId()) <= i+1)
            day.add(new TableColumn("(" + (i+1) + ") " + bookingEntity.findByScheduleId(TeacherController.getCurentSchedule()).get(i).getBegin_time().toLocalDateTime().toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString().substring(0,10))); //String.valueOf(i+1)
//            day.get(i).setCellValueFactory(new PropertyValueFactory<>("attendance"));
            TableColumn<StudentList, String> attendance1 = new TableColumn<>("Begin");
            TableColumn<StudentList, String> attendance2 = new TableColumn<>("End");
//            System.out.println("1: " + day.size());
            attendance1.setCellValueFactory(new Callback<CellDataFeatures<StudentList, String>, ObservableValue<String>>() {
                public ObservableValue<String> call(CellDataFeatures<StudentList, String> p) {
                    // p.getValue() returns the Person instance for a particular TableView row
//                    System.out.println(day.size() + " : " + p.getValue().getAttendance1().size());
                    return new SimpleStringProperty(p.getValue().getAttendance1().get(j).toString());
                }
            });
            attendance1.setPrefWidth(65);
            attendance1.setCellFactory(ComboBoxTableCell.forTableColumn(rollUp));
            attendance1.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<StudentList, String>>() {
                @Override
                public void handle(TableColumn.CellEditEvent<StudentList, String> event) {
//                    lbl_error.setVisible(false);
                    StudentList std = event.getRowValue();
                    std.getAttendance1().set(j, event.getNewValue());
                    attendanceEntity.updateAttendance1(std, j+1);
//                    System.out.println(event.getNewValue());
//                    if (event.getNewValue().compareToIgnoreCase("p")==0 || event.getNewValue().compareToIgnoreCase("pa")==0 || event.getNewValue().compareToIgnoreCase("a")==0) {
//                        std.getAttendance1().set(j, event.getNewValue().toUpperCase());
//                        attendanceEntity.updateAttendance1(std, j+1);
//                    } else {
//                        lbl_error.setVisible(true);
//                    }
//                    System.out.println("Column 1: " + j);
//                    System.out.println("1: " + event.getRowValue());
                }
            });
            
//            System.out.println("2: " + day.size());
            attendance2.setCellValueFactory(new Callback<CellDataFeatures<StudentList, String>, ObservableValue<String>>() {
                public ObservableValue<String> call(CellDataFeatures<StudentList, String> p) {
                    // p.getValue() returns the Person instance for a particular TableView row
//                    System.out.println(day.size() + " : " + p.getValue().getAttendance1().size());
                    return new SimpleStringProperty(p.getValue().getAttendance2().get(j).toString());
                }
            });
            attendance2.setPrefWidth(65);
            attendance2.setCellFactory(ComboBoxTableCell.forTableColumn(rollUp));
            attendance2.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<StudentList, String>>() {
                @Override
                public void handle(TableColumn.CellEditEvent<StudentList, String> event) {
                    StudentList std = event.getRowValue();
//                    System.out.println(std.getAttendance2().get(j));
                    std.getAttendance2().set(j, event.getNewValue());
//                    System.out.println(std.getAttendance2().get(j));
                    attendanceEntity.updateAttendance2(std, j+1);
                }
            });
            day.get(i).getColumns().addAll(attendance1, attendance2);
            
            tbv_classList.getColumns().add(day.get(i));
        }
        
        //Generate new dates
        for (int i=TeacherController.getDisplaySession(); i<TeacherController.subjectListInstance().get(0).getSessions(); i++) {
            final int j = i;
            
            day.add(new TableColumn("(" + (i+1) + ") " + bookingEntity.findByScheduleId(TeacherController.getCurentSchedule()).get(i).getBegin_time().toLocalDateTime().toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString().substring(0,10)));
//            day.get(i).setCellValueFactory(new PropertyValueFactory<>("attendance"));
            TableColumn<StudentList, String> attendance1 = new TableColumn<>("Begin");
            attendance1.setEditable(false);
            attendance1.setPrefWidth(65);
            attendance1.setCellFactory(ComboBoxTableCell.forTableColumn(rollUp));
            attendance1.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<StudentList, String>>() {
                @Override
                public void handle(TableColumn.CellEditEvent<StudentList, String> event) {
                    StudentList std = event.getRowValue();
                    std.getAttendance1().add(event.getNewValue());
                    
//                    System.out.println("Column 1: " + j);
//                    studentsEntity.update(std);
//                    attendanceEntity.updateAttendance1(std, j);
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
            attendance2.setEditable(false);
            attendance2.setPrefWidth(65);
            attendance2.setCellFactory(ComboBoxTableCell.forTableColumn(rollUp));
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
