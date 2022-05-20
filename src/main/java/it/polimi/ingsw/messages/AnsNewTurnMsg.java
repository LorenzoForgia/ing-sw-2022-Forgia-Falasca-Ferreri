package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.FirstPlayerTurnView;
import it.polimi.ingsw.Client.views.NewTurnView;

public class AnsNewTurnMsg extends AnswerMsg{
    private String name;

    public AnsNewTurnMsg(CommandMsg parent, String name){
        super(parent);
        this.name = name;
    }

    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new NewTurnView(this));
    }
    public String GetPlayer(){
        return name;
    }
}
