package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.Client;
import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.ColorExc1View;
import it.polimi.ingsw.Client.views.GUI.ColorExc1Scene;

public class AnsColorExc1Msg extends AnswerMsg{
    private String name;

    public AnsColorExc1Msg(CommandMsg parent, String name){
        super(parent);
        this.name = name;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        if(Client.GUI){
            ColorExc1Scene c= new ColorExc1Scene(this);
            c.run();
        }else{
            serverHandler.getClient().transitionToView(new ColorExc1View(this));
        }

    }
    public String GetPlayer(){
        return name;
    }
}
