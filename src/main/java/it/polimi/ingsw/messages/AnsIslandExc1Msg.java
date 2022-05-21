package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.IslandExc1View;

public class AnsIslandExc1Msg extends AnswerMsg{
    private String name;

    public AnsIslandExc1Msg(CommandMsg parent, String name){
        super(parent);
        this.name = name;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new IslandExc1View(this));
    }
    public String GetPlayer(){
        return name;
    }
}
