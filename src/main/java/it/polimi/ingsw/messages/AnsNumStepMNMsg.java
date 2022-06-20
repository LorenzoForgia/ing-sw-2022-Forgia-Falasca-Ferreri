package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.AskForCloudView;
import it.polimi.ingsw.Client.views.GUI.ChooseCloudSceneView;
import it.polimi.ingsw.Client.views.NumStepExcView;
import it.polimi.ingsw.Model.CloudTiles;
import it.polimi.ingsw.Model.GeneralBoard;

import java.util.ArrayList;

public class AnsNumStepMNMsg extends AnswerMsg{
    private String name;
    private ArrayList<CloudTiles> cloudTiles;

    public AnsNumStepMNMsg(CommandMsg parent, String name,ArrayList cloudTiles){
        super(parent);
        this.name = name;
        this.cloudTiles=cloudTiles;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        ChooseCloudSceneView c= new ChooseCloudSceneView(this);
        c.run();
        /*serverHandler.getClient().transitionToView(new AskForCloudView(this));*/
    }
    public String GetPlayer(){
        return name;
    }
    public ArrayList<CloudTiles> getCloudTiles() {
        return cloudTiles;
    }
}
