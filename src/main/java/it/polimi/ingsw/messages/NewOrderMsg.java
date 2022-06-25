package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class NewOrderMsg extends CommandMsg{
    public NewOrderMsg(){}
    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException {
        AnsNewOrderMsg answerMsg;
        GameController game = clientHandler.getGame();
        String nickname;
        synchronized (game) {
            try {
                while (!clientHandler.getNickname().equals(game.getChoosenPlayer().GetPlayerTurn().getNickName())) {
                    game.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            nickname= game.getChoosenPlayer().GetPlayerTurn().getNickName();
            game.setAsscardgui(1);
            answerMsg = new AnsNewOrderMsg(this, nickname,game.getChoosenPlayer().GetPlayerTurn().getMyDeck(),game.getGameModel().getGeneralBoard().getSchoolBoard(),game.getGameModel().getGeneralBoard().GetIslands(),game.getGameModel().getPlayers(),game.getPlayAssCard().GetAssCardPlayed());
            clientHandler.sendAnswerMessage(answerMsg);
            game.notifyAll();
        }
    }
}
