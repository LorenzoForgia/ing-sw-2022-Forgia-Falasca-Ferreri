package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;

import it.polimi.ingsw.messages.AnsMoveStudent3Msg;
import javafx.application.Platform;

public class PlayCC4SceneView extends View {
    private AnsMoveStudent3Msg answerMsg;

    public PlayCC4SceneView(AnsMoveStudent3Msg answerMsg) {
        this.answerMsg = answerMsg;
    }

    @Override
    public void run() {
        PlayCC1Scene.setNumberOfMessage(3);
        PlayCC1Scene.setAnsMoveStudent3Msg(answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToPlayCC1Scene();
        });
    }
}
