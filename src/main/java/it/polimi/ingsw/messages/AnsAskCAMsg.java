package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;

import it.polimi.ingsw.Client.views.MoveStudent1View;
import it.polimi.ingsw.Client.views.PlayCCView;
import it.polimi.ingsw.Model.GeneralBoard;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;


public class AnsAskCAMsg extends AnswerMsg{
    private String name;
    private GeneralBoard generalBoard;
    private ArrayList<Player> players= new ArrayList<Player>();
    private boolean modexp;

    public AnsAskCAMsg(CommandMsg parent, String name, GeneralBoard generalBoard,ArrayList<Player> players, boolean modexp ){
        super(parent);
        this.name = name;
        this.generalBoard= generalBoard;
        this.players=players;
        this.modexp=modexp;
    }

    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        if(modexp){
            serverHandler.getClient().transitionToView(new PlayCCView(this));
        }else{
            serverHandler.getClient().transitionToView(new MoveStudent1View(this));
        }
    }
    public String GetPlayer(){
        return name;
    }
    public GeneralBoard GetGB(){return generalBoard;}
    public ArrayList<Player> GetPlayers(){return players;}
    public boolean GetIsModexp(){return modexp;}
}
