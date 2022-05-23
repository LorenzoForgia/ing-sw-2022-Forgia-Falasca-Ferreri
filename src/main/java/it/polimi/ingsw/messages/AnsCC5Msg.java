package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.CC3View;
import it.polimi.ingsw.Client.views.CC5View;

public class AnsCC5Msg extends AnswerMsg{
    public AnsCC5Msg(CommandMsg parent){
        super(parent);
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new CC5View(this));
    }
}
