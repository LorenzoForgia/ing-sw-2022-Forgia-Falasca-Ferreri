package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.ColorExcView;
import it.polimi.ingsw.Client.views.MoveStudent2View;

public class AnsColorExcMsg extends AnswerMsg{
    private String name;

    public AnsColorExcMsg(CommandMsg parent, String name){
        super(parent);
        this.name = name;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new ColorExcView(this));
    }
    public String GetPlayer(){
        return name;
    }
}
