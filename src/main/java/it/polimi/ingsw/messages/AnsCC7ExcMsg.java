package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.CC7ExcView;
import it.polimi.ingsw.Client.views.CC7View;
import it.polimi.ingsw.Client.views.GUI.CC7ExcScene;
import it.polimi.ingsw.Model.CharacterCard;
import it.polimi.ingsw.Model.GeneralBoard;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class AnsCC7ExcMsg extends AnswerMsg{
    private GeneralBoard generalBoard;
    private ArrayList<Player> players= new ArrayList<Player>();
    private CharacterCard characterCard;


    public AnsCC7ExcMsg(CommandMsg parent, GeneralBoard generalBoard,ArrayList<Player> players, CharacterCard characterCard ){
        super(parent);
        this.generalBoard= generalBoard;
        this.players=players;
        this.characterCard= characterCard;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        CC7ExcScene c= new CC7ExcScene(this);
        c.run();
        //serverHandler.getClient().transitionToView(new CC7ExcView(this));
    }
    public GeneralBoard GetGB(){return generalBoard;}
    public ArrayList<Player> GetPlayers(){return players;}

    public CharacterCard GetCharacterCard() {
        return characterCard;
    }
}
