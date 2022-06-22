package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.*;
import javafx.application.Platform;

public class CC7SceneView extends View {
    private AnsCC7Msg answerMsg;

    public CC7SceneView(AnsCC7Msg answerMsg) {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        CC7Scene.setAnswerMsg(this.answerMsg);
        CC7Scene.setChoseNumber(false);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToCC7Scene();
        });
    }
}
