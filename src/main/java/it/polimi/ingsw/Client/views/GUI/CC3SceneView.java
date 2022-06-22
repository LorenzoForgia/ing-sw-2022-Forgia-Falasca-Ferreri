package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsCC3Msg;
import javafx.application.Platform;

public class CC3SceneView extends View {
    private AnsCC3Msg answerMsg;

    public CC3SceneView(AnsCC3Msg answerMsg) {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        CC3Scene.setAnswerMsg(this.answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToCC3Scene();
        });
    }
}
