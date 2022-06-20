package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsNumStepMNMsg;
import javafx.application.Platform;

public class ChooseCloudSceneView extends View {
    private AnsNumStepMNMsg answerMsg;

    public ChooseCloudSceneView(AnsNumStepMNMsg answerMsg) {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        ChooseCloudScene.setAnswerMsg(this.answerMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToChooseCloudScene();
        });
    }

}
