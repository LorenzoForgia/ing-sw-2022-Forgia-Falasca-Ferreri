package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.ColorExc2View;
import it.polimi.ingsw.Client.views.GUI.ColorExc2Scene;

public class AnsColorExc2Msg extends AnswerMsg{
    private String name;

    public AnsColorExc2Msg(CommandMsg parent, String name){
        super(parent);
        this.name = name;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        ColorExc2Scene c= new ColorExc2Scene(this);
        c.run();
        /*serverHandler.getClient().transitionToView(new ColorExc2View(this));*/
    }
    public String GetPlayer(){
        return name;
    }
}
