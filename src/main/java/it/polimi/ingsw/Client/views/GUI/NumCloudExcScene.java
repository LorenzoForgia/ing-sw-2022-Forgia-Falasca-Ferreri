package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsNumCloudExcMsg;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class NumCloudExcScene extends View {
    private AnsNumCloudExcMsg ansNumCloudExcMsg;

    public NumCloudExcScene(AnsNumCloudExcMsg ansNumCloudExcMsg) {
        this.ansNumCloudExcMsg = ansNumCloudExcMsg;
    }
    public void run(){
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToChooseCloudScene();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Nuvola invalida! Riprova", ButtonType.OK);
            alert.showAndWait();
        });
    }
}
