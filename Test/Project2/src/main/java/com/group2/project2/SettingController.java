package com.group2.project2;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class SettingController {

    @FXML
    private Pane pan_content;

    @FXML
    void switchTheme(MouseEvent event) {
        System.out.println("Clicked: Previous Theme " + StudentAppController.theme);
        StudentAppController.theme = !StudentAppController.theme;
        if (StudentAppController.theme) {
            System.out.println("Changed Theme");
//            System.out.println(MainLayoutController.container);
        }
    }

}
