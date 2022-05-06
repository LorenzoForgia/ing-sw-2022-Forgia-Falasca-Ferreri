package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;

public class NotifyLastRoundMsg extends AnswerMsg {
    public enum Status
    {
        INVALID,
        VALID
    }

    NotifyLastRoundMsg.Status MoveStatus;
    public NotifyLastRoundMsg(CommandMsg parent, NotifyLastRoundMsg.Status MoveStatus)
    {
        super(parent);
        this.MoveStatus = MoveStatus;
    }

    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        /*serverHandler.getClient().transitionToView(new PrintAnswerView(this));*/
    }

    public NotifyLastRoundMsg.Status getMoveStatus() {
        return MoveStatus;
    }
}
