package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.*;
import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Server.*;

import java.io.IOException;

public class GetStudentAndLocation extends CommandMsg {
    private Location location;
    private Color c;
    private Player p;

    public GetStudentAndLocation(Location location, Color c, Player p) {
        this.location = location;
        this.c = c;
        this.p = p;
    }

    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException
    {
        AnswIfAllowed answerMsg;
        GameController game = clientHandler.getGame();

        try{
            game.CheckColor(c, p);
            answerMsg = new AnswIfAllowed(this, AnswIfAllowed.Status.VALID);
        }catch(IllegalMoveException e){

            answerMsg = new AnswIfAllowed(this, AnswIfAllowed.Status.INVALID);
        }

        clientHandler.sendAnswerMessage(answerMsg);
    }

    public Location getLocation() {
        return location;
    }

    public Color getC() {
        return c;
    }
}
