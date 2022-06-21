package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsPlayAfterNotCCMsg;
import javafx.application.Platform;

public class MS3NotCCSceneView extends View {
    private AnsPlayAfterNotCCMsg answerMsg;
    public MS3NotCCSceneView(AnsPlayAfterNotCCMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        MoveStudent3Scene.setAnsPlayAfterNotCCMsg(answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToMoveStudent3Scene();
        });
    }
}
