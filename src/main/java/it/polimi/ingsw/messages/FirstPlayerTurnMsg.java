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
                game.setSetFirstTurn(true);
            }
            if(!game.getChoosenPlayer().EndOfAllTurn()) {
                name = game.getChoosenPlayer().GetPlayerTurn().getNickName();
                try{
                    while(!clientHandler.getNickname().equals(name)) {
                        System.out.println("FIRSTMSG mi addormento"+clientHandler.getNickname());
                        game.wait();
                        System.out.println("FIRSTMSG mi sveglio"+clientHandler.getNickname());
                        name = game.getChoosenPlayer().GetPlayerTurn().getNickName();
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                answerMsg = new AnsFirstPlayerTurnMsg(this, name);
                clientHandler.sendAnswerMessage(answerMsg);
                game.notifyAll();
            }
        }
    }
}
