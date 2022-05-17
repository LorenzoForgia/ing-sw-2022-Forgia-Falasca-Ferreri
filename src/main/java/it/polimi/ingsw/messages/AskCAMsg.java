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
        GeneralBoard generalBoard;
        synchronized (game) {
            Boolean flag = game.CheckIfAllPlayedCardAssistant();
            try {
                while (!clientHandler.getNickname().equals(game.getChoosenPlayer().GetPlayerTurn().getNickName())) {
                    System.out.println("dormo " + clientHandler.getNickname());
                    game.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            nickname= game.getChoosenPlayer().GetPlayerTurn().getNickName();
            generalBoard=game.getGameModel().getGeneralBoard();
            answerMsg = new AnsAskCAMsg(this, nickname, generalBoard, game.getGameModel().getPlayers());
            clientHandler.sendAnswerMessage(answerMsg);
        }
    }
}
