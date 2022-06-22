package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsCC12Msg;
import javafx.application.Platform;

public class CC12SceneView extends View {
    private AnsCC12Msg answerMsg;

    public CC12SceneView(AnsCC12Msg answerMsg) {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        CC12Scene.setAnswerMsg(this.answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToCC12Scene();
        });
    }
}
