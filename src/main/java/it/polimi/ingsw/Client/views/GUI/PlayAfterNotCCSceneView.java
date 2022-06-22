package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;

import it.polimi.ingsw.messages.AnsPlayAfterNotCCMsg;
import javafx.application.Platform;

public class PlayAfterNotCCSceneView extends View {
    private AnsPlayAfterNotCCMsg answerMsg;

    public PlayAfterNotCCSceneView(AnsPlayAfterNotCCMsg answerMsg) {
        this.answerMsg = answerMsg;
    }

    @Override
    public void run() {
        PlayAfterNotCCScene.setAnsPlayAfterNotCCMsg(answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToPlayAfterNotCCScene();
        });
    }
}
