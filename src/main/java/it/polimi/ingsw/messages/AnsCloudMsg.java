package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.ColorExc2View;
import it.polimi.ingsw.Client.views.GUI.TurnEndedScene;
import it.polimi.ingsw.Client.views.TurnEndedView;

public class AnsCloudMsg extends AnswerMsg{


    public AnsCloudMsg(CommandMsg parent){
        super(parent);
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        TurnEndedScene turnEndedScene= new TurnEndedScene(this);
        turnEndedScene.run();

        /*serverHandler.getClient().transitionToView(new TurnEndedView(this));*/
    }
}
