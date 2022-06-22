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
        PlayCC1Scene.setNumberOfMessage(3);
        PlayCC1Scene.setPlayers(this.answerMsg.GetPlayers());
        PlayCC1Scene.setCards(this.answerMsg.GetCharacterCards());
        PlayCC1Scene.setIslands(this.answerMsg.GetGB().GetIslands());
        PlayCC1Scene.setAnsMoveStudent3Msg(this.answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToPlayCC1Scene();
        });
    }
}
