package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.CC1View;
import it.polimi.ingsw.Client.views.NotEnoughCoinsExcView;

public class AnsCC1Msg extends AnswerMsg{
    public AnsCC1Msg(CommandMsg parent){
        super(parent);
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new CC1View(this));
    }
}
