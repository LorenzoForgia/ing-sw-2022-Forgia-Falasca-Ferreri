package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.FirstPlayerTurnView;
import it.polimi.ingsw.Client.views.GameStartedView;
import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class AnsFirstPlayerTurnMsg extends AnswerMsg{
    private String name;

    public AnsFirstPlayerTurnMsg(CommandMsg parent, String name)
    {
        super(parent);
        this.name = name;
    }

    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new FirstPlayerTurnView(this));
    }
    public String GetPlayer(){
        return name;
    }
}
