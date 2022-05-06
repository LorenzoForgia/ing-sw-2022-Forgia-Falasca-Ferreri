package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;

/**
 * The answer message from GuessMsg. Contains whether the guess was
 * correct or not, and the hint string if it was not correct.
 */

public class CheckCorrectOrNotMsg extends AnswerMsg{

    public enum Status
    {
        INVALID,
        INCORRECT,
        CORRECT
    }
    Status s;


    /**
     * Create a new CheckAssCardMsg.
     * @param parent The CommandMsg being answered.
     * @param s Status is correct or incorrect.
     */
    public CheckCorrectOrNotMsg(CommandMsg parent, Status s) {
        super(parent);
        this.s = s;
    }

    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        /*serverHandler.getClient().transitionToView(new PrintAnswerView(this));*/
    }
}
