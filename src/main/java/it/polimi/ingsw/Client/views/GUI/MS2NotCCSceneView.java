package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsPlayAfterNotCCMsg;
import javafx.application.Platform;

public class MS2NotCCSceneView extends View {
    private AnsPlayAfterNotCCMsg answerMsg;
    public MS2NotCCSceneView(AnsPlayAfterNotCCMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        MoveStudent2Scene.setNumberOfMessage(2);
        MoveStudent2Scene.setAnsPlayAfterNotCCMsg(answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToMoveStudent2Scene();
        });
    }
}
