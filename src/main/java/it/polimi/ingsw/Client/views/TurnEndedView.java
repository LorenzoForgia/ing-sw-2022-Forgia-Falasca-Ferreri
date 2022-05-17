package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.messages.AnsCloudMsg;
import it.polimi.ingsw.messages.AnsTurnDecidedMsg;

public class TurnEndedView extends View{
    private AnsCloudMsg answerMsg;


    public TurnEndedView(AnsCloudMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }


    @Override
    public void run() {
        System.out.println("Il tuo turno è terminato!");
    }
}
