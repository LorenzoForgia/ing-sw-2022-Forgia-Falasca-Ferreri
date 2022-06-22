package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.Client;
import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.CC3ExcView;
import it.polimi.ingsw.Client.views.CC3View;
import it.polimi.ingsw.Client.views.GUI.CC3ExcScene;
import it.polimi.ingsw.Model.GeneralBoard;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class AnsCC3ExcMsg extends AnswerMsg{
    private GeneralBoard generalBoard;
    private ArrayList<Player> players= new ArrayList<Player>();

    public AnsCC3ExcMsg(CommandMsg parent, GeneralBoard generalBoard, ArrayList<Player> players){
        super(parent);
        this.generalBoard= generalBoard;
        this.players=players;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        if(Client.GUI){
            CC3ExcScene c= new CC3ExcScene(this);
            c.run();
        }else{
            serverHandler.getClient().transitionToView(new CC3ExcView(this));
        }


    }
    public GeneralBoard GetGB(){return generalBoard;}
    public ArrayList<Player> GetPlayers(){return players;}
}
