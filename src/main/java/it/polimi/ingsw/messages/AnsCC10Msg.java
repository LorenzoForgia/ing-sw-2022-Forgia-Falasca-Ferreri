package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.CC10View;
import it.polimi.ingsw.Client.views.CC3View;

public class AnsCC10Msg extends AnswerMsg{
    public AnsCC10Msg(CommandMsg parent){
        super(parent);
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new CC10View(this));
    }
}
