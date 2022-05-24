package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class CC3Msg extends CommandMsg{
    private int isl;

    public CC3Msg(int isl){
        this.isl= isl;
    }

    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException {
        GameController game = clientHandler.getGame();
        synchronized (game) {

            if(game.SetCharacterCard3(game.getCharacterCardChosen(), isl)){
                game.UseEffectOfCharacterCard(game.getChoosenPlayer().GetPlayerTurn(), game.getCharacterCardChosen());
                AnsPlayAfterCCMsg answerMsg = new AnsPlayAfterCCMsg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName(), game.getGameModel().getGeneralBoard(), game.getGameModel().getPlayers(), game.getCountmodexpview());
                clientHandler.sendAnswerMessage(answerMsg);
            }else{
                AnsCC3ExcMsg ansCC3ExcMsg= new AnsCC3ExcMsg(this, game.getGameModel().getGeneralBoard(), game.getGameModel().getPlayers());
                clientHandler.sendAnswerMessage(ansCC3ExcMsg);
            }
        }
    }
}
