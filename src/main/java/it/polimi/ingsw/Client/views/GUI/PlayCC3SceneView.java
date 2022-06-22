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
        PlayCC1Scene.setNumberOfMessage(2);
        PlayCC1Scene.setPlayers(this.answerMsg.GetPlayers());
        PlayCC1Scene.setCards(this.answerMsg.GetCharacterCards());
        PlayCC1Scene.setIslands(this.answerMsg.GetGB().GetIslands());
        PlayCC1Scene.setAnsMoveStudent2Msg(this.answerMsg);
        PlayCC1Scene.setPlayer(this.answerMsg.GetPlayer());
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToPlayCC1Scene();
        });
    }
}
