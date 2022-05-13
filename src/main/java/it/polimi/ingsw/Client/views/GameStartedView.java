package it.polimi.ingsw.Client.views;

import it.polimi.ingsw.Server.ClientHandler;
import it.polimi.ingsw.messages.*;

import java.util.Scanner;

public class GameStartedView extends View{
    /** The view of the gamestarted */

  private AnsGameStartedMsg answerMsg;


   public GameStartedView(AnsGameStartedMsg answerMsg)
    {
        this.answerMsg = answerMsg;
    }


    @Override
    public void run() {
        System.out.println("Il gioco inizia:");
        System.out.println("I giocatori sono:");
        for(int i=0; i< answerMsg.getNickname().size(); i++){
            System.out.println(answerMsg.getNickname().get(i));
        }
        FirstPlayerTurnMsg firstPlayerTurnMsg = new FirstPlayerTurnMsg();
        getOwner().getServerHandler().sendCommandMessage(firstPlayerTurnMsg);


    }
}
