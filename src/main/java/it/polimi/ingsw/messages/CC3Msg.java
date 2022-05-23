package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Model.Color;
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
            game.SetCharacterCard3(game.getCharacterCardChosen(), isl);
            game.UseEffectOfCharacterCard(game.getChoosenPlayer().GetPlayerTurn(), game.getCharacterCardChosen());
            AnsMoveStudent1AfterCCMsg answerMsg = new AnsMoveStudent1AfterCCMsg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName(), game.getGameModel().getGeneralBoard(), game.getGameModel().getPlayers());
            clientHandler.sendAnswerMessage(answerMsg);
        }
    }
}
