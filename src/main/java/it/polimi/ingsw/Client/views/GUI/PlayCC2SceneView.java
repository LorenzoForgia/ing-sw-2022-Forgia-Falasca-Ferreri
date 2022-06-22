package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsAskCAMsg;
import it.polimi.ingsw.messages.AnsMoveStudent1Msg;
import javafx.application.Platform;

public class PlayCC2SceneView extends View {
    private AnsMoveStudent1Msg answerMsg;

    public PlayCC2SceneView(AnsMoveStudent1Msg answerMsg) {
        this.answerMsg = answerMsg;
    }

    @Override
    public void run() {
        PlayCC1Scene.setNumberOfMessage(1);
        PlayCC1Scene.setPlayers(this.answerMsg.GetPlayers());
        PlayCC1Scene.setCards(this.answerMsg.GetCharacterCards());
        PlayCC1Scene.setIslands(this.answerMsg.GetGB().GetIslands());
        PlayCC1Scene.setAnsMoveStudent1Msg(this.answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToPlayCC1Scene();
        });
    }
}
