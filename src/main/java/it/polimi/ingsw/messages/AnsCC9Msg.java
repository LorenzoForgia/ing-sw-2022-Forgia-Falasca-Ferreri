package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.CC3View;
import it.polimi.ingsw.Client.views.CC9View;

public class AnsCC9Msg extends AnswerMsg{
    public AnsCC9Msg(CommandMsg parent){
        super(parent);
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new CC9View(this));
    }
}
