package com.group2.project2;



import com.group2.project2.model.staff;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class TeacherAppController implements Initializable{

    @FXML
    private Button btn_class;

    @FXML
    private Button btn_dashboard;

    @FXML
    private Label btn_editStd;

    @FXML
    private Button btn_form;

    @FXML
    private Button btn_news;

    @FXML
    private Button btn_setting;

    @FXML
    private Button btn_mark;

    @FXML
    private Circle cir_avatar;

    @FXML
    private GridPane container;

    @FXML
    private DatePicker dpk_date;

    @FXML
    private Label dt_current;

    @FXML
    private ImageView img_header;

    @FXML
    private Label lbl_fullname;

    @FXML
    private Label lbl_header;

    @FXML
    private Label lbl_hello;

    @FXML
    private Label lbl_sta_dob;

    @FXML
    private Label lbl_sta_email;

    @FXML
    private Label lbl_sta_phone;

    @FXML
    private Label lbl_version;

    @FXML
    private GridPane mid_pane;

    @FXML
    private Pane pan_left;

    @FXML
    private GridPane pan_nav;

    @FXML
    private Pane pan_right;

    @FXML
    private Pane pan_title;

    void resetBtnBackground() {
        Set<Node> nodes = pan_nav.lookupAll(".button");
        for (Iterator<Node> iterator = nodes.iterator(); iterator.hasNext();) {
            Node next = iterator.next();
            next.setStyle("-fx-alignment: center-left; -fx-background-color: white; -fx-cursor: hand");
        }
    }
    
    void switchToLayout(int layout_number) {
        resetBtnBackground();
        String layout_fxml;
        switch (layout_number) {
            case 2:
                layout_fxml = "classTeacher";
                btn_class.setStyle("-fx-alignment: center-left; -fx-background-color: #f0f0f0; -fx-cursor: hand");
                break;
            case 3:
                layout_fxml = "markTeacher";
                btn_mark.setStyle("-fx-alignment: center-left; -fx-background-color: #f0f0f0; -fx-cursor: hand");
                break;
            case 4:
                layout_fxml = "newsTeacher";
                btn_news.setStyle("-fx-alignment: center-left; -fx-background-color: #f0f0f0; -fx-cursor: hand");
                break;
            case 5:
                layout_fxml = "formTeacher";
                btn_form.setStyle("-fx-alignment: center-left; -fx-background-color: #f0f0f0; -fx-cursor: hand");
                break;
            case 6:
                layout_fxml = "setting";
                btn_setting.setStyle("-fx-alignment: center-left; -fx-background-color: #f0f0f0; -fx-cursor: hand");
                break;
            default:
                layout_fxml = "dashboardTeacher";
                btn_dashboard.setStyle("-fx-alignment: center-left; -fx-background-color: #f0f0f0; -fx-cursor: hand");
                break;
        }
        if (mid_pane.getChildren().size() == 2) {
            mid_pane.getChildren().remove(1);
        }
        try {
            Pane newLoadedPane =  FXMLLoader.load(getClass().getResource(layout_fxml + ".fxml"));
            mid_pane.add(newLoadedPane,0,1);
        } catch (IOException ex) {
            Logger.getLogger(ClassController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void switchToDashboard() throws IOException {
//        App.setRoot("dashboard");
        switchToLayout(1);
    }
    @FXML
    void switchToClass() throws IOException {
        switchToLayout(2);
    }
    @FXML
    void switchToMark() throws IOException {
        switchToLayout(3);
    }
    @FXML
    void switchToNews() throws IOException {
        switchToLayout(4);
    }
    @FXML
    void switchToForm() throws IOException {
        switchToLayout(5);
    }
    @FXML
    void switchToSetting() throws IOException {
        switchToLayout(6);
    }

    public void switchToMasterApp() throws IOException {
        TeacherController.resetData();
        App.setRoot("MasterApp");
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        staff sta = TeacherController.teacherInstance();
        lbl_hello.setText("Hello " + sta.getFullname().substring(sta.getFullname().lastIndexOf(' ')+1) + "!");
        
        Thread dynamicClock = new Thread() {
            public void run() {
                while (App.alive) {
                    Platform.runLater(() ->{
                        dt_current.setText(MasterAppController.DATETIME.toLocalDate().toString() + " | " + MasterAppController.DATETIME.toLocalTime().toString().substring(0,8));
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(StudentAppController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        dynamicClock.start();
        
        lbl_fullname.setText(sta.getFullname());
        lbl_sta_dob.setText(sta.getBirthday().toString());
        lbl_sta_phone.setText(sta.getPhonenumber());
        lbl_sta_email.setText(sta.getEmail());
        
        //Add cir_avatar's background
        String url = "file:images/avatar.jpg";
        Image img = new Image(url);
//        System.out.println("Dashboard: "+ img.getException());
        ImagePattern imagePattern = new ImagePattern(img);
        cir_avatar.setFill(imagePattern);
        
        //Set current time for datepicker
        dpk_date.setPromptText(MasterAppController.DATETIME.toLocalDate().toString());
        try {
            //Default Layout
            switchToDashboard();
        } catch (IOException ex) {
            Logger.getLogger(StudentAppController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
