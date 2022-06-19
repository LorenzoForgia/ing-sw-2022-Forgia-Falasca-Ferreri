package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;

import it.polimi.ingsw.Client.views.GUI.MoveStudent1SceneView;
import it.polimi.ingsw.Client.views.MoveStudent1View;
import it.polimi.ingsw.Client.views.PlayCC1View;
import it.polimi.ingsw.Model.CharacterCard;
import it.polimi.ingsw.Model.GeneralBoard;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;


public class AnsAskCAMsg extends AnswerMsg{
    private String name;
    private GeneralBoard generalBoard;
    private ArrayList<Player> players= new ArrayList<Player>();
    private ArrayList<CharacterCard> characterCards= new ArrayList<CharacterCard>();
    private boolean modexp;

    public AnsAskCAMsg(CommandMsg parent, String name, GeneralBoard generalBoard,ArrayList<Player> players, ArrayList<CharacterCard> characterCards, boolean modexp ){
        super(parent);
        this.name = name;
        this.generalBoard= generalBoard;
        this.players=players;
        this.characterCards=characterCards;
        this.modexp=modexp;
    }

    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        if(modexp){
            serverHandler.getClient().transitionToView(new PlayCC1View(this));
        }else{
            MoveStudent1SceneView m=new MoveStudent1SceneView(this);
            m.run();
           // serverHandler.getClient().transitionToView(new MoveStudent1View(this)); CLI NON CANCELLARE
        }
    }
    public String GetPlayer(){
        return name;
    }
    public GeneralBoard GetGB(){return generalBoard;}
    public ArrayList<Player> GetPlayers(){return players;}
    public ArrayList<CharacterCard> GetCharacterCards() {
        return characterCards;
    }
}
