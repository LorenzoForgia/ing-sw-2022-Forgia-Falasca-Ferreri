package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;

import it.polimi.ingsw.messages.AnsNotEnoughCoinsExcMsg;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class NotEnoughCoinsExcScene extends View {
    private AnsNotEnoughCoinsExcMsg ansNotEnoughCoinsExcMsg;

    public NotEnoughCoinsExcScene(AnsNotEnoughCoinsExcMsg ansNotEnoughCoinsExcMsg) {
        this.ansNotEnoughCoinsExcMsg = ansNotEnoughCoinsExcMsg;
    }

    @Override
    public void run(){
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToChoiceCharacterCardScene();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Non hai abbastanza monete! Riprova", ButtonType.OK);
            alert.showAndWait();
        });
    }
}
