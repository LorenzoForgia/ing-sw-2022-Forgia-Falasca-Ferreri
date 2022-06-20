package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsCloudMsg;
import it.polimi.ingsw.messages.CheckTurnEndedMsg;
import javafx.application.Platform;
import javafx.event.ActionEvent;

public class TurnEndedSceneView extends View {
    private AnsCloudMsg ansCloudMsg;

    public TurnEndedSceneView(AnsCloudMsg ansCloudMsg) {
        this.ansCloudMsg = ansCloudMsg;
    }
    @Override
    public void run() {
        TurnEndedScene.setAnsCloudMsg(ansCloudMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToTurnEndedScene();
        });
    }
}
