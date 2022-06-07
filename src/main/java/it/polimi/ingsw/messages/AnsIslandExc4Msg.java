package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.IslandExc3View;
import it.polimi.ingsw.Client.views.IslandExc4View;

public class AnsIslandExc4Msg extends AnswerMsg{
    private String name;

    public AnsIslandExc4Msg(CommandMsg parent, String name){
        super(parent);
        this.name = name;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new IslandExc4View(this));
    }
    public String GetPlayer(){
        return name;
    }
}
