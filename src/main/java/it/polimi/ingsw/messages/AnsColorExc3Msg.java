package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.ColorExc3View;

public class AnsColorExc3Msg extends AnswerMsg{
    private String name;

    public AnsColorExc3Msg(CommandMsg parent, String name){
        super(parent);
        this.name = name;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new ColorExc3View(this));
    }
    public String GetPlayer(){
        return name;
    }
}
