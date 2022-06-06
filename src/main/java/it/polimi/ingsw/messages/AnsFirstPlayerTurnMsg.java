package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.FirstPlayerTurnView;
import it.polimi.ingsw.Client.views.GameStartedView;
import it.polimi.ingsw.Model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AnsFirstPlayerTurnMsg extends AnswerMsg{
    private String name;
    private DeckCardAssistant dca;
    private ArrayList<SchoolBoard> sb=new ArrayList<>();
    private ArrayList<IslandTiles> is=new ArrayList<>();
    private ArrayList<Player> pl= new ArrayList<>();



    public AnsFirstPlayerTurnMsg(CommandMsg parent, String name, DeckCardAssistant dca,ArrayList<SchoolBoard> sb,ArrayList<IslandTiles> is,ArrayList<Player> pl){
        super(parent);
        this.name = name;
        this.dca=dca;
        this.sb=sb;
        this.is=is;
        this.pl=pl;
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

    public ArrayList<SchoolBoard> getSb() {
        return sb;
    }

    public ArrayList<IslandTiles> getIs() {
        return is;
    }
    public ArrayList<Player> getPl() {
        return pl;
    }
}
