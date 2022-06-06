package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.*;
import it.polimi.ingsw.Model.GeneralBoard;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class AnsPlayAfterCCMsg extends AnswerMsg{
    private String name;
    private GeneralBoard generalBoard;
    private ArrayList<Player> players= new ArrayList<Player>();
    private int countmodexpview;


    public AnsPlayAfterCCMsg(CommandMsg parent, String name, GeneralBoard generalBoard, ArrayList<Player> players, int countmodexpview ){
        super(parent);
        this.name = name;
        this.generalBoard= generalBoard;
        this.players=players;
        this.countmodexpview= countmodexpview;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        if(countmodexpview==1){
            serverHandler.getClient().transitionToView(new MoveStudent1AfterCCView(this));
        }else if(countmodexpview==2){
            serverHandler.getClient().transitionToView(new MoveStudent2AfterCCView(this));
        }else if(countmodexpview==3){
            serverHandler.getClient().transitionToView(new MoveStudent3AfterCCView(this));
        }else if(players.size()!=3 && countmodexpview==4){
            serverHandler.getClient().transitionToView(new AskforMNafterCCView(this));
        }else if(players.size()==3 && countmodexpview==4){
            serverHandler.getClient().transitionToView(new MoveStudent4AfterCCView(this));
        }else if(countmodexpview==5){
            serverHandler.getClient().transitionToView(new AskforMNafterCCView(this));
        }

    }
    public String GetPlayer(){
        return name;
    }
    public GeneralBoard GetGB(){return generalBoard;}
    public ArrayList<Player> GetPlayers(){return players;}
}
