package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Model.CloudTiles;
import it.polimi.ingsw.Model.IllegalMoveException;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class ChooseCloud extends CommandMsg{

    CloudTiles ct;

    public ChooseCloud(CloudTiles ct) {
        this.ct = ct;
    }

    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException
    {
        AnswIfAllowed answerMsg;
        GameController game = clientHandler.getGame();

        try{
            game.CheckCloud(ct);
            answerMsg = new AnswIfAllowed(this, AnswIfAllowed.Status.VALID);
        }catch(IllegalMoveException e){
            answerMsg = new AnswIfAllowed(this, AnswIfAllowed.Status.INVALID);
        }

        clientHandler.sendAnswerMessage(answerMsg);
    }

}
