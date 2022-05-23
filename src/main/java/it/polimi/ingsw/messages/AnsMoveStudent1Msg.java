package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.MoveStudent2View;
import it.polimi.ingsw.Client.views.PlayCC2View;
import it.polimi.ingsw.Model.GeneralBoard;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class AnsMoveStudent1Msg extends AnswerMsg{
    private String name;
    private GeneralBoard generalBoard;
    private ArrayList<Player> players= new ArrayList<Player>();
    private boolean modexp;


    public AnsMoveStudent1Msg(CommandMsg parent, String name,GeneralBoard generalBoard,ArrayList<Player> players, boolean modexp){
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
            serverHandler.getClient().transitionToView(new PlayCC2View(this));
        }else{
            serverHandler.getClient().transitionToView(new MoveStudent2View(this));
        }
    }
    public String GetPlayer(){
        return name;
    }
    public GeneralBoard GetGB(){return generalBoard;}
    public ArrayList<Player> GetPlayers(){return players;}
}

