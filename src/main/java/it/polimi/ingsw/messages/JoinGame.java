package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;

public class JoinGame extends AnswerMsg{
    int numberOfPlayer;
    boolean modExp;

    public JoinGame(CommandMsg parent, int numberOfPlayer, boolean modExp) {
        super(parent);
        this.numberOfPlayer = numberOfPlayer;
        this.modExp = modExp;
    }

    @Override
    public void processMessage(ServerHandler serverHandler)
    {

    }
}
