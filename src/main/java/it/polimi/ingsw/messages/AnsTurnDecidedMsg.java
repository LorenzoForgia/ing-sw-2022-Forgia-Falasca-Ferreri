package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.Client;
import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.GUI.TurnDecideSceneView;
import it.polimi.ingsw.Client.views.GameStartedView;
import it.polimi.ingsw.Client.views.TurnDecidedView;

import java.util.ArrayList;

public class AnsTurnDecidedMsg extends AnswerMsg{
    private ArrayList<String> nickname = new ArrayList<String>();

    public AnsTurnDecidedMsg(CommandMsg parent, ArrayList<String> nickname){
        super(parent);
        this.nickname = nickname;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        if(Client.GUI){
            TurnDecideSceneView t=new TurnDecideSceneView(this);
            t.run();
        }else{
            serverHandler.getClient().transitionToView(new TurnDecidedView(this));
        }


    }
    public ArrayList<String> getNickname() {
        return nickname;
    }
}
