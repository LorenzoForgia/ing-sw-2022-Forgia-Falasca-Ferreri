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


    private Stage primaryStage;

    public static void main(String[] args)
    {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        this.primaryStage = primaryStage;
        switchToLoginScene();
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

    public void switchToConnectionScene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/LoginConnection.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Connection");
        primaryStage.sizeToScene();
    }
}
