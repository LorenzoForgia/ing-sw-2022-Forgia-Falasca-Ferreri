package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.views.CannotPlayCCView;
import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class CannotPlayCCMsg extends CommandMsg{
    public CannotPlayCCMsg(){}
    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException {

        GameController game = clientHandler.getGame();

        synchronized (game){
            AnsMoveS1AfterNotCCMsg ansMoveS1AfterNotCCMsg= new AnsMoveS1AfterNotCCMsg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName(), game.getGameModel().getGeneralBoard(), game.getGameModel().getPlayers());
            clientHandler.sendAnswerMessage(ansMoveS1AfterNotCCMsg);
        }
    }
}
