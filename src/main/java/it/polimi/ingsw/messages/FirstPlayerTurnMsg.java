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
        game.SetFirstPlayerTurn();
        game.getChoosenPlayer().ChooseTurnPlayerForCardAssistant(game.getGameModel().getPlayers());
        synchronized (game) {
            Boolean flag = game.getChoosenPlayer().EndOfAllTurn();
            while (!flag) {
                try {
                    Player p = game.getChoosenPlayer().GetPlayerTurn();
                    answerMsg = new AnsFirstPlayerTurnMsg(this, p);
                    clientHandler.sendAnswerMessage(answerMsg);
                    game.wait();
                    flag = game.getChoosenPlayer().EndOfAllTurn();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                game.notifyAll();
            }

        }
    }
}
