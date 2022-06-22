package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsCC11Msg;
import javafx.application.Platform;

public class CC11SceneView extends View {
    private AnsCC11Msg answerMsg;

    public CC11SceneView(AnsCC11Msg answerMsg) {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        CC11Scene.setAnswerMsg(this.answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToCC11Scene();
        });
    }
}
