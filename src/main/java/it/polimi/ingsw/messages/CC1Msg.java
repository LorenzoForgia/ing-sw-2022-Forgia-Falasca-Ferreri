package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class CC1Msg extends CommandMsg{
    private int isl;
    private Color stud;

    public CC1Msg(int isl, Color stud){
        this.isl= isl;
        this.stud=stud;
    }

    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException {
        GameController game = clientHandler.getGame();
        synchronized (game) {
           if(game.SetCharacterCard1(game.getCharacterCardChosen(), stud, isl)){
               game.UseEffectOfCharacterCard(game.getChoosenPlayer().GetPlayerTurn(), game.getCharacterCardChosen());
               AnsPlayAfterCCMsg answerMsg = new AnsPlayAfterCCMsg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName(), game.getGameModel().getGeneralBoard(), game.getGameModel().getPlayers(), game.getCountmodexpview());
               clientHandler.sendAnswerMessage(answerMsg);
           }else{
               AnsCC1ExcMsg ansCC1ExcMsg= new AnsCC1ExcMsg(this, game.getGameModel().getGeneralBoard(), game.getGameModel().getPlayers(), game.getCharacterCardChosen());
               clientHandler.sendAnswerMessage(ansCC1ExcMsg);
           }
        }
    }
}
