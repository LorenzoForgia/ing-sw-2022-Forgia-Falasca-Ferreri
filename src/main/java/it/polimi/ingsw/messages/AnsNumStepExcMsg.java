package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.ColorExc3View;
import it.polimi.ingsw.Client.views.NumStepExcView;

public class AnsNumStepExcMsg extends AnswerMsg{
    private String name;

    public AnsNumStepExcMsg(CommandMsg parent, String name){
        super(parent);
        this.name = name;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new NumStepExcView(this));
    }
    public String GetPlayer(){
        return name;
    }
}
