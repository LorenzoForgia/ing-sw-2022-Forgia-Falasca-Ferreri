package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Exception.CardAssistantNotInDeckException;
import it.polimi.ingsw.Exception.ColorNoInEntranceException;
import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

/**
 * A message sent from the client containing the assistant card.
 */
public class PlayAssCardMsg extends CommandMsg {
    CardAssistant a;
    Player player;

    /**
     * Create a new message with the assistant card.
     */

    public PlayAssCardMsg(CardAssistant a, Player p) {
        this.a = a;
        player = p;
    }

    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException {
        AnswIfAllowed answerMsg;
        GameController game = clientHandler.getGame();

        try{
            game.CardAssistantInDeck(a,player);
            answerMsg = new AnswIfAllowed(this, AnswIfAllowed.Status.VALID);
        }catch(CardAssistantNotInDeckException e){
            answerMsg = new AnswIfAllowed(this, AnswIfAllowed.Status.INVALID);
        }

        clientHandler.sendAnswerMessage(answerMsg);
    }

    public CardAssistant getA() {
        return a;
    }
}



