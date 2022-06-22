package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsCC12ExcMsg;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class CC12ExcScene extends View {
    private AnsCC12ExcMsg ansCC12ExcMsg;

    public CC12ExcScene(AnsCC12ExcMsg ansCC12ExcMsg) {
        this.ansCC12ExcMsg = ansCC12ExcMsg;
    }
    public void run(){
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToCC12Scene();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Scelta invalida! Riprova", ButtonType.OK);
            alert.showAndWait();
        });
    }
}
