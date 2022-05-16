package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.ColorExc2View;
import it.polimi.ingsw.Client.views.ColorExcView;

public class AnsColorExc2Msg extends AnswerMsg{
    private String name;

    public AnsColorExc2Msg(CommandMsg parent, String name){
        super(parent);
        this.name = name;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new ColorExc2View(this));
    }
    public String GetPlayer(){
        return name;
    }
}
