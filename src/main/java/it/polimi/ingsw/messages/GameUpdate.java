package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Model.GeneralBoard;

public class GameUpdate extends AnswerMsg{

    GeneralBoard gb;

    public GameUpdate(CommandMsg parent, GeneralBoard gb) {
        super(parent);
        this.gb = gb;
    }

    @Override
    public void processMessage(ServerHandler serverHandler)
    {

    }

    public void setGb(GeneralBoard gb) {
        this.gb = gb;
    }
}
