package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class CheckTurnEndedMsg extends CommandMsg{
    public CheckTurnEndedMsg(){}
    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException {

        GameController game = clientHandler.getGame();

        synchronized (game) {
            game.notifyAll();
            try {
                while(!game.getChoosenPlayer().EndOfAllTurn()){
                    game.wait();
                }
            }catch (InterruptedException e) {
                    e.printStackTrace();
            }
            if(game.getGameEndState().isFlagNotImmediately()){
                AnsEndGameMsg ansEndGameMsg= new AnsEndGameMsg(this, game.showWinner());
                clientHandler.sendAnswerMessage(ansEndGameMsg);
            }else{
                game.ResetTheTurnForNewRoundWhenAllPlayed();

            }
        }
    }
}
