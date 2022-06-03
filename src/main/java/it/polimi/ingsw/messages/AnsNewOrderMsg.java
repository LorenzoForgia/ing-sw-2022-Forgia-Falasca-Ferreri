package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.ColorExc2View;
import it.polimi.ingsw.Client.views.PlayCardNewTurnView;
import it.polimi.ingsw.Model.DeckCardAssistant;

public class AnsNewOrderMsg extends AnswerMsg{
    private String name;
    private DeckCardAssistant dca;

    public AnsNewOrderMsg(CommandMsg parent, String name,DeckCardAssistant dca){
        super(parent);
        this.name = name;
        this.dca=dca;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        serverHandler.getClient().transitionToView(new PlayCardNewTurnView(this));
    }
    public String GetPlayer(){
        return name;
    }
    public DeckCardAssistant getDca() {
        return dca;
    }
}
