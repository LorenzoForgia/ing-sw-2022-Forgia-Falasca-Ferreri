package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsPlayAfterCCMsg;
import javafx.application.Platform;

public class PlayAfterCCSceneView extends View {
    private AnsPlayAfterCCMsg answerMsg;

    public PlayAfterCCSceneView(AnsPlayAfterCCMsg answerMsg) {
        this.answerMsg = answerMsg;
    }

    @Override
    public void run() {
        PlayAfterCCScene.setAnsPlayAfterCCMsg(answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToPlayAfterNotCCScene();
        });
    }
}
