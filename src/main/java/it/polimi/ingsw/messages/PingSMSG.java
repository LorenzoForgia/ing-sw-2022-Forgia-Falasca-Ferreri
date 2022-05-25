package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.CC3View;
import it.polimi.ingsw.Model.GeneralBoard;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class PingSMSG extends AnswerMsg{
    public PingSMSG(CommandMsg parent){
        super(parent);

    }

    @Override
    public void processMessage(ServerHandler serverHandler)
    {
    }

}
