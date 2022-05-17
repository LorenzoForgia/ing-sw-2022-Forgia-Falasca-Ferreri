package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.NumStepExcView;

public class AnsNumStepMNMsg extends AnswerMsg{
    private String name;

    public AnsNumStepMNMsg(CommandMsg parent, String name){
        super(parent);
        this.name = name;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        /*serverHandler.getClient().transitionToView(new NumStepExcView(this));*/
    }
    public String GetPlayer(){
        return name;
    }
}
