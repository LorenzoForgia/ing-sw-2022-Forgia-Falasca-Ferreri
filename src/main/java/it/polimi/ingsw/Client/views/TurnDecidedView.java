package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.messages.AnsGameStartedMsg;
import it.polimi.ingsw.messages.AnsTurnDecidedMsg;
import it.polimi.ingsw.messages.FirstPlayerTurnMsg;

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
        /*FirstPlayerTurnMsg firstPlayerTurnMsg = new FirstPlayerTurnMsg();
        getOwner().getServerHandler().sendCommandMessage(firstPlayerTurnMsg);*/


    }
}
