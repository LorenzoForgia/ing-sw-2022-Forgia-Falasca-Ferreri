package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsColorExc1Msg;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ColorExc1Scene extends View {
    private static AnsColorExc1Msg ansColorExc1Msg;

    public ColorExc1Scene(AnsColorExc1Msg ansColorExc1Msg) {
        this.ansColorExc1Msg = ansColorExc1Msg;
    }

    public void run(){
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToMoveStudent1Scene();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Colore invalido! Riprova", ButtonType.OK);
            alert.showAndWait();
        });
    }
}
