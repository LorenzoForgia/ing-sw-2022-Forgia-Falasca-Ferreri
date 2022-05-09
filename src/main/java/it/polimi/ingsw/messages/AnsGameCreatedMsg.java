package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.PrintAnswerView;

public class AnsGameCreatedMsg extends AnswerMsg{
    public enum Status
    {
        INVALID,
        VALID
    }

    AnswIfAllowed.Status MoveStatus;
    public AnsGameCreatedMsg(CommandMsg parent, AnswIfAllowed.Status MoveStatus)
    {
        super(parent);
        this.MoveStatus = MoveStatus;

    }

    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        /*serverHandler.getClient().transitionToView();*/
    }

    public AnswIfAllowed.Status getMoveStatus() {
        return MoveStatus;
    }
}


