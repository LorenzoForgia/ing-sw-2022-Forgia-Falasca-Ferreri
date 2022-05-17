package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;

import it.polimi.ingsw.Client.views.MoveStudent1View;
import it.polimi.ingsw.Model.GeneralBoard;


public class AnsAskCAMsg extends AnswerMsg{
    private String name;
    private GeneralBoard generalBoard;

    public AnsAskCAMsg(CommandMsg parent, String name, GeneralBoard generalBoard){
        super(parent);
        this.name = name;
        this.generalBoard= generalBoard;
    }

    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new MoveStudent1View(this));
    }
    public String GetPlayer(){
        return name;
    }
    public GeneralBoard GetGB(){return generalBoard;}
}
