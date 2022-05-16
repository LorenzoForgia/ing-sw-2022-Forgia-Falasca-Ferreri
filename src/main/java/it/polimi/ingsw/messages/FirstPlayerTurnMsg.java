package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class FirstPlayerTurnMsg extends CommandMsg {
    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException {
        AnsFirstPlayerTurnMsg answerMsg;
        GameController game = clientHandler.getGame();
        String name;
        synchronized (game) {
            if (!game.getSetFirstTurn()) {
                game.SetFirstPlayerTurn();
                game.getChoosenPlayer().ChooseTurnPlayerForCardAssistant(game.getGameModel().getPlayers());
                game.setSetFirstTurn(true);
            }

            if(!game.getChoosenPlayer().EndOfAllTurn()) {
                name = game.getChoosenPlayer().GetPlayerTurn().getNickName();
                answerMsg = new AnsFirstPlayerTurnMsg(this, name);
                clientHandler.sendAnswerMessage(answerMsg);
            }
        }
    }
}
