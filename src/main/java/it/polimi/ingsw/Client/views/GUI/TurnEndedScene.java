package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.messages.AnsCloudMsg;
import it.polimi.ingsw.messages.CheckTurnEndedMsg;
import javafx.event.ActionEvent;

public class TurnEndedScene {
    private static AnsCloudMsg ansCloudMsg;

    public static void setAnsCloudMsg(AnsCloudMsg ansCloudMsg) {
        TurnEndedScene.ansCloudMsg = ansCloudMsg;
    }
    public void okClicked(ActionEvent event){
        CheckTurnEndedMsg checkTurnEndedMsg= new CheckTurnEndedMsg();
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(checkTurnEndedMsg);
        JavaFXMain.getCurrentApplication().switchToWaitingScene();
    }
}
