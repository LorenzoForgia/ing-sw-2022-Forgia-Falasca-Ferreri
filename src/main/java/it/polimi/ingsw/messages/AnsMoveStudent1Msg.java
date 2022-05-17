package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.MoveStudent2View;

public class AnsMoveStudent1Msg extends AnswerMsg{
    private String name;


    public AnsMoveStudent1Msg(CommandMsg parent, String name){
        super(parent);
        this.name = name;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new MoveStudent2View(this));
    }
    public String GetPlayer(){
        return name;
    }
}

