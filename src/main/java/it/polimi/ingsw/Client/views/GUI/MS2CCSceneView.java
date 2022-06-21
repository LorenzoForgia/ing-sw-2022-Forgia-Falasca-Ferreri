package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsPlayAfterCCMsg;
import javafx.application.Platform;

public class MS2CCSceneView extends View {
    private AnsPlayAfterCCMsg answerMsg;
    public MS2CCSceneView(AnsPlayAfterCCMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        MoveStudent2Scene.setNumberOfMessage(1);
        MoveStudent2Scene.setAnsPlayAfterCCMsg(answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToMoveStudent2Scene();
        });
    }
}
