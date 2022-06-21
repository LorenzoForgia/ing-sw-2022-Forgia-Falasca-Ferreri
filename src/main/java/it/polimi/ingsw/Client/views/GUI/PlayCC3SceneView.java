package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsAskCAMsg;
import it.polimi.ingsw.messages.AnsMoveStudent2Msg;
import javafx.application.Platform;

public class PlayCC3SceneView extends View {
    private AnsMoveStudent2Msg answerMsg;
    public PlayCC3SceneView(AnsMoveStudent2Msg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        PlayCC3Scene.setAnsMoveStudent2Msg(this.answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToPlayCC3Scene();
        });
    }
}
