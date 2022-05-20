package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.messages.AnsNewTurnMsg;
import it.polimi.ingsw.messages.AnsNumCloudExcMsg;
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
        Scanner scanner= new Scanner(System.in);
        System.out.println(answerMsg.GetPlayer() + " ha inizio un nuovo turno!");
        System.out.println(" Gioca una carta assistente!");
        CardAssistant c = CardAssistant.valueOf(scanner.nextLine());
        TurnDecidedMsg turnDecidedMsg= new TurnDecidedMsg(c);
        getOwner().getServerHandler().sendCommandMessage(turnDecidedMsg);
    }
}
