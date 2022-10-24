package com.group2.project2;

import com.group2.project2.entities.classesEntity;
import com.group2.project2.entities.semesterEntity;
import com.group2.project2.entities.staffEntity;
import com.group2.project2.entities.studentsEntity;
import com.group2.project2.entities.subjectsEntity;
import com.group2.project2.model.ClassList;
import com.group2.project2.model.StudentList;
import com.group2.project2.model.classes;
import com.group2.project2.model.semester;
import com.group2.project2.model.staff;
import com.group2.project2.model.subjects;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class StudentStaffController implements Initializable{

    @FXML
    private Button btn_back;

    @FXML
    private Button btn_edit;

    @FXML
    private Button btn_save;
    
    @FXML
    private ComboBox<ClassList> cb_class;
    
    @FXML
    private ComboBox<semester> cb_sem;
    
    @FXML
    private ComboBox<subjects> cb_subject;

    @FXML
    private ComboBox<staff> cb_teacher;

    @FXML
    private TableColumn<StudentList, String> col_email;

    @FXML
    private TableColumn<StudentList, String> col_name;

    @FXML
    private TableColumn<StudentList, Number> col_no;

    @FXML
    private TableColumn<StudentList, String> col_phone;

    @FXML
    private TableColumn<StudentList, String> col_rollno;

    @FXML
    private TableColumn<StudentList, Number> col_totalAbsent;

    @FXML
    private Text lbl_currentSession;

    @FXML
    private Text lbl_subject;

    @FXML
    private Text lbl_teacher;
    
    @FXML
    private Label lbl_warning;

    @FXML
    private TableView<StudentList> tbv_classList;
    
    private List<StudentList> stdChangeList = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<ClassList> classList = FXCollections.observableArrayList(StaffController.classInstance());
        cb_class.setCellFactory(new Callback<ListView<ClassList>,ListCell<ClassList>>(){
            @Override
            public ListCell<ClassList> call(ListView<ClassList> p) {
                
                final ListCell<ClassList> cell = new ListCell<ClassList>(){

                    @Override
                    protected void updateItem(ClassList t, boolean bln) {
                        super.updateItem(t, bln);
                        
                        if(t != null){
                            setText(t.getName());
//                            System.out.println(t.getName());
                        }else{
                            setText(null);
                        }
                    }
 
                };
                
                return cell;
            }
        });
        cb_class.getItems().addAll(classList);
    }
    
    @FXML
    public void loadData() {
        stdChangeList.clear();
        lbl_warning.setVisible(false);
        tbv_classList.setEditable(false);
        btn_edit.setDisable(false);
        btn_save.setDisable(true);
        btn_back.setDisable(true);
        cb_sem.setOpacity(1);
        cb_teacher.setOpacity(1);
        cb_subject.setOpacity(1);
        StaffController.setCurrentClassId(cb_class.getValue().getId());
        ObservableList<semester> semList = FXCollections.observableArrayList(semesterEntity.listUnique());
        cb_sem.setCellFactory(new Callback<ListView<semester>, ListCell<semester>>(){
            @Override
            public ListCell<semester> call(ListView<semester> p) {
                
                final ListCell<semester> cell = new ListCell<semester>(){

                    @Override
                    protected void updateItem(semester t, boolean bln) {
                        super.updateItem(t, bln);
                        
                        if(t != null){
                            setText(String.valueOf(t.getSemester_id()));
                        }else{
                            setText(null);
                        }
                    }
 
                };
                
                return cell;
            }
        });
        cb_sem.getItems().setAll(semList);
        cb_sem.getSelectionModel().select(semesterEntity.findById(cb_class.getValue().getSemester_id()));
        
        ObservableList<subjects> sjList = FXCollections.observableArrayList(subjectsEntity.findBySemesterId(cb_sem.getValue().getSemester_id()));
        cb_subject.setCellFactory(new Callback<ListView<subjects>, ListCell<subjects>>(){
            @Override
            public ListCell<subjects> call(ListView<subjects> p) {
                
                final ListCell<subjects> cell = new ListCell<subjects>(){

                    @Override
                    protected void updateItem(subjects t, boolean bln) {
                        super.updateItem(t, bln);
                        
                        if(t != null){
                            setText(String.valueOf(t.getName()));
                        }else{
                            setText(null);
                        }
                    }
 
                };
                
                return cell;
            }
        });
        cb_subject.getItems().setAll(sjList);
        cb_subject.getSelectionModel().select(subjectsEntity.findByStaffId(cb_class.getValue().getStaff_id()).get(0));
//        System.out.println(classesEntity.findById(cb_class.getValue().getStaff_id()));
//        System.out.println(subjectsEntity.findByStaffId(cb_class.getValue().getStaff_id()).get(0));

        cb_teacher.getSelectionModel().select(staffEntity.findById(cb_subject.getValue().getStaff_id()));
        
        StudentList.setStdTable(null);
        ObservableList<StudentList> data = FXCollections.observableArrayList(StudentList.stdTableInstance(cb_class.getValue().getId()));
//        System.out.println(cb_class.getValue().getId());
        col_no.setCellValueFactory(new PropertyValueFactory<>("no"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        col_rollno.setCellValueFactory(new PropertyValueFactory<>("rollno"));
        col_phone.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        
        col_name.setCellFactory(TextFieldTableCell.forTableColumn());
        col_name.setEditable(true);
        col_name.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<StudentList, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<StudentList, String> event) {
                StudentList std = event.getRowValue();
                StudentList stdChange = new StudentList(std.getNo(), std.getRollno(), std.getFullname(), std.getBirthday(), std.getPhonenumber(), std.getAddress(), std.getEmail(), std.getPassword(), std.getPicture(), std.getStatus_id(), std.getSemester_id(), std.getClass_id(), std.getGender(), std.getTotalAbsent(), std.getAttendance1(), std.getAttendance2());
//                String name = event.getOldValue();
                stdChange.setFullname(event.getNewValue());
                stdChangeList.add(stdChange);
//                std.setFullname(name);
//                System.out.println(name);
                String warning = "Changing " + stdChangeList.size() + " student(s): ";
                for (StudentList s : stdChangeList) {
                    warning += "no." + s.getNo() + ", ";
                }
                lbl_warning.setText(warning.substring(0, warning.length()-2) + ".");
                lbl_warning.setVisible(true);
//                studentsEntity.update(std);
            }
        });
        
//        tbv_classList.refresh();
        tbv_classList.getItems().setAll(data);
//        tbv_classList.refresh();
//        System.out.println(data);
    }
    
    @FXML
    public void loadSubject() {        
        ObservableList<subjects> sjList = FXCollections.observableArrayList(subjectsEntity.findBySemesterId(cb_sem.getValue().getSemester_id()));
        cb_subject.setCellFactory(new Callback<ListView<subjects>, ListCell<subjects>>(){
            @Override
            public ListCell<subjects> call(ListView<subjects> p) {
                
                final ListCell<subjects> cell = new ListCell<subjects>(){

                    @Override
                    protected void updateItem(subjects t, boolean bln) {
                        super.updateItem(t, bln);
                        
                        if(t != null){
                            setText(String.valueOf(t.getName()));
                        }else{
                            setText(null);
                        }
                    }
 
                };
                
                return cell;
            }
        });
        cb_subject.getItems().setAll(sjList);
        cb_subject.getSelectionModel().select(subjectsEntity.findByStaffId(cb_class.getValue().getStaff_id()).get(0));
//        System.out.println(classesEntity.findById(cb_class.getValue().getStaff_id()));
//        System.out.println(subjectsEntity.findByStaffId(cb_class.getValue().getStaff_id()).get(0));

        cb_teacher.getSelectionModel().select(staffEntity.findById(cb_subject.getValue().getStaff_id()));
    }
    
    @FXML
    public void loadTeacher() {
        cb_teacher.getSelectionModel().select(staffEntity.findById(cb_subject.getValue().getStaff_id()));
    }

    @FXML
    public void edit() {
        btn_edit.setDisable(true);
        btn_back.setDisable(false);
        btn_save.setDisable(false);
        lbl_warning.setVisible(false);
        tbv_classList.setEditable(true);
        cb_sem.setDisable(false);
        cb_sem.setOpacity(1);
//        cb_teacher.setDisable(false);
        cb_teacher.setOpacity(1);
        cb_subject.setDisable(false);
        cb_subject.setOpacity(1);
    }
    
    @FXML
    public void save() {
        if (stdChangeList.size()>0) {
            for (StudentList s : stdChangeList) {
                studentsEntity.update(s);
                tbv_classList.getItems().set(s.getNo()-1, s);
            }
            lbl_warning.setText("Successfully update " + stdChangeList.size() + " student(s)!");
        }
//        cb_class.getSelectionModel().select(cb_class.getValue());
        tbv_classList.refresh();
        stdChangeList.clear();
        tbv_classList.setEditable(false);
        btn_save.setDisable(true);
        btn_edit.setDisable(false);
        btn_back.setDisable(true);
        cb_sem.setDisable(false);
        cb_sem.setOpacity(1);
//        cb_teacher.setDisable(false);
        cb_teacher.setOpacity(1);
        cb_subject.setDisable(false);
        cb_subject.setOpacity(1);
    }
    
    @FXML
    public void back() {
        stdChangeList.clear();
        System.out.println(stdChangeList.size());
        tbv_classList.refresh();
        btn_back.setDisable(true);
        btn_edit.setDisable(false);
        btn_save.setDisable(true);
        lbl_warning.setVisible(false);
        tbv_classList.setEditable(false);
        cb_sem.setDisable(true);
        cb_sem.setOpacity(1);
//        cb_teacher.setDisable(true);
        cb_teacher.setOpacity(1);
        cb_subject.setDisable(true);
        cb_subject.setOpacity(1);
        cb_sem.getSelectionModel().select(semesterEntity.findById(cb_class.getValue().getSemester_id()));
    }
}
