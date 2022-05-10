package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Exception.*;
import it.polimi.ingsw.Model.*;

import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class GetColTower extends CommandMsg {
    private ColorTower ct;
    private Player p;

    public GetColTower(ColorTower ct, Player p) {
        this.ct = ct;
        this.p = p;
    }

    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException
    {
        AnswIfAllowed answerMsg;
        GameController game = clientHandler.getGame();

        try{
            game.CheckColorOfTower(ct, p);
            answerMsg = new AnswIfAllowed(this, AnswIfAllowed.Status.VALID);
        }catch(ColorTowerNotCorrectException e){

            answerMsg = new AnswIfAllowed(this, AnswIfAllowed.Status.INVALID);
        }

        clientHandler.sendAnswerMessage(answerMsg);
    }

}
