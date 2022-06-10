package it.polimi.ingsw.Client.views.GUI;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class JavaFXMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Stage primaryStage;


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Group root = new Group();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public void switchToLoginScene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/LoginScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Login");
        primaryStage.sizeToScene();
    }
}
