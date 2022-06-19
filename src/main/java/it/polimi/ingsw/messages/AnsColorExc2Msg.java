package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.ColorExc2View;
import it.polimi.ingsw.Client.views.GUI.ColorExc1SceneView;
import it.polimi.ingsw.Client.views.GUI.ColorExc2SceneView;

public class AnsColorExc2Msg extends AnswerMsg{
    private String name;

    public AnsColorExc2Msg(CommandMsg parent, String name){
        super(parent);
        this.name = name;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        ColorExc2SceneView m=new ColorExc2SceneView(this);
        m.run();
        //serverHandler.getClient().transitionToView(new ColorExc2View(this)); CLI
    }
    public String GetPlayer(){
        return name;
    }
}
