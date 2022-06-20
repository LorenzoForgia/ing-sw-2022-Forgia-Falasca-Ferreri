package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsNumStepExcMsg;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class NumStepExcScene extends View {
    private AnsNumStepExcMsg numStepExcMsg;

    public NumStepExcScene(AnsNumStepExcMsg numStepExcMsg) {
        this.numStepExcMsg = numStepExcMsg;
    }

    public void run(){
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToAskForMotherNatureScene();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Numero invalido! Riprova", ButtonType.OK);
            alert.showAndWait();
        });
    }
}