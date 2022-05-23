package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.CC12View;
import it.polimi.ingsw.Client.views.CC3View;

public class AnsCC12Msg extends AnswerMsg{
    public AnsCC12Msg(CommandMsg parent){
        super(parent);
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new CC12View(this));
    }
}
