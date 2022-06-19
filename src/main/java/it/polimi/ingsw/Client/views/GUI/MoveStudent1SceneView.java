package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsAskCAMsg;
import it.polimi.ingsw.messages.AnsGameStartedMsg;
import javafx.application.Platform;

public class MoveStudent1SceneView extends View {
    private AnsAskCAMsg answerMsg;
    public MoveStudent1SceneView(AnsAskCAMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        MoveStudent1Scene.setAnswerMsg(this.answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToMoveStudent1Scene();
        });
    }

}
