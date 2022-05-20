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
            System.out.println("risveglio tutti");
            try {
                while(!game.getChoosenPlayer().EndOfAllTurn()){
                    System.out.println("mi addormento");
                    game.wait();
                }
            }catch (InterruptedException e) {
                    e.printStackTrace();
            }
            game.notifyAll();
            System.out.println("risveglio ancora tutti");
            if(game.getGameEndState().isFlagNotImmediately()){
                AnsEndGameMsg ansEndGameMsg= new AnsEndGameMsg(this, game.showWinner());
                clientHandler.sendAnswerMessage(ansEndGameMsg);
            }else{
                game.ResetTheTurnForNewRoundWhenAllPlayed();
                System.out.println("sono qui dentro");
                AnsNewTurnMsg ansNewTurnMsg= new AnsNewTurnMsg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName());
                clientHandler.sendAnswerMessage(ansNewTurnMsg);
            }
        }
    }
}
