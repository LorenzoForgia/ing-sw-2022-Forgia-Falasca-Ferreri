package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.*;
import it.polimi.ingsw.Client.views.GUI.PlayAfterNotCCSceneView;
import it.polimi.ingsw.Model.GeneralBoard;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class AnsPlayAfterNotCCMsg extends AnswerMsg{
    private String name;
    private GeneralBoard generalBoard;
    private ArrayList<Player> players= new ArrayList<Player>();
    private int countmoexpview;


    public AnsPlayAfterNotCCMsg(CommandMsg parent, String name, GeneralBoard generalBoard, ArrayList<Player> players, int countmoexpview ){
        super(parent);
        this.name = name;
        this.generalBoard= generalBoard;
        this.players=players;
        this.countmoexpview=countmoexpview;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        /*if(countmoexpview==1){
            serverHandler.getClient().transitionToView(new MoveStudent1AfterNotCCView(this));
        }else if(countmoexpview==2){
            serverHandler.getClient().transitionToView(new MoveStudent2AfterNotCCView(this));
        }else if(countmoexpview==3){
            serverHandler.getClient().transitionToView(new MoveStudent3AfterNotCCView(this));
        }else if(players.size()!=3 && countmoexpview==4){
            serverHandler.getClient().transitionToView(new AskforMNafterNotCCView(this));
        }else if(players.size()==3 && countmoexpview==4){
            serverHandler.getClient().transitionToView(new MoveStudent4AfterNotCCView(this));
        }else if(countmoexpview==5){
            serverHandler.getClient().transitionToView(new AskforMNafterNotCCView(this));
        }*/
        PlayAfterNotCCSceneView p= new PlayAfterNotCCSceneView(this);
        p.run();

    }
    public String GetPlayer(){
        return name;
    }
    public GeneralBoard GetGB(){return generalBoard;}
    public ArrayList<Player> GetPlayers(){return players;}

    public int getCountmoexpview() {
        return countmoexpview;
    }
}
