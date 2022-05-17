package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;

import it.polimi.ingsw.Client.views.MoveStudent1View;


public class AnsAskCAMsg extends AnswerMsg{
    private String name;

    public AnsAskCAMsg(CommandMsg parent, String name){
        super(parent);
        this.name = name;
    }

    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new MoveStudent1View(this));
    }
    public String GetPlayer(){
        return name;
    }
}
