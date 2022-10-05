package com.group2.project2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    
    public static boolean alive = true;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("MainLayout"), 1280, 720);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
        alive = false;
    }

    public static Scene getScene() {
        return scene;
    }
}