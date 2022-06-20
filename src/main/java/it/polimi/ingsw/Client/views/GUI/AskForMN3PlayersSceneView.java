package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsMoveStudent4Msg;
import it.polimi.ingsw.messages.NumStepMNMsg;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class AskForMN3PlayersSceneView extends View {
    private AnsMoveStudent4Msg ansMoveStudent4Msg;


    public AskForMN3PlayersSceneView(AnsMoveStudent4Msg ansMoveStudent4Msg) {
        this.ansMoveStudent4Msg = ansMoveStudent4Msg;
    }

    @Override
    public void run() {
        AskForMN3PlayersScene.setAnsMoveStudent4Msg(ansMoveStudent4Msg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToAskForMN3PlayersScene();
        });
    }
}
