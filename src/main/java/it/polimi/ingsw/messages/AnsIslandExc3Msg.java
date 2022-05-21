package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.IslandExc2View;
import it.polimi.ingsw.Client.views.IslandExc3View;

public class AnsIslandExc3Msg extends AnswerMsg{
    private String name;

    public AnsIslandExc3Msg(CommandMsg parent, String name){
        super(parent);
        this.name = name;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new IslandExc3View(this));
    }
    public String GetPlayer(){
        return name;
    }
}
