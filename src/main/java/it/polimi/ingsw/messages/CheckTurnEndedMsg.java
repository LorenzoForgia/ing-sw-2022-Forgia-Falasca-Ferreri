package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class CheckTurnEndedMsg extends CommandMsg{
    public CheckTurnEndedMsg(){}
    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException {

        GameController game = clientHandler.getGame();
        game.setFlagturn(false);

        synchronized (game) {
            game.notifyAll();


            try {
                while(!game.isFlagturn() && !game.getChoosenPlayer().EndOfAllTurn() && !game.getGameEndState().isFlagImmediately()){
                    game.wait();
                }
            }catch (InterruptedException e) {
                    e.printStackTrace();
            }
            if(game.getChoosenPlayer().EndOfAllTurn()){
                game.setFlagturn(true);
            }
            game.notifyAll();
            if(game.getGameEndState().isFlagNotImmediately() || game.getGameEndState().isFlagImmediately()){
                AnsEndGameMsg ansEndGameMsg= new AnsEndGameMsg(this, game.showWinner());
                clientHandler.sendAnswerMessage(ansEndGameMsg);
            }else{
                game.ResetTheTurnForNewRoundWhenAllPlayed();
                AnsNewTurnMsg ansNewTurnMsg= new AnsNewTurnMsg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName());
                clientHandler.sendAnswerMessage(ansNewTurnMsg);
            }
        }
    }
}
