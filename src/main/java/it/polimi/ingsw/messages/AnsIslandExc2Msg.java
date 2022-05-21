package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.IslandExc1View;
import it.polimi.ingsw.Client.views.IslandExc2View;

public class AnsIslandExc2Msg extends AnswerMsg{
    private String name;

    public AnsIslandExc2Msg(CommandMsg parent, String name){
        super(parent);
        this.name = name;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new IslandExc2View(this));
    }
    public String GetPlayer(){
        return name;
    }
}
