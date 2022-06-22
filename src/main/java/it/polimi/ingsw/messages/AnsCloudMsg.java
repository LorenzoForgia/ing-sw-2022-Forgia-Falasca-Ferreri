package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.Client;
import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.GUI.TurnEndedSceneView;
import it.polimi.ingsw.Client.views.TurnEndedView;

public class AnsCloudMsg extends AnswerMsg{


    public AnsCloudMsg(CommandMsg parent){
        super(parent);
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        if(Client.GUI){
            TurnEndedSceneView turnEndedScene= new TurnEndedSceneView(this);
            turnEndedScene.run();
        }else{
            serverHandler.getClient().transitionToView(new TurnEndedView(this));
        }


    }
}
