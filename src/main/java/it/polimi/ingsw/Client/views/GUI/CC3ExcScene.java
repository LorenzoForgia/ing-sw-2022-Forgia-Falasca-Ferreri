package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsCC3ExcMsg;
import it.polimi.ingsw.messages.AnsCC3Msg;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class CC3ExcScene extends View {
    private AnsCC3ExcMsg ansCC3Msg;

    public CC3ExcScene(AnsCC3ExcMsg ansCC3Msg) {
        this.ansCC3Msg = ansCC3Msg;
    }
    public void run(){
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToCC3Scene();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Scelta invalida! Riprova", ButtonType.OK);
            alert.showAndWait();
        });
    }
}
