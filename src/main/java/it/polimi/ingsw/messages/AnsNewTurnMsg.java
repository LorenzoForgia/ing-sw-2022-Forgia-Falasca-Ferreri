package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.GUI.NewTurnSceneView;

public class AnsNewTurnMsg extends AnswerMsg{
    private String name;

    public AnsNewTurnMsg(CommandMsg parent, String name){
        super(parent);
        this.name = name;
    }

    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        NewTurnSceneView n=new NewTurnSceneView(this);
        n.run();
        /*serverHandler.getClient().transitionToView(new NewTurnView(this));*/
    }
    public String GetPlayer(){
        return name;
    }
}
