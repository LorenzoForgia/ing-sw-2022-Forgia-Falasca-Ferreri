package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.NotEnoughCoinsExcView;
import it.polimi.ingsw.Client.views.PlayerAlrUsedCCExcView;

public class AnsNotEnoughCoinsExcMsg extends AnswerMsg{
    public AnsNotEnoughCoinsExcMsg(CommandMsg parent){
        super(parent);
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new NotEnoughCoinsExcView(this));
    }
}
