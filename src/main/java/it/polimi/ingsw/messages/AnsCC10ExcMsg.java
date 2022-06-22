package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.Client;
import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.CC10ExcView;
import it.polimi.ingsw.Client.views.CC10View;
import it.polimi.ingsw.Client.views.GUI.CC10ExcScene;
import it.polimi.ingsw.Model.GeneralBoard;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class AnsCC10ExcMsg extends AnswerMsg{
    private GeneralBoard generalBoard;
    private ArrayList<Player> players= new ArrayList<Player>();



    public AnsCC10ExcMsg(CommandMsg parent, GeneralBoard generalBoard,ArrayList<Player> players){
        super(parent);
        this.generalBoard= generalBoard;
        this.players=players;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        if(Client.GUI){
            CC10ExcScene c= new CC10ExcScene(this);
            c.run();
        }else{
            serverHandler.getClient().transitionToView(new CC10ExcView(this));
        }


    }
    public GeneralBoard GetGB(){return generalBoard;}
    public ArrayList<Player> GetPlayers(){return players;}
}
