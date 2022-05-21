package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.messages.AnsNewOrderMsg;
import it.polimi.ingsw.messages.AnsNewTurnMsg;
import it.polimi.ingsw.messages.TurnDecidedMsg;

import java.util.Scanner;

public class PlayCardNewTurnView extends View{
    AnsNewOrderMsg answerMsg;
    public PlayCardNewTurnView(AnsNewOrderMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        Scanner scanner= new Scanner(System.in);
        System.out.println(answerMsg.GetPlayer() + " gioca una carta assistente!");
        CardAssistant c = CardAssistant.valueOf(scanner.nextLine());
        TurnDecidedMsg turnDecidedMsg= new TurnDecidedMsg(c);
        getOwner().getServerHandler().sendCommandMessage(turnDecidedMsg);
    }
}
