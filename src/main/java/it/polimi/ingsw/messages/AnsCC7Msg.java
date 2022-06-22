package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.Client;
import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.CC1View;
import it.polimi.ingsw.Client.views.CC3View;
import it.polimi.ingsw.Client.views.CC7View;
import it.polimi.ingsw.Client.views.GUI.CC7SceneView;
import it.polimi.ingsw.Model.CharacterCard;
import it.polimi.ingsw.Model.GeneralBoard;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class AnsCC7Msg extends AnswerMsg{
    private GeneralBoard generalBoard;
    private ArrayList<Player> players= new ArrayList<Player>();
    private CharacterCard characterCard;


    public AnsCC7Msg(CommandMsg parent, GeneralBoard generalBoard,ArrayList<Player> players, CharacterCard characterCard ){
        super(parent);
        this.generalBoard= generalBoard;
        this.players=players;
        this.characterCard= characterCard;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        if(Client.GUI){
            CC7SceneView c= new CC7SceneView(this);
            c.run();
        }else{
            serverHandler.getClient().transitionToView(new CC7View(this));
        }


    }
    public GeneralBoard GetGB(){return generalBoard;}
    public ArrayList<Player> GetPlayers(){return players;}

    public CharacterCard GetCharacterCard() {
        return characterCard;
    }
}
