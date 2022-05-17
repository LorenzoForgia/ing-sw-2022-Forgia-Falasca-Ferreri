package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.ColorExc2View;
import it.polimi.ingsw.Client.views.TurnEndedView;

public class AnsCloudMsg extends AnswerMsg{
    private String name;

    public AnsCloudMsg(CommandMsg parent, String name){
        super(parent);
        this.name = name;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new TurnEndedView(this));
    }
    public String GetPlayer(){
        return name;
    }
}
