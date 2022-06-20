package it.polimi.ingsw.Client.views.GUI;

import it.polimi.ingsw.Client.views.View;

import it.polimi.ingsw.messages.AnsNewTurnMsg;
import it.polimi.ingsw.messages.NewOrderMsg;
import javafx.event.ActionEvent;

public class NewTurnScene extends View {
    private static AnsNewTurnMsg ansNewTurnMsg;

    public NewTurnScene(AnsNewTurnMsg ansNewTurnMsg) {
        NewTurnScene.ansNewTurnMsg = ansNewTurnMsg;
    }

    @Override
    public void run() {
    }
    public void okClicked(ActionEvent event){
        NewOrderMsg newOrderMsg= new NewOrderMsg();
        JavaFXMain.getCurrentApplication().getClient().getServerHandler().sendCommandMessage(newOrderMsg);
        JavaFXMain.getCurrentApplication().switchToWaitingScene();
    }
}
