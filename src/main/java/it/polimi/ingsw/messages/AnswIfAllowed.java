package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;

public class AnswIfAllowed extends AnswerMsg {

    public enum Status
    {
        INVALID,
        VALID
    }

    Status MoveStatus;
    public AnswIfAllowed(CommandMsg parent, Status MoveStatus)
    {
        super(parent);
        this.MoveStatus = MoveStatus;

    }

    @Override
    public void processMessage(ServerHandler serverHandler)
    {

    }

    public Status getMoveStatus() {
        return MoveStatus;
    }
}
