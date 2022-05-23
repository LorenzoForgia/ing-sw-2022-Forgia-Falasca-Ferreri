package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.CannotPlayCCView;
import it.polimi.ingsw.Client.views.ColorExc1View;

public class AnsCannotPlayCCMsg extends AnswerMsg{
    private String name;

    public AnsCannotPlayCCMsg(CommandMsg parent, String name){
        super(parent);
        this.name = name;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new CannotPlayCCView(this));
    }
    public String GetPlayer(){
        return name;
    }
}
