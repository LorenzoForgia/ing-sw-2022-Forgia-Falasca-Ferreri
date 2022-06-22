package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.CC9ExcView;
import it.polimi.ingsw.Client.views.CC9View;
import it.polimi.ingsw.Client.views.GUI.CC9ExcScene;
import it.polimi.ingsw.Model.GeneralBoard;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class AnsCC9ExcMsg extends AnswerMsg{
    private GeneralBoard generalBoard;
    private ArrayList<Player> players= new ArrayList<Player>();


    public AnsCC9ExcMsg(CommandMsg parent,GeneralBoard generalBoard,ArrayList<Player> players ){
        super(parent);
        this.generalBoard= generalBoard;
        this.players=players;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        CC9ExcScene c= new CC9ExcScene(this);
        c.run();
        //serverHandler.getClient().transitionToView(new CC9ExcView(this));
    }
    public GeneralBoard GetGB(){return generalBoard;}
    public ArrayList<Player> GetPlayers(){return players;}
}
