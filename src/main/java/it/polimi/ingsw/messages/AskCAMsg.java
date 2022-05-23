package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Model.GeneralBoard;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;
import java.util.ArrayList;

public class AskCAMsg extends CommandMsg{
    public AskCAMsg(){}
    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException {
        AnsAskCAMsg answerMsg;
        GameController game = clientHandler.getGame();
        String nickname;
        synchronized (game) {
            Boolean flag = game.CheckIfAllPlayedCardAssistant();
            try {
                while (!clientHandler.getNickname().equals(game.getChoosenPlayer().GetPlayerTurn().getNickName()) && !game.getGameEndState().isFlagImmediately()) {
                    game.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(game.getGameEndState().isFlagImmediately()){
                AnsEndGameMsg ansEndGameMsg= new AnsEndGameMsg(this, game.showWinner());
                clientHandler.sendAnswerMessage(ansEndGameMsg);
            }else{
                nickname= game.getChoosenPlayer().GetPlayerTurn().getNickName();
                answerMsg = new AnsAskCAMsg(this, nickname, game.getGameModel().getGeneralBoard(), game.getGameModel().getPlayers(), game.getGameModel().getModExpert());
                clientHandler.sendAnswerMessage(answerMsg);
            }
        }
    }
}
