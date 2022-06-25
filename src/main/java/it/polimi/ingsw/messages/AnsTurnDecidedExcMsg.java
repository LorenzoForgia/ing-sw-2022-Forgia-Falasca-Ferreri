package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.Client;
import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.FirstPlayerTurnView;
import it.polimi.ingsw.Client.views.GUI.AssistantCardExcScene;
import it.polimi.ingsw.Client.views.GUI.FirstPlayerTurnSceneView;
import it.polimi.ingsw.Client.views.TurnDecidedExcView;
import it.polimi.ingsw.Model.*;

import java.util.ArrayList;

public class AnsTurnDecidedExcMsg extends AnswerMsg{
    private String name;
    private DeckCardAssistant dca;
    private ArrayList<SchoolBoard> sb=new ArrayList<>();
    private ArrayList<IslandTiles> is=new ArrayList<>();
    private ArrayList<Player> pl= new ArrayList<>();
    private ArrayList<CardAssistant> CAplayed=new ArrayList<>();
    private int asscardgui;




    public AnsTurnDecidedExcMsg(CommandMsg parent, String name, DeckCardAssistant dca, ArrayList<SchoolBoard> sb, ArrayList<IslandTiles> is, ArrayList<Player> pl, ArrayList<CardAssistant> CAplayed, int asscardgui){
        super(parent);
        this.name = name;
        this.dca=dca;
        this.sb=sb;
        this.is=is;
        this.pl=pl;
        this.CAplayed=CAplayed;
        this.asscardgui=asscardgui;
    }

    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        if(Client.GUI){
            AssistantCardExcScene g=new AssistantCardExcScene(this);
            g.run();
        }else{
            serverHandler.getClient().transitionToView(new TurnDecidedExcView(this));
        }


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
    public ArrayList<CardAssistant> getCAplayed() {
        return CAplayed;
    }

    public int getAsscardgui() {
        return asscardgui;
    }
}
