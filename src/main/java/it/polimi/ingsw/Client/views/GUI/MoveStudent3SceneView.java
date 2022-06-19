package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import javafx.application.Platform;

public class MoveStudent3SceneView extends View {
    @Override
    public void run() {
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToMoveStudent3Scene();
        });
    }
}
