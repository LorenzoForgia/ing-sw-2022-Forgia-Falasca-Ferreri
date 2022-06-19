package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsAskCAMsg;
import it.polimi.ingsw.messages.AnsColorExc1Msg;
import javafx.application.Platform;

public class ColorExc1SceneView extends View {
    private AnsColorExc1Msg answerMsg;
    public ColorExc1SceneView(AnsColorExc1Msg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        //ColorExc1Scene.setAnswerMsg(this.answerMsg);
        Platform.runLater(() -> {
           // JavaFXMain.getCurrentApplication().switchToColorExc1Scene(); switch da implementare
        });
    }
}
