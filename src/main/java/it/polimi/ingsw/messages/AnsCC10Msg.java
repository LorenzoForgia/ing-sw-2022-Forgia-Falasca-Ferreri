package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.Client;
import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.CC10View;
import it.polimi.ingsw.Client.views.CC3View;
import it.polimi.ingsw.Client.views.CC9View;
import it.polimi.ingsw.Client.views.GUI.CC10SceneView;
import it.polimi.ingsw.Model.GeneralBoard;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class AnsCC10Msg extends AnswerMsg{
    private GeneralBoard generalBoard;
    private ArrayList<Player> players= new ArrayList<Player>();



    public AnsCC10Msg(CommandMsg parent, GeneralBoard generalBoard,ArrayList<Player> players){
        super(parent);
        this.generalBoard= generalBoard;
        this.players=players;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        if(Client.GUI){
            CC10SceneView c= new CC10SceneView(this);
            c.run();
        }else{
          serverHandler.getClient().transitionToView(new CC10View(this));
        }


    }
    public GeneralBoard GetGB(){return generalBoard;}
    public ArrayList<Player> GetPlayers(){return players;}
}
