package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.CC3View;
import it.polimi.ingsw.Client.views.CC7View;

public class AnsCC7Msg extends AnswerMsg{
    public AnsCC7Msg(CommandMsg parent){
        super(parent);
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new CC7View(this));
    }
}
