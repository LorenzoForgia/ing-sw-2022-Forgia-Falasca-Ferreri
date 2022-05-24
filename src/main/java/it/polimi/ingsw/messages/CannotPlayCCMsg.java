package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class CannotPlayCCMsg extends CommandMsg{
    public CannotPlayCCMsg(){}
    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException {

        GameController game = clientHandler.getGame();

        synchronized (game){
            AnsPlayAfterNotCCMsg ansMoveS1AfterNotCCMsg= new AnsPlayAfterNotCCMsg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName(), game.getGameModel().getGeneralBoard(), game.getGameModel().getPlayers(), game.getCountmodexpview());
            clientHandler.sendAnswerMessage(ansMoveS1AfterNotCCMsg);
        }
    }
}
