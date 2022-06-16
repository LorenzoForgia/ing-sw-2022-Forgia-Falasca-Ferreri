package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsFirstPlayerTurnMsg;
import it.polimi.ingsw.messages.AnsGameStartedMsg;
import javafx.application.Platform;

public class FirstPlayerTurnSceneView extends View {

    private AnsFirstPlayerTurnMsg answerMsg;


    public FirstPlayerTurnSceneView(AnsFirstPlayerTurnMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }


    @Override
    public void run() {
        AssistantCardScene.setAnswerMsg(answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToCardAssistantScene();

        });
    }
}
