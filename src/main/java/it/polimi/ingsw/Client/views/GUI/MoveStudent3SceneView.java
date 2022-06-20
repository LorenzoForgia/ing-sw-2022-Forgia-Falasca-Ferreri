package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsMoveStudent2Msg;
import javafx.application.Platform;

public class MoveStudent3SceneView extends View {
    private AnsMoveStudent2Msg answerMsg;
    public MoveStudent3SceneView(AnsMoveStudent2Msg answerMsg) {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        MoveStudent3Scene.setAnswerMsg(this.answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToMoveStudent3Scene();
        });
    }
}
