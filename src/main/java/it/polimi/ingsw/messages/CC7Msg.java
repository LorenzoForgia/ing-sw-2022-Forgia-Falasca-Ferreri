package it.polimi.ingsw.messages;

import it.polimi.ingsw.Controller.GameController;
import it.polimi.ingsw.Model.Color;
import it.polimi.ingsw.Server.ClientHandler;

import java.io.IOException;
import java.util.ArrayList;

public class CC7Msg extends CommandMsg{
    private ArrayList<Color> students= null;
    private ArrayList<Color> entrancestud=null;

    public CC7Msg(ArrayList<Color> students, ArrayList<Color> entrancestud){
        this.students=students;
        this.entrancestud=entrancestud;
    }

    @Override
    public void processMessage(ClientHandler clientHandler) throws IOException {
        GameController game = clientHandler.getGame();
        synchronized (game) {
            game.SetCharacterCard7(game.getCharacterCardChosen(), entrancestud, students, game.getChoosenPlayer().GetPlayerTurn());
            game.UseEffectOfCharacterCard(game.getChoosenPlayer().GetPlayerTurn(), game.getCharacterCardChosen());
            game.incrementview();
            AnsPlayAfterCCMsg answerMsg = new AnsPlayAfterCCMsg(this, game.getChoosenPlayer().GetPlayerTurn().getNickName(), game.getGameModel().getGeneralBoard(), game.getGameModel().getPlayers(), game.getCountmodexpview());
            clientHandler.sendAnswerMessage(answerMsg);
        }
    }
}
