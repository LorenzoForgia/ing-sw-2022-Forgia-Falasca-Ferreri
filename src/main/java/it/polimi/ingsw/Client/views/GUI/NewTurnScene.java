package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.messages.AnsNewTurnMsg;
import it.polimi.ingsw.messages.NewOrderMsg;
import javafx.event.ActionEvent;

public class NewTurnScene {
    private static AnsNewTurnMsg ansNewTurnMsg;

    public static void setAnsNewTurnMsg(AnsNewTurnMsg ansNewTurnMsg) {
        NewTurnScene.ansNewTurnMsg = ansNewTurnMsg;
    }

    public void okClicked(ActionEvent event){
        NewOrderMsg newOrderMsg= new NewOrderMsg();
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(newOrderMsg);
        JavaFXMain.getCurrentApplication().switchToWaitingScene();
    }
}
