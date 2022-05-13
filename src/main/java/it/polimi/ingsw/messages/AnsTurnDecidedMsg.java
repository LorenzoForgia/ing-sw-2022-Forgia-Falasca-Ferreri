package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;

public class AnsTurnDecidedMsg extends AnswerMsg{

    public AnsTurnDecidedMsg(CommandMsg parent){
        super(parent);
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {}
}
