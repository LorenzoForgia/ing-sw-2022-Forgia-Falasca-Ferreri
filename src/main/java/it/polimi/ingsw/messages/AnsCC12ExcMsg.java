package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.Client;
import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.CC12ExcView;
import it.polimi.ingsw.Client.views.CC12View;
import it.polimi.ingsw.Client.views.GUI.CC12ExcScene;
import it.polimi.ingsw.Model.GeneralBoard;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class AnsCC12ExcMsg extends AnswerMsg{
    private GeneralBoard generalBoard;
    private ArrayList<Player> players= new ArrayList<Player>();



    public AnsCC12ExcMsg(CommandMsg parent, GeneralBoard generalBoard,ArrayList<Player> players){
        super(parent);
        this.generalBoard= generalBoard;
        this.players=players;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        if(Client.GUI){
            CC12ExcScene c= new CC12ExcScene(this);
            c.run();
        }else{
            serverHandler.getClient().transitionToView(new CC12ExcView(this));
        }


    }
    public GeneralBoard GetGB(){return generalBoard;}
    public ArrayList<Player> GetPlayers(){return players;}
}
