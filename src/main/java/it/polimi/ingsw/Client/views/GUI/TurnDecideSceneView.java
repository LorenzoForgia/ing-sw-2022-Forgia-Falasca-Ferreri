package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsGameStartedMsg;
import it.polimi.ingsw.messages.AnsTurnDecidedMsg;
import it.polimi.ingsw.messages.TurnDecidedMsg;
import javafx.application.Platform;

public class TurnDecideSceneView extends View {
    /** The view of the gamestartedsceneView */

    private AnsTurnDecidedMsg answerMsg;


    public TurnDecideSceneView(AnsTurnDecidedMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }


    @Override
    public void run() {
        TurnDecideScene.setAnswerMsg(answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToTurnDecideScene();
        });
    }
}
