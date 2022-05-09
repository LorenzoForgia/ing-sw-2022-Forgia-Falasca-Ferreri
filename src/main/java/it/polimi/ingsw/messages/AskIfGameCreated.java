package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Model.IllegalMoveException;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class AskIfGameCreated extends CommandMsg{


    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException
    {
        AnsGameCreatedMsg answerMsg;
        GameController game = clientHandler.getGame();


            if(game.getGameModel().getPlayers().size()==1){
                answerMsg = new AnsGameCreatedMsg(this,AnsGameCreatedMsg.Status.VALID);
            }else {
                answerMsg = new AnsGameCreatedMsg(this, AnsGameCreatedMsg.Status.INVALID);
            }
        clientHandler.sendAnswerMessage(answerMsg);
    }

}
