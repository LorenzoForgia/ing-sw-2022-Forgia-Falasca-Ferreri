package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class TurnDecidedMsg extends CommandMsg{
    private String c;
    public TurnDecidedMsg(String c){
        this.c =c;
    }
    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException
    {
        /*AnsTurnDecidedMsg answerMsg;*/
        GameController game = clientHandler.getGame();
        synchronized (game){
            /*game.getPlayAssCard().GetAssCard();*/
        }
    }
}
