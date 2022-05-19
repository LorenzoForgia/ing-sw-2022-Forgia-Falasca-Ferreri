package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.messages.AnsFirstPlayerTurnMsg;
import it.polimi.ingsw.messages.AnsGameStartedMsg;
import it.polimi.ingsw.messages.FirstPlayerTurnMsg;
import it.polimi.ingsw.messages.TurnDecidedMsg;

import java.util.Scanner;

public class FirstPlayerTurnView extends View{
    private AnsFirstPlayerTurnMsg answerMsg;


    public FirstPlayerTurnView(AnsFirstPlayerTurnMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }


    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(answerMsg.GetPlayer() + " Gioca una carta assistente!");
        CardAssistant c = CardAssistant.valueOf(scanner.nextLine());
        TurnDecidedMsg turnDecidedMsg= new TurnDecidedMsg(c);
        getOwner().getServerHandler().sendCommandMessage(turnDecidedMsg);
    }
}