package com.group2.project2;

import com.group2.project2.entities.attendanceEntity;
import com.group2.project2.entities.staffEntity;
import com.group2.project2.model.StudentList;
import com.group2.project2.model.staff;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class DashboardStaffController implements Initializable{

    @FXML
    private TableColumn<staff, Date> col_dob;

    @FXML
    private TableColumn<staff, String> col_email;

    @FXML
    private TableColumn<staff, String> col_name;

    @FXML
    private TableColumn<staff, String> col_phone;

    @FXML
    private Label lbl_booking;

    @FXML
    private Pane pan_content;

    @FXML
    private TableView<staff> tbv_staffList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<staff> data = FXCollections.observableArrayList(staffEntity.list());
//        System.out.println(data.toString());
        col_name.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        col_dob.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        col_phone.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        tbv_staffList.setItems(data);
        
    }
}
