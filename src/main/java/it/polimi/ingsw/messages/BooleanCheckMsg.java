package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.GUI.GameCreatedSceneView;
import it.polimi.ingsw.Client.views.GUI.GameStartedSceneView;
import it.polimi.ingsw.Client.views.GameCreatedView;

public class BooleanCheckMsg extends AnswerMsg{
    BooleanCheckMsg.Status MoveStatus;

    public enum Status
    {
        OK,
        KO
    }


    public BooleanCheckMsg(CommandMsg parent, BooleanCheckMsg.Status MoveStatus)
    {
        super(parent);
        this.MoveStatus = MoveStatus;
    }

    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        GameCreatedSceneView g=new GameCreatedSceneView(this);
        g.run();
        //serverHandler.getClient().transitionToView(new GameCreatedView(this)); CLI
    }
    public BooleanCheckMsg.Status getMoveStatus() {
        return MoveStatus;
    }
}
