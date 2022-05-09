package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Exception.IllegalNickNameException;
import it.polimi.ingsw.Model.IllegalMoveException;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class Login extends CommandMsg {
    private String name;

    public Login(String name) {
        this.name = name;
    }

    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException
    {
        AnswIfAllowed answerMsg;
        GameController game = clientHandler.getGame();

        try{
            game.NickNameAvailable(name);
            answerMsg = new AnswIfAllowed(this, AnswIfAllowed.Status.VALID);
        }catch(IllegalNickNameException e){
            answerMsg = new AnswIfAllowed(this, AnswIfAllowed.Status.INVALID);
        }

        clientHandler.sendAnswerMessage(answerMsg);
    }

}
