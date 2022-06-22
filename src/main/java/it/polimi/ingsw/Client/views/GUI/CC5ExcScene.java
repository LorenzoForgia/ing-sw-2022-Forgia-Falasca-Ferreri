package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsCC5ExcMsg;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class CC5ExcScene extends View {
    private AnsCC5ExcMsg ansCC5ExcMsg;

    public CC5ExcScene(AnsCC5ExcMsg ansCC5ExcMsg) {
        this.ansCC5ExcMsg = ansCC5ExcMsg;
    }
    public void run(){
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToCC5Scene();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Scelta invalida! Riprova", ButtonType.OK);
            alert.showAndWait();
        });
    }
}
