package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.messages.AnsNewTurnMsg;
import it.polimi.ingsw.messages.AnsNumCloudExcMsg;
import it.polimi.ingsw.messages.NewOrderMsg;
import it.polimi.ingsw.messages.TurnDecidedMsg;

import java.util.Scanner;

public class NewTurnView extends View{
    AnsNewTurnMsg answerMsg;
    public NewTurnView(AnsNewTurnMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        System.out.println(answerMsg.GetPlayer() + " ha inizio un nuovo turno!");
        System.out.println(" Aspetta il tuo turno per giocare la carta assistente");
        NewOrderMsg newOrderMsg= new NewOrderMsg();
        getOwner().getServerHandler().sendCommandMessage(newOrderMsg);
    }
}
