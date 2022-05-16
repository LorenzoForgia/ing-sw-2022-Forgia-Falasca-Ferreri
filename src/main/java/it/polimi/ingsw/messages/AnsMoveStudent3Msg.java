package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.AskforMotherNatureView;
import it.polimi.ingsw.Client.views.MoveStudent3View;

public class AnsMoveStudent3Msg extends AnswerMsg{
    private String name;

    public AnsMoveStudent3Msg(CommandMsg parent, String name){
        super(parent);
        this.name = name;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new AskforMotherNatureView(this));
    }
    public String GetPlayer(){
        return name;
    }
}
