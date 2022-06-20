package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;
import it.polimi.ingsw.messages.AnsCloudMsg;
import it.polimi.ingsw.messages.CheckTurnEndedMsg;
import javafx.event.ActionEvent;

public class TurnEndedScene extends View {
    private static AnsCloudMsg ansCloudMsg;

    public TurnEndedScene(AnsCloudMsg ansCloudMsg) {
        TurnEndedScene.ansCloudMsg = ansCloudMsg;
    }
    @Override
    public void run() {
    }
    public void okClicked(ActionEvent event){
        CheckTurnEndedMsg checkTurnEndedMsg= new CheckTurnEndedMsg();
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(checkTurnEndedMsg);
        JavaFXMain.getCurrentApplication().switchToWaitingScene();
    }
}
