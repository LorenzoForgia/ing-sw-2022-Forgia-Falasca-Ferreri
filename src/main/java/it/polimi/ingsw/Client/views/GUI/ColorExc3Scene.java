package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.messages.AnsColorExc3Msg;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ColorExc3Scene {
    private static AnsColorExc3Msg ansColorExc3Msg;
    public void run(){
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToMoveStudent3Scene();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Colore invalido! Riprova", ButtonType.OK);
            alert.showAndWait();
        });
    }
}
