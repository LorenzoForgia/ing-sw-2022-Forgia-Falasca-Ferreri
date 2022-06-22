package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsCannotPlayCCMsg;
import it.polimi.ingsw.messages.CannotPlayCCMsg;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class CannotPlayCCScene extends View {
    private AnsCannotPlayCCMsg ansCannotPlayCCMsg;

    public CannotPlayCCScene(AnsCannotPlayCCMsg ansCannotPlayCCMsg) {
        this.ansCannotPlayCCMsg = ansCannotPlayCCMsg;
    }
    @Override
    public void run(){
        Platform.runLater(() -> {
            CannotPlayCCMsg ccMsg= new CannotPlayCCMsg();
            JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(ccMsg);
            Alert alert = new Alert(Alert.AlertType.ERROR, "Scelta invalida!", ButtonType.OK);
            alert.showAndWait();
        });
    }
}
