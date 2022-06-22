package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsMoveStudent4Msg;
import javafx.application.Platform;

public class PlayCC5SceneView extends View {
    private AnsMoveStudent4Msg ansMoveStudent4Msg;

    public PlayCC5SceneView(AnsMoveStudent4Msg ansMoveStudent4Msg) {
        this.ansMoveStudent4Msg = ansMoveStudent4Msg;
    }
    @Override
    public void run() {
        PlayCC1Scene.setNumberOfMessage(4);
        PlayCC1Scene.setPlayers(this.ansMoveStudent4Msg.GetPlayers());
        PlayCC1Scene.setCards(this.ansMoveStudent4Msg.GetCharacterCards());
        PlayCC1Scene.setIslands(this.ansMoveStudent4Msg.GetGB().GetIslands());
        PlayCC1Scene.setAnsMoveStudent4Msg(ansMoveStudent4Msg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToPlayCC1Scene();
        });
    }
}
