package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.CCNotInTableExcView;
import it.polimi.ingsw.Client.views.ColorExc1View;

public class AnsCCNotInTableExcMsg extends AnswerMsg{

    public AnsCCNotInTableExcMsg(CommandMsg parent){
        super(parent);
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new CCNotInTableExcView(this));
    }
}
