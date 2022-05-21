package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.ColorExc2View;
import it.polimi.ingsw.Client.views.PlayCardNewTurnView;

public class AnsNewOrderMsg extends AnswerMsg{
    private String name;

    public AnsNewOrderMsg(CommandMsg parent, String name){
        super(parent);
        this.name = name;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new PlayCardNewTurnView(this));
    }
    public String GetPlayer(){
        return name;
    }
}
