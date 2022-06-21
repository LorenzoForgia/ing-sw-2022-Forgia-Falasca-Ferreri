package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsPlayAfterCCMsg;
import it.polimi.ingsw.messages.AnsPlayAfterNotCCMsg;
import javafx.application.Platform;

public class AskForMNotCCSceneView extends View {
    private AnsPlayAfterNotCCMsg ansPlayAfterNotCCMsg;

    public AskForMNotCCSceneView(AnsPlayAfterNotCCMsg ansPlayAfterNotCCMsg) {
        this.ansPlayAfterNotCCMsg = ansPlayAfterNotCCMsg;
    }

    @Override
    public void run() {
        AskForMotherNatureScene.setNumberOfMessage(2);
        AskForMotherNatureScene.setAnsPlayAfterNotCCMsg(ansPlayAfterNotCCMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToAskForMotherNatureScene();
        });
    }
}
