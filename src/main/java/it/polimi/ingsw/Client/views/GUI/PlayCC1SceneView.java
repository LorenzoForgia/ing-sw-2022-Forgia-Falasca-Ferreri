package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsAskCAMsg;
import javafx.application.Platform;

public class PlayCC1SceneView extends View {
    private AnsAskCAMsg answerMsg;
    public PlayCC1SceneView(AnsAskCAMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        PlayCC1Scene.setAnsAskCAMsg(this.answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToPlayCC1Scene();
        });
    }
}
