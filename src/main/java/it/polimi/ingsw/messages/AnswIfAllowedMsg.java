package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.Client;
import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.GUI.JavaFXMain;
import it.polimi.ingsw.Client.views.GUI.LoginScene;
import it.polimi.ingsw.Client.views.GUI.LoginSceneCheck;
import it.polimi.ingsw.Client.views.PrintAnswerView;

public class AnswIfAllowedMsg extends AnswerMsg {

    public enum Status
    {
        INVALID,
        VALID
    }

    Status MoveStatus;
    public AnswIfAllowedMsg(CommandMsg parent, Status MoveStatus)
    {
        super(parent);
        this.MoveStatus = MoveStatus;

    }

    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        if(Client.GUI){
            LoginSceneCheck l=new LoginSceneCheck(this);
            l.run();
        }else{
            serverHandler.getClient().transitionToView(new PrintAnswerView(this));
        }



    }

    public Status getMoveStatus() {
        return MoveStatus;
    }
}
