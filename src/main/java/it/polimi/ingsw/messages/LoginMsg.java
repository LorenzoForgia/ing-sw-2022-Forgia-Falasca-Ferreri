package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Exception.IllegalNickNameException;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class LoginMsg extends CommandMsg {
    private String name;

    public LoginMsg(String name) {
        this.name = name;
    }

    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException
    {
        AnswIfAllowedMsg answerMsg;
        GameController game = clientHandler.getGame();

        try {
            game.NickNameAvailable(name);
            clientHandler.setNickname(name);
            answerMsg = new AnswIfAllowedMsg(this, AnswIfAllowedMsg.Status.VALID);
        }catch(IllegalNickNameException e){
            answerMsg = new AnswIfAllowedMsg(this, AnswIfAllowedMsg.Status.INVALID);
        }
        clientHandler.sendAnswerMessage(answerMsg);
    }

}
