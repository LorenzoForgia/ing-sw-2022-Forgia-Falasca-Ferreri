package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsAskCAMsg;
import it.polimi.ingsw.messages.AnsMoveStudent3Msg;
import javafx.application.Platform;

public class PlayCC4Players3SceneView extends View {
    private AnsMoveStudent3Msg answerMsg;
    public PlayCC4Players3SceneView(AnsMoveStudent3Msg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        PlayCC4Players3Scene.setAnsMoveStudent3Msg(this.answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToPlayCC4Players3Scene();
        });
    }
}
