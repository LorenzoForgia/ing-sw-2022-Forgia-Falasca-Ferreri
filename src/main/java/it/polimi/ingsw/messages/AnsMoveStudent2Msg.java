package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.Client;
import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.GUI.MoveStudent3SceneView;
import it.polimi.ingsw.Client.views.GUI.PlayCC3SceneView;
import it.polimi.ingsw.Client.views.MoveStudent2View;
import it.polimi.ingsw.Client.views.MoveStudent3View;
import it.polimi.ingsw.Client.views.PlayCC3View;
import it.polimi.ingsw.Model.CharacterCard;
import it.polimi.ingsw.Model.GeneralBoard;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class AnsMoveStudent2Msg extends AnswerMsg{
    private String name;
    private GeneralBoard generalBoard;
    private ArrayList<Player> players= new ArrayList<Player>();
    private ArrayList<CharacterCard> characterCards= new ArrayList<CharacterCard>();
    private boolean modexp;

    public AnsMoveStudent2Msg(CommandMsg parent, String name, GeneralBoard generalBoard,ArrayList<Player> players, ArrayList<CharacterCard> characterCards, boolean modexp){
        super(parent);
        this.name = name;
        this.generalBoard= generalBoard;
        this.players=players;
        this.modexp=modexp;
        this.characterCards=characterCards;
    }
    @Override
    public void processMessage(ServerHandler serverHandler)
    {
        if(Client.GUI){
            if(modexp){
                PlayCC3SceneView p= new PlayCC3SceneView(this);
                p.run();
            }else{
                MoveStudent3SceneView m=new MoveStudent3SceneView(this);
                m.run();
            }

        }else{
            if(modexp){
                serverHandler.getClient().transitionToView(new PlayCC3View(this));
            }else{
                serverHandler.getClient().transitionToView(new MoveStudent3View(this));
            }

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
