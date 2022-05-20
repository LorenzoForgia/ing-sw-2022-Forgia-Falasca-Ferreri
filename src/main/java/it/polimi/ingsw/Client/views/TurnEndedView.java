package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.messages.AnsCloudMsg;
import it.polimi.ingsw.messages.AnsTurnDecidedMsg;
import it.polimi.ingsw.messages.CheckTurnEndedMsg;

public class TurnEndedView extends View{
    private AnsCloudMsg answerMsg;


    public TurnEndedView(AnsCloudMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }


    @Override
    public void run() {
        System.out.println("Il tuo turno è terminato!");
        System.out.println("Aspetta che gli altri giocatori finiscano il loro turno");
        CheckTurnEndedMsg checkTurnEndedMsg= new CheckTurnEndedMsg();
        getOwner().getServerHandler().sendCommandMessage(checkTurnEndedMsg);
    }
}
