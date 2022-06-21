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
        MS3NotCCScene.setAnswerMsg(answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToMS3NotCCScene();
        });
    }
}
