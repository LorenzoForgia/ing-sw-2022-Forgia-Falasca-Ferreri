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

        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToPlayCC4Scene();
        });
    }
}
