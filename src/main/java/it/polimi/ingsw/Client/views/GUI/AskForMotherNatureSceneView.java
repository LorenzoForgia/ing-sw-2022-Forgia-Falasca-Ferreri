package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;

import it.polimi.ingsw.messages.AnsMoveStudent3Msg;
import it.polimi.ingsw.messages.NumStepMNMsg;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class AskForMotherNatureSceneView extends View {
    private AnsMoveStudent3Msg ansMoveStudent3Msg;


    public AskForMotherNatureSceneView(AnsMoveStudent3Msg ansMoveStudent3Msg) {
        this.ansMoveStudent3Msg = ansMoveStudent3Msg;
    }

    @Override
    public void run() {
        AskForMotherNatureScene.setNumberOfMessage(0);
        AskForMotherNatureScene.setAnsMoveStudent3Msg(ansMoveStudent3Msg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToAskForMotherNatureScene();
        });
    }
}
