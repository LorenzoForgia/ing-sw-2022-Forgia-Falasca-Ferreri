package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;

public class BooleanCheckMsg extends AnswerMsg{

    public enum Status
    {
        OK,
        KO
    }

    BooleanCheckMsg.Status MoveStatus;
    public BooleanCheckMsg(CommandMsg parent, BooleanCheckMsg.Status MoveStatus)
    {
        super(parent);
        this.MoveStatus = MoveStatus;
    }

    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        /*serverHandler.getClient().transitionToView(new PrintAnswerView(this));*/
    }
}
