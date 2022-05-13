package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.FirstPlayerTurnView;
import it.polimi.ingsw.Client.views.GameStartedView;
import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class AnsFirstPlayerTurnMsg extends AnswerMsg{
    private Player p;

    public AnsFirstPlayerTurnMsg(CommandMsg parent, Player p)
    {
        super(parent);
        this.p = p;
    }

    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new FirstPlayerTurnView(this));
    }
}
