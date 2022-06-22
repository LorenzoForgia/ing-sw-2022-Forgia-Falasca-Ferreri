package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.messages.*;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class CC7ExcScene {
    private AnsCC7ExcMsg ansCC7ExcMsg;

    public CC7ExcScene(AnsCC7ExcMsg ansCC7ExcMsg) {
        this.ansCC7ExcMsg = ansCC7ExcMsg;
    }
    public void run(){
        Platform.runLater(() -> {
            CC7Scene.setChoseNumber(false);
            JavaFXMain.getCurrentApplication().switchToCC7Scene();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Scelta invalida! Riprova", ButtonType.OK);
            alert.showAndWait();
        });
    }
}
