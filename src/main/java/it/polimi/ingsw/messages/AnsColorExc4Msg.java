package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.Client;
import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.ColorExc3View;
import it.polimi.ingsw.Client.views.ColorExc4View;
import it.polimi.ingsw.Client.views.GUI.ColorExc4Scene;

public class AnsColorExc4Msg extends AnswerMsg{
    private String name;

    public AnsColorExc4Msg(CommandMsg parent, String name){
        super(parent);
        this.name = name;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        if(Client.GUI){
            ColorExc4Scene c=new ColorExc4Scene(this);
            c.run();
        }else{
            serverHandler.getClient().transitionToView(new ColorExc4View(this));
        }

    }
    public String GetPlayer(){
        return name;
    }
}
