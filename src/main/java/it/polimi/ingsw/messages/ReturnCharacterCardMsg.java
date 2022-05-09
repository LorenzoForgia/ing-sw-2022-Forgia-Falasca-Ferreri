package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Exception.*;
import it.polimi.ingsw.Model.CharacterCard;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class ReturnCharacterCardMsg extends CommandMsg{
    CharacterCard c;
    Player player;

    public ReturnCharacterCardMsg(CharacterCard c, Player p){
        this.c = c;
        player = p;
    }

    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException {
        AnswIfAllowed answerMsg;
        GameController game = clientHandler.getGame();

        try{
            game.CharacterCardInTable(c);
            answerMsg = new AnswIfAllowed(this, AnswIfAllowed.Status.VALID);
        }catch(CharacterCardNotInTableException e){
            answerMsg = new AnswIfAllowed(this, AnswIfAllowed.Status.INVALID);
        }

        clientHandler.sendAnswerMessage(answerMsg);
    }

}
