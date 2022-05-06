package it.polimi.ingsw.messages;

import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class ReturnIfCharacterCardMsg extends CommandMsg{
    Boolean f;
    Player p;
    public ReturnIfCharacterCardMsg(Boolean f, Player p) {
        this.f = f;
        this.p = p;
    }
    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException {
        BooleanCheckMsg answerMsg;
        answerMsg = new BooleanCheckMsg(this, BooleanCheckMsg.Status.OK);
        clientHandler.sendAnswerMessage(answerMsg);
    }
}
