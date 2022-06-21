package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsPlayerAlrUsedCCExcMsg;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class PlayerAlrUsedCCExcScene extends View {
    private AnsPlayerAlrUsedCCExcMsg playerAlrUsedCCExcMsg;

    public PlayerAlrUsedCCExcScene(AnsPlayerAlrUsedCCExcMsg playerAlrUsedCCExcMsg) {
        this.playerAlrUsedCCExcMsg = playerAlrUsedCCExcMsg;
    }
    @Override
    public void run(){
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToChoiceCharacterCardScene();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Hai già usato questa carta! Riprova", ButtonType.OK);
            alert.showAndWait();
        });
    }
}
