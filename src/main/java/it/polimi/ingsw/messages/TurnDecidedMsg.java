package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Exception.CardAssistantNotAvailableException;
import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

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
        synchronized (game){
            if(!game.CheckIfAllPlayedCardAssistant()){
                try{
                    game.CardAssistantInDeck(c, game.getChoosenPlayer().getPlayersforCA().get(0));
                }catch(CardAssistantNotAvailableException e){
                    String name= game.getChoosenPlayer().getPlayersforCA().get(0).getNickName();
                    AnsFirstPlayerTurnMsg answMsg = new AnsFirstPlayerTurnMsg(this, name);
                    clientHandler.sendAnswerMessage(answMsg);
                }
                game.getPlayAssCard().GetAssCard(game.getChoosenPlayer().getPlayersforCA().get(0), c);
                game.getChoosenPlayer().getPlayersforCA().remove(0);
                answerMsg= new AnsTurnDecidedMsg(this);
            }else{



            }

        }
    }
}
