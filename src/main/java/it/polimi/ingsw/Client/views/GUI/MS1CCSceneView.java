package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsAskCAMsg;
import it.polimi.ingsw.messages.AnsPlayAfterCCMsg;
import javafx.application.Platform;

public class MS1CCSceneView extends View {
    private AnsPlayAfterCCMsg answerMsg;
    public MS1CCSceneView(AnsPlayAfterCCMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        MS1CCScene.setAnswerMsg(answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToMS1CCScene();
        });
    }
}
