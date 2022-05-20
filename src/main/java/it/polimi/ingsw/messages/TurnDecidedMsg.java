package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Exception.CardAssistantNotAvailableException;
import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.Model.GeneralBoard;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;
import java.util.ArrayList;

public class TurnDecidedMsg extends CommandMsg{
    private CardAssistant c;
    public TurnDecidedMsg(CardAssistant c){
        this.c =c;
    }
    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException
    {
        AnsTurnDecidedMsg answerMsg;
        GameController game = clientHandler.getGame();
        ArrayList<String> nickname = new ArrayList<String>();

        synchronized (game){
            Boolean flag=game.CheckIfAllPlayedCardAssistant();
            try{
                while(!clientHandler.getNickname().equals(game.getChoosenPlayer().GetPlayerTurn().getNickName())) {
                    game.wait();
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            try{
                game.CardAssistantInDeck(c, game.getChoosenPlayer().GetPlayerTurn());
                game.notifyAll();
                while(!flag){
                    try{
                        System.out.println("TURNDCDMSG mi addormento"+clientHandler.getNickname());
                        game.wait();
                        System.out.println("TURNDCDMSG mi sveglio"+clientHandler.getNickname());
                        flag=game.CheckIfAllPlayedCardAssistant();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < game.getChoosenPlayer().getOrderPlayers().size(); i++) {
                    nickname.add(game.getChoosenPlayer().getOrderPlayers().get(i).getNickName());
                }
                answerMsg = new AnsTurnDecidedMsg(this, nickname);
                clientHandler.sendAnswerMessage(answerMsg);
                game.notifyAll();
            }catch(CardAssistantNotAvailableException e){
                String name= game.getChoosenPlayer().GetPlayerTurn().getNickName();
                AnsFirstPlayerTurnMsg answMsg = new AnsFirstPlayerTurnMsg(this, name);
                clientHandler.sendAnswerMessage(answMsg);
            }
        }
    }
}
