package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsColorExc1Msg;
import it.polimi.ingsw.messages.AnsColorExc4Msg;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ColorExc4Scene extends View {
    private static AnsColorExc4Msg ansColorExc4Msg;

    public ColorExc4Scene(AnsColorExc4Msg ansColorExc4Msg) {
        this.ansColorExc4Msg = ansColorExc4Msg;
    }

    public void run(){
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToMoveStudent4Scene();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Colore invalido! Riprova", ButtonType.OK);
            alert.showAndWait();
        });
    }
}
