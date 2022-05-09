package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Model.IllegalMoveException;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class AskIfGameCreated extends CommandMsg{


    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException
    {
        AnswIfAllowed answerMsg;
        GameController game = clientHandler.getGame();


            if(game==null){
                answerMsg = new AnswIfAllowed(this,AnswIfAllowed.Status.VALID);
            }else {
                answerMsg = new AnswIfAllowed(this, AnswIfAllowed.Status.INVALID);
            }
        clientHandler.sendAnswerMessage(answerMsg);
    }

}
