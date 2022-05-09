package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Exception.CloudEmptyException;
import it.polimi.ingsw.Model.CloudTiles;
import it.polimi.ingsw.Model.IllegalMoveException;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class ChooseCloud extends CommandMsg{

    CloudTiles ct;
    Player player;

    public ChooseCloud(CloudTiles ct, Player p) {
        this.ct = ct;
        player = p;
    }

    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException
    {
        AnswIfAllowed answerMsg;
        GameController game = clientHandler.getGame();

        try{
            game.CheckCloud(ct, player);
            answerMsg = new AnswIfAllowed(this, AnswIfAllowed.Status.VALID);
        }catch(CloudEmptyException e){
            answerMsg = new AnswIfAllowed(this, AnswIfAllowed.Status.INVALID);
        }

        clientHandler.sendAnswerMessage(answerMsg);
    }

}
