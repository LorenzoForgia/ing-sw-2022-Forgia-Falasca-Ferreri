package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsCC5Msg;
import javafx.application.Platform;

public class CC5SceneView extends View {
    private AnsCC5Msg answerMsg;

    public CC5SceneView(AnsCC5Msg answerMsg) {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        CC5Scene.setAnswerMsg(this.answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToCC5Scene();
        });
    }
}
