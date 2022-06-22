package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.Client;
import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.ColorExc3View;
import it.polimi.ingsw.Client.views.GUI.ColorExc3Scene;

public class AnsColorExc3Msg extends AnswerMsg{
    private String name;

    public AnsColorExc3Msg(CommandMsg parent, String name){
        super(parent);
        this.name = name;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        if(Client.GUI){
            ColorExc3Scene c= new ColorExc3Scene(this);
            c.run();
        }else{
            serverHandler.getClient().transitionToView(new ColorExc3View(this));
        }


    }
    public String GetPlayer(){
        return name;
    }
}
