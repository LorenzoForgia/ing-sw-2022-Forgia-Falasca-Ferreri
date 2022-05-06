package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

/**
 * A message sent from the client containing the assistant card.
 */
/*public class PlayAssCardMsg extends CommandMsg {
    CardAssistant a;
    Player p;*/

    /**
     * Create a new message with the assistant card.
     */

    /*public PlayAssCardMsg(CardAssistant a, Player p) {
        this.a = a;
        this.p = p;
    }*/

    /*@Override
    public void processMessage(ClientHandler clientHandler) throws IOException {
        GameController g = ClientHandler.GetGame();
        CheckCorrectOrNotMsg AnswerMsg;
        if (g.CheckAssCard()) {
            AnswerMsg = new CheckCorrectOrNotMsg(this, CheckCorrectOrNotMsg.Status.CORRECT);
        } else {
            AnswerMsg = new CheckCorrectOrNotMsg(this, CheckCorrectOrNotMsg.Status.INCORRECT);
        }
        clientHandler.sendAnswerMessage(AnswerMsg);
    }
}*/
