package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.CC5ExcView;
import it.polimi.ingsw.Client.views.CC5View;
import it.polimi.ingsw.Client.views.GUI.CC5ExcScene;
import it.polimi.ingsw.Model.GeneralBoard;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class AnsCC5ExcMsg extends AnswerMsg{
    private GeneralBoard generalBoard;
    private ArrayList<Player> players= new ArrayList<Player>();


    public AnsCC5ExcMsg(CommandMsg parent,GeneralBoard generalBoard,ArrayList<Player> players ){
        super(parent);
        this.generalBoard= generalBoard;
        this.players=players;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        CC5ExcScene c= new CC5ExcScene(this);
        c.run();
        //serverHandler.getClient().transitionToView(new CC5ExcView(this));
    }
    public GeneralBoard GetGB(){return generalBoard;}
    public ArrayList<Player> GetPlayers(){return players;}
}
