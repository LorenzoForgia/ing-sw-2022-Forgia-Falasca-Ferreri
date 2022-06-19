package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsColorExc1Msg;
import it.polimi.ingsw.messages.AnsColorExc2Msg;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ColorExc2Scene extends View {
    private static AnsColorExc2Msg ansColorExc2Msg;

    public ColorExc2Scene(AnsColorExc2Msg ansColorExc2Msg) {
        this.ansColorExc2Msg = ansColorExc2Msg;
    }

    public void run(){
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToMoveStudent2Scene();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Colore invalido! Riprova", ButtonType.OK);
            alert.showAndWait();
        });
    }
}
