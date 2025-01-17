package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class JavaFXMain extends Application {


    private Stage primaryStage;
    private static JavaFXMain currentApplication;
    private Client client;


    private int nplayers;

    public static void main(String[] args)
    {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        currentApplication = this;
        this.primaryStage = primaryStage;
        client = new Client();
       /*
        primaryStage.setOnCloseRequest((event) -> {
            if (serverHandler.isConnected())
                serverHandler.closeConnection();
        });*/
        /*
        this.serverHandler = new ServerHandler();
        /*
        this.serverHandler.setConnectionClosedObserver(() -> {
            Platform.runLater(() -> {
                if (primaryStage.isShowing()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "The connection was closed.", ButtonType.OK);
                    alert.showAndWait();
                    switchToLoginScene();
                }
            });
        });*/
        Image icon= new Image("logocraniocreation.jpg");
        primaryStage.getIcons().add(icon);
        primaryStage.setX(50);
        primaryStage.setY(20);
        switchToConnectionScene();
        primaryStage.show();
    }

    public static JavaFXMain getCurrentApplication() {
        return currentApplication;
    }


    public Client getClient() {
        return client;
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
        primaryStage.setTitle("Eriantys");
        primaryStage.sizeToScene();
    }

    public void switchToConnectionScene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/ConnectionScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Connessione");
        primaryStage.sizeToScene();
    }

    public void switchToExpertModeScene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/ExpertModeScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Login");
        primaryStage.sizeToScene();
    }
    public void switchToWaitingScene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/WaitingScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Eriantys");
        primaryStage.sizeToScene();
    }
    public void switchToNumberOfPlayerScene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/NumberOfPlayerScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.sizeToScene();
    }

    public void switchToChoiceCharacterCardScene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/ChoiceCharacterCardScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Carte Personaggio");
        primaryStage.sizeToScene();
    }

    public void switchToIslandTitleScene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/IslandTiles.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.sizeToScene();
    }

    public void switchToCardAssistantScene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/AssistantCardScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.sizeToScene();
    }
    public void switchToShowPlayerScene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/ShowPlayerScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.sizeToScene();
    }

    public void switchToTurnDecideScene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/TurnDecidedScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.sizeToScene();
    }

    public int getNplayers() {
        return nplayers;
    }

    public void setNplayers(int nplayers) {
        this.nplayers = nplayers;
    }
    public void switchToMoveStudent1Scene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/MoveStudent1Scene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.sizeToScene();
    }
    public void switchToMoveStudent2Scene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/MoveStudent2Scene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.sizeToScene();
    }
    public void switchToMoveStudent3Scene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/MoveStudent3Scene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.sizeToScene();
    }
    public void switchToMoveStudent4Scene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/MoveStudent4Scene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.sizeToScene();
    }

    public void switchToMS1DiningOrIslandScene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/MS1DiningOrIslandScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.sizeToScene();
    }
    public void switchToMS2DiningOrIslandScene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/MS2DiningOrIslandScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.sizeToScene();
    }
    public void switchToMS3DiningOrIslandScene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/MS3DiningOrIslandScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.sizeToScene();
    }
    public void switchToMS4DiningOrIslandScene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/MS4DiningOrIslandScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Eriantys");
        primaryStage.sizeToScene();
    }
    public void switchToSchoolBoardScene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/SchoolBoardScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Eriantys");
        primaryStage.sizeToScene();
    }
    public void switchToAskForMotherNatureScene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/AskForMotherNatureScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Eriantys");
        primaryStage.sizeToScene();
    }
    public void switchToAskForMN3PlayersScene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/AskForMN3PlayersScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Eriantys");
        primaryStage.sizeToScene();
    }
    public void switchToChooseCloudScene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/ChooseCloudScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Eriantys");
        primaryStage.sizeToScene();
    }
    public void switchToTurnEndedScene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/TurnEndedScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Eriantys");
        primaryStage.sizeToScene();
    }
    public void switchToNewTurnScene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/NewTurnScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Eriantys");
        primaryStage.sizeToScene();
    }
    public void switchToAssistantCardSceneNewTurn()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/AssistantCardSceneNewTurn.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Eriantys");
        primaryStage.sizeToScene();
    }
    public void switchToEndGameScene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/EndGameScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Eriantys");
        primaryStage.sizeToScene();
    }
    public void switchToPlayCC1Scene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/PlayCC1Scene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Eriantys");
        primaryStage.sizeToScene();
    }
    public void switchToPlayAfterCCScene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/PlayAfterCCScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Eriantys");
        primaryStage.sizeToScene();
    }
    public void switchToPlayAfterNotCCScene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/PlayAfterNotCCScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Eriantys");
        primaryStage.sizeToScene();
    }
    public void switchToShowCardAssistantScene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/ShowAssistantCardScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Eriantys");
        primaryStage.sizeToScene();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void switchToCC9Scene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/CC9Scene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Eriantys");
        primaryStage.sizeToScene();
    }
    public void switchToCC3Scene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/CC3Scene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Eriantys");
        primaryStage.sizeToScene();
    }
    public void switchToCC5Scene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/CC5Scene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Eriantys");
        primaryStage.sizeToScene();
    }
    public void switchToCC12Scene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/CC12Scene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Eriantys");
        primaryStage.sizeToScene();
    }
    public void switchToCC1Scene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/CC1.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Eriantys");
        primaryStage.sizeToScene();
    }
    public void switchToCC11Scene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/CC11.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Eriantys");
        primaryStage.sizeToScene();
    }
    public void switchToCC10Scene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/CC10Scene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Eriantys");
        primaryStage.sizeToScene();
    }

    public void switchToCC7Scene()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/CC7Scene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Eriantys");
        primaryStage.sizeToScene();
    }

}
