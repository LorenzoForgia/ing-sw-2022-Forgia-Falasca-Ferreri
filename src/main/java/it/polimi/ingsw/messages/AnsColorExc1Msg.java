package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.ColorExc1View;
import it.polimi.ingsw.Client.views.GUI.ColorExc1SceneView;
import it.polimi.ingsw.Client.views.GUI.MoveStudent1SceneView;

public class AnsColorExc1Msg extends AnswerMsg{
    private String name;

    public AnsColorExc1Msg(CommandMsg parent, String name){
        super(parent);
        this.name = name;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        ColorExc1SceneView m=new ColorExc1SceneView(this);
        m.run();
       // serverHandler.getClient().transitionToView(new ColorExc1View(this)); CLI
    }
    public String GetPlayer(){
        return name;
    }
}
