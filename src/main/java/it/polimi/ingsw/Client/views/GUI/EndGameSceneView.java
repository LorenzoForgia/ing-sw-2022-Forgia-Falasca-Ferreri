package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsEndGameMsg;
import javafx.application.Platform;

public class EndGameSceneView extends View {
    private AnsEndGameMsg ansEndGameMsg;

    public EndGameSceneView(AnsEndGameMsg ansEndGameMsg) {
        this.ansEndGameMsg = ansEndGameMsg;
    }
    @Override
    public void run() {
        EndGameScene.setAnswerMsg(ansEndGameMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToEndGameScene();

        });
    }
}
