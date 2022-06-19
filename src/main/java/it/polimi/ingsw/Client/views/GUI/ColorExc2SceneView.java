package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsColorExc1Msg;
import it.polimi.ingsw.messages.AnsColorExc2Msg;
import javafx.application.Platform;

public class ColorExc2SceneView extends View {
    private AnsColorExc2Msg answerMsg;
    public ColorExc2SceneView(AnsColorExc2Msg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        //ColorExc2Scene.setAnswerMsg(this.answerMsg);
        Platform.runLater(() -> {
            // JavaFXMain.getCurrentApplication().switchToColorExc2Scene(); switch da implementare
        });
    }
}
