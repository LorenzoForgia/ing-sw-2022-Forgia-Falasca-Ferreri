package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.GUI.TurnEndedSceneView;

public class AnsCloudMsg extends AnswerMsg{


    public AnsCloudMsg(CommandMsg parent){
        super(parent);
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        TurnEndedSceneView turnEndedScene= new TurnEndedSceneView(this);
        turnEndedScene.run();

        /*serverHandler.getClient().transitionToView(new TurnEndedView(this));*/
    }
}
