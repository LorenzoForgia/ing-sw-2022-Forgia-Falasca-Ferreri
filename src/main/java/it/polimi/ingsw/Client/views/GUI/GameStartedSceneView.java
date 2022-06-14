package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsGameStartedMsg;
import it.polimi.ingsw.messages.FirstPlayerTurnMsg;
import javafx.application.Platform;

public class GameStartedSceneView extends View {
    /** The view of the gamestartedsceneView */

    private AnsGameStartedMsg answerMsg;


    public GameStartedSceneView(AnsGameStartedMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }


    @Override
    public void run() {
        ShowPlayerScene.setAnswerMsg(answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToShowPlayerScene();

        });
    }
}
