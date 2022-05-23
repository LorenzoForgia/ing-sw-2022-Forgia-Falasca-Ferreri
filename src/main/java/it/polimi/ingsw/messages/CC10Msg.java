package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;
import java.util.ArrayList;

public class CC10Msg extends CommandMsg{
    private ArrayList<Color> entrancestud=null;
    private ArrayList<Color> diningstud= null;

    public CC10Msg(ArrayList<Color> entrancestud, ArrayList<Color> diningstud){
        this.entrancestud=entrancestud;
        this.diningstud=diningstud;
    }

    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException {
        GameController game = clientHandler.getGame();
        synchronized (game) {
            game.SetCharacterCard10(game.getCharacterCardChosen(), entrancestud, diningstud, game.getChoosenPlayer().GetPlayerTurn());
            game.UseEffectOfCharacterCard(game.getChoosenPlayer().GetPlayerTurn(), game.getCharacterCardChosen());
            game.incrementview();
            AnsPlayAfterCCMsg answerMsg = new AnsPlayAfterCCMsg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName(), game.getGameModel().getGeneralBoard(), game.getGameModel().getPlayers(), game.getCountmodexpview());
            clientHandler.sendAnswerMessage(answerMsg);
        }
    }
}
