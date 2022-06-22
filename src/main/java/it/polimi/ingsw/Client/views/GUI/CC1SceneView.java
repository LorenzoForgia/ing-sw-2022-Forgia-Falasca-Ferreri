package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsCC1Msg;
import javafx.application.Platform;

public class CC1SceneView extends View {
    private AnsCC1Msg answerMsg;

    public CC1SceneView(AnsCC1Msg answerMsg) {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        CC1Scene.setAnswerMsg(answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToCC1Scene();
        });
    }
}
