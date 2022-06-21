package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsMoveStudent3Msg;
import it.polimi.ingsw.messages.AnsPlayAfterCCMsg;
import javafx.application.Platform;

public class AskForMNCCSceneView extends View {
    private AnsPlayAfterCCMsg ansPlayAfterCCMsg;


    public AskForMNCCSceneView(AnsPlayAfterCCMsg ansPlayAfterCCMsg) {
        this.ansPlayAfterCCMsg = ansPlayAfterCCMsg;
    }

    @Override
    public void run() {
        AskForMotherNatureScene.setNumberOfMessage(1);
        AskForMotherNatureScene.setAnsPlayAfterCCMsg(ansPlayAfterCCMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToAskForMotherNatureScene();
        });
    }
}
