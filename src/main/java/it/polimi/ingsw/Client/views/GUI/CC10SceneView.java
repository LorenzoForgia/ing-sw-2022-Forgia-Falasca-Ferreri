package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.*;
import javafx.application.Platform;

public class CC10SceneView extends View {
    private AnsCC10Msg answerMsg;

    public CC10SceneView(AnsCC10Msg answerMsg) {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        CC10Scene.setAnswerMsg(this.answerMsg);
        CC10Scene.setChosenNumber(false);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToCC9Scene();
        });
    }
}
