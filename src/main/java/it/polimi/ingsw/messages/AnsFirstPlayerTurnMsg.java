package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.FirstPlayerTurnView;
import it.polimi.ingsw.Client.views.GameStartedView;
import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.Model.DeckCardAssistant;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class AnsFirstPlayerTurnMsg extends AnswerMsg{
    private String name;
    private DeckCardAssistant dca;



    public AnsFirstPlayerTurnMsg(CommandMsg parent, String name, DeckCardAssistant dca){
        super(parent);
        this.name = name;
        this.dca=dca;
    }

    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new FirstPlayerTurnView(this));
    }
    public String GetPlayer(){
        return name;
    }
    public DeckCardAssistant getDca() {
        return dca;
    }
}
