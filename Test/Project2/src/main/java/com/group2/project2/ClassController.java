package com.group2.project2;

import com.group2.project2.model.students;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClassController implements Initializable{

    @FXML
    private TableColumn<?, ?> col_name;

    @FXML
    private TableColumn<?, ?> col_no;

    @FXML
    private TableColumn<?, ?> col_gender;

    @FXML
    private TableColumn<?, ?> col_phone;

    @FXML
    private TableColumn<?, ?> col_rollno;
    
    @FXML
    private TableView<students> tbv_classList;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<students> data = FXCollections.observableList(StudentController.stdListInstance());
        col_no.setCellFactory(new PropertyValueFactory("rollno"));
        col_name.setCellFactory(new PropertyValueFactory("fullname"));
        col_rollno.setCellFactory(new PropertyValueFactory("rollno"));
        col_phone.setCellFactory(new PropertyValueFactory("phone"));
        col_gender.setCellFactory(new PropertyValueFactory("gender"));
        
        tbv_classList.setItems(data);
//        int stdCount = 0;
//        for (Object student : StudentController.stdListInstance()) {
//            stdCount++;
//            tbv_classList.setItems(data);
//            
//        }
        
    }

}
