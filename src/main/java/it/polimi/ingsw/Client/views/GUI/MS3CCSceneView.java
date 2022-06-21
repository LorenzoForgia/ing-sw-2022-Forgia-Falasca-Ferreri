package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsPlayAfterCCMsg;
import javafx.application.Platform;

public class MS3CCSceneView extends View {
    private AnsPlayAfterCCMsg answerMsg;
    public MS3CCSceneView(AnsPlayAfterCCMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        MoveStudent3Scene.setNumberOfMessage(1);
        MoveStudent3Scene.setAnsPlayAfterCCMsg(answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToMoveStudent3Scene();
        });
    }
}
