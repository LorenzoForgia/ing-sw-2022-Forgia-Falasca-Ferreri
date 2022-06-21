package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;

import it.polimi.ingsw.messages.AnsPlayAfterNotCCMsg;
import javafx.application.Platform;

public class MS1NotCCSceneView extends View {
    private AnsPlayAfterNotCCMsg answerMsg;
    public MS1NotCCSceneView(AnsPlayAfterNotCCMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        MoveStudent1Scene.setNumberOfMessage(2);
        MoveStudent1Scene.setAnsPlayAfterNotCCMsg(answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToMoveStudent1Scene();
        });
    }
}
