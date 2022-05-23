package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;

public class CC11Msg extends CommandMsg{
    private Color color;

    public CC11Msg(Color color){
        this.color=color;
    }

    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException {
        GameController game = clientHandler.getGame();
        synchronized (game) {
            game.SetCharacterCard11(game.getCharacterCardChosen(), color);
            game.UseEffectOfCharacterCard(game.getChoosenPlayer().GetPlayerTurn(), game.getCharacterCardChosen());
            game.incrementview();
            AnsPlayAfterCCMsg answerMsg = new AnsPlayAfterCCMsg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName(), game.getGameModel().getGeneralBoard(), game.getGameModel().getPlayers(), game.getCountmodexpview());
            clientHandler.sendAnswerMessage(answerMsg);
        }
    }
}
