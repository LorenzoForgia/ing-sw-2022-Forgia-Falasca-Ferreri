package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsCC9Msg;
import javafx.application.Platform;

public class CC9SceneView extends View {
    private AnsCC9Msg answerMsg;

    public CC9SceneView(AnsCC9Msg answerMsg) {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        CC9Scene.setAnswerMsg(this.answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToCC9Scene();
        });
    }
}
