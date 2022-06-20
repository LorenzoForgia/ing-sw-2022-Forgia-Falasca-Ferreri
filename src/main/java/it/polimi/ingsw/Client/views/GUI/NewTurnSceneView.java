package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;

import it.polimi.ingsw.messages.AnsNewTurnMsg;
import it.polimi.ingsw.messages.NewOrderMsg;
import javafx.application.Platform;
import javafx.event.ActionEvent;

public class NewTurnSceneView extends View {
    private AnsNewTurnMsg ansNewTurnMsg;

    public NewTurnSceneView(AnsNewTurnMsg ansNewTurnMsg) {
        this.ansNewTurnMsg = ansNewTurnMsg;
    }

    @Override
    public void run() {
        NewTurnScene.setAnsNewTurnMsg(ansNewTurnMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToNewTurnScene();
        });
    }

}
