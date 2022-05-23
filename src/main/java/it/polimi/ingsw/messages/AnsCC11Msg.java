package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.CC11View;
import it.polimi.ingsw.Client.views.CC3View;

public class AnsCC11Msg extends AnswerMsg{
    public AnsCC11Msg(CommandMsg parent){
        super(parent);
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new CC11View(this));
    }
}
