package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.GUI.GameStartedSceneView;
import it.polimi.ingsw.Client.views.GameCreatedView;
import it.polimi.ingsw.Client.views.GameStartedView;
import it.polimi.ingsw.Model.GeneralBoard;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.SchoolBoard;

import java.util.ArrayList;
import java.util.List;

public class AnsGameStartedMsg extends AnswerMsg{
    private ArrayList<String> nickname = new ArrayList<String>();
    /*private ArrayList<Integer> schoolBoards = new ArrayList<Integer>();*/
    /*private GeneralBoard gb;*/




    public AnsGameStartedMsg(CommandMsg parent, ArrayList<String> nickname)
    {
        super(parent);
        this.nickname = nickname;
        /*this.schoolBoards= schoolBoards;*/
        /*this.gb = gb;*/
    }

    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        GameStartedSceneView g=new GameStartedSceneView(this);
        g.run();
       /** serverHandler.getClient().transitionToView(new GameStartedView(this)); CLI NON CANCELLARE*/
    }
    public ArrayList<String> getNickname() {
        return nickname;
    }
    /*public ArrayList<Integer> getSchoolBoards() {
        return schoolBoards;
    }*/
    /*public GeneralBoard getGb() {
        return gb;
    }*/

}
