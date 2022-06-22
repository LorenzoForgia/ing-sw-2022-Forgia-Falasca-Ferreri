package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsCC9ExcMsg;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class CC9ExcScene extends View {
    private AnsCC9ExcMsg ansCC9ExcMsg;

    public CC9ExcScene(AnsCC9ExcMsg ansCC9ExcMsg) {
        this.ansCC9ExcMsg = ansCC9ExcMsg;
    }
    public void run(){
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToCC9Scene();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Scelta invalida! Riprova", ButtonType.OK);
            alert.showAndWait();
        });
    }
}
