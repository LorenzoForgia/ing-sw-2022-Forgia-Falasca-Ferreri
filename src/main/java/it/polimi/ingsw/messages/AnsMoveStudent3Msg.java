package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.*;
import it.polimi.ingsw.Client.views.GUI.AskForMotherNatureSceneView;
import it.polimi.ingsw.Client.views.GUI.MoveStudent4SceneView;
import it.polimi.ingsw.Model.CharacterCard;
import it.polimi.ingsw.Model.GeneralBoard;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class AnsMoveStudent3Msg extends AnswerMsg{
    private String name;
    private GeneralBoard generalBoard;
    private ArrayList<Player> players= new ArrayList<Player>();
    private ArrayList<CharacterCard> characterCards= new ArrayList<CharacterCard>();
    private boolean modexp;

    public AnsMoveStudent3Msg(CommandMsg parent, String name, GeneralBoard generalBoard,ArrayList<Player> players, ArrayList<CharacterCard> characterCards, boolean modexp){
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
        if(modexp){
            if(players.size()==3){
                serverHandler.getClient().transitionToView(new PlayCC4Players3View(this));
            }else{
                serverHandler.getClient().transitionToView(new PlayCC4View(this));
            }
        }else{
            if(players.size()==3){
                MoveStudent4SceneView m= new MoveStudent4SceneView();
                m.run();
                /*serverHandler.getClient().transitionToView(new MoveStudent4View(this));*/
            }else{
                AskForMotherNatureSceneView askForMotherNatureScene=new AskForMotherNatureSceneView(this);
                askForMotherNatureScene.run();
                /*serverHandler.getClient().transitionToView(new AskforMotherNatureView(this));*/
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
