package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsNewOrderMsg;
import javafx.application.Platform;

public class AssistantCardSceneNewTurnView extends View {
    private AnsNewOrderMsg ansNewOrderMsg;

    public AssistantCardSceneNewTurnView(AnsNewOrderMsg ansNewOrderMsg) {
        this.ansNewOrderMsg = ansNewOrderMsg;
    }
    @Override
    public void run() {
        AssistantCardSceneNewTurn.setAnswerMsg(this.ansNewOrderMsg);
        Platform.runLater(() -> {
            JavaFXMain.getCurrentApplication().switchToAssistantCardSceneNewTurn();

        });

    }
}
