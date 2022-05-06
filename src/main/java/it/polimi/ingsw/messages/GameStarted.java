package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Model.GeneralBoard;

import java.util.List;

public class GameStarted extends AnswerMsg{
    int idPlayer;
    List<String> otherPlayers;
    GeneralBoard gb;

    public GameStarted(CommandMsg parent, int idPlayer, List<String> otherPlayers, GeneralBoard gb) {
        super(parent);
        this.idPlayer = idPlayer;
        this.otherPlayers = otherPlayers;
        this.gb = gb;
    }

    @Override
    public void processMessage(ServerHandler serverHandler)
    {

    }


}
