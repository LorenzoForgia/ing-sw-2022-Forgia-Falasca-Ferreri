package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsPlayAfterNotCCMsg;
import javafx.application.Platform;

public class MS4NotCCSceneView extends View {
    private AnsPlayAfterNotCCMsg answerMsg;
    public MS4NotCCSceneView(AnsPlayAfterNotCCMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        MoveStudent4Scene.setNumberOfMessage(2);
        MoveStudent4Scene.setAnsPlayAfterNotCCMsg(answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToMoveStudent4Scene();
        });
    }
}
