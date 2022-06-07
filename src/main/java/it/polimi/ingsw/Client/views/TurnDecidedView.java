package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.messages.AnsTurnDecidedMsg;
import it.polimi.ingsw.messages.AskCAMsg;
import it.polimi.ingsw.messages.MoveStudent1Msg;

import java.util.Scanner;

public class TurnDecidedView extends View{
    private AnsTurnDecidedMsg answerMsg;


    public TurnDecidedView(AnsTurnDecidedMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }


    @Override
    public void run() {
        System.out.println("L'ordine dei giocatori nel round è:");
        for(int i=0; i< answerMsg.getNickname().size(); i++){
            System.out.println(answerMsg.getNickname().get(i));
        }
        System.out.println("Ha inizio la fase d'azione!");
        System.out.println("Aspetta il tuo turno per giocare");
        AskCAMsg askCAMsg= new AskCAMsg();
        getOwner().getServerHandler().sendCommandMessage(askCAMsg);
    }
}
