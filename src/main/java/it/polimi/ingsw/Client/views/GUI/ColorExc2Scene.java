package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.messages.AnsColorExc2Msg;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ColorExc2Scene {
    private static AnsColorExc2Msg ansColorExc2Msg;
    public void run(){
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToMoveStudent2Scene();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Colore invalido! Riprova", ButtonType.OK);
            alert.showAndWait();
        });
    }
}
