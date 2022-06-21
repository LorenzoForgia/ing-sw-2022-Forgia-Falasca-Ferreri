package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsMoveStudent3Msg;
import javafx.application.Platform;

public class MoveStudent4SceneView extends View {
    private AnsMoveStudent3Msg ansMoveStudent3Msg;

    public MoveStudent4SceneView(AnsMoveStudent3Msg ansMoveStudent3Msg) {
        this.ansMoveStudent3Msg = ansMoveStudent3Msg;
    }

    @Override
    public void run() {
        MoveStudent4Scene.setNumberOfMessage(0);
        MoveStudent4Scene.setAnswerMsg(this.ansMoveStudent3Msg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToMoveStudent4Scene();
        });
    }
}
