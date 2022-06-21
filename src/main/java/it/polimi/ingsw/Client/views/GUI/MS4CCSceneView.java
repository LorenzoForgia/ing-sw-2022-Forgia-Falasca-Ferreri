package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsPlayAfterCCMsg;
import javafx.application.Platform;

public class MS4CCSceneView extends View {
    private AnsPlayAfterCCMsg answerMsg;
    public MS4CCSceneView(AnsPlayAfterCCMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        MS4CCScene.setAnswerMsg(answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToMS4CCScene();
        });
    }
}
