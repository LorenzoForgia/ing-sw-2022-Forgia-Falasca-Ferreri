package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.messages.AnsAskCAMsg;
import it.polimi.ingsw.messages.AnsEndGameMsg;

public class EndGameView extends View{
    AnsEndGameMsg answerMsg;
    public EndGameView(AnsEndGameMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }
    @Override
    public void run() {
        System.out.println("Il gioco è terminato! I vincitori sono!");
        System.out.println("Rullo di tamburi.......................");
        System.out.println(answerMsg.getWinner());
    }
}
