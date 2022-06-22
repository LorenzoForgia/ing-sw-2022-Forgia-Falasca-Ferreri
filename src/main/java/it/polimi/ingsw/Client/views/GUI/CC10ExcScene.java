package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.*;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class CC10ExcScene extends View {
    private AnsCC10ExcMsg ansCC10ExcMsg;

    public CC10ExcScene(AnsCC10ExcMsg ansCC11ExcMsg) {
        this.ansCC10ExcMsg = ansCC10ExcMsg;
    }
    public void run(){
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToCC11Scene();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Scelta invalida! Riprova", ButtonType.OK);
            alert.showAndWait();
        });
    }
}
