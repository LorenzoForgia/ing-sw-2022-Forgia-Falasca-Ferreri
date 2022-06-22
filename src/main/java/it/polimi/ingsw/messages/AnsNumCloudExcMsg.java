package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.Client;
import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.GUI.NumCloudExcScene;
import it.polimi.ingsw.Client.views.NumCloudExcView;
import it.polimi.ingsw.Client.views.NumStepExcView;

public class AnsNumCloudExcMsg extends AnswerMsg{
    private String name;

    public AnsNumCloudExcMsg(CommandMsg parent, String name){
        super(parent);
        this.name = name;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        if(Client.GUI){
            NumCloudExcScene n= new NumCloudExcScene(this);
            n.run();
        }else{
            serverHandler.getClient().transitionToView(new NumCloudExcView(this));
        }


    }
    public String GetPlayer(){
        return name;
    }
}
