package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.Client;
import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.ColorExc3View;
import it.polimi.ingsw.Client.views.GUI.NumStepExc3PlayersScene;
import it.polimi.ingsw.Client.views.GUI.NumStepExcScene;
import it.polimi.ingsw.Client.views.NumStepExcView;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class AnsNumStepExcMsg extends AnswerMsg{
    private String name;
    private ArrayList<Player> players= new ArrayList<Player>();

    public AnsNumStepExcMsg(CommandMsg parent, String name, ArrayList<Player> players){
        super(parent);
        this.name = name;
        this.players=players;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        if(Client.GUI){
            if(players.size()==3){
                NumStepExc3PlayersScene n= new NumStepExc3PlayersScene(this);
                n.run();
            }else{
                NumStepExcScene n=new NumStepExcScene(this);
                n.run();
            }
        }else{
            serverHandler.getClient().transitionToView(new NumStepExcView(this));
        }


    }
    public String GetPlayer(){
        return name;
    }
}
