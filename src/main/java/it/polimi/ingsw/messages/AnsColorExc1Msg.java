package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.ColorExc1View;

public class AnsColorExc1Msg extends AnswerMsg{
    private String name;

    public AnsColorExc1Msg(CommandMsg parent, String name){
        super(parent);
        this.name = name;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new ColorExc1View(this));
    }
    public String GetPlayer(){
        return name;
    }
}
