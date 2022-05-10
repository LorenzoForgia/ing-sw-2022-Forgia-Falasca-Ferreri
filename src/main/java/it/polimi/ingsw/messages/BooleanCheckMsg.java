package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.GameCreatedView;

public class BooleanCheckMsg extends AnswerMsg{
    BooleanCheckMsg.Status MoveStatus;

    public enum Status
    {
        OK,
        KO
    }


    public BooleanCheckMsg(CommandMsg parent, BooleanCheckMsg.Status MoveStatus)
    {
        super(parent);
        this.MoveStatus = MoveStatus;
    }

    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new GameCreatedView(this));
    }
    public BooleanCheckMsg.Status getMoveStatus() {
        return MoveStatus;
    }
}
