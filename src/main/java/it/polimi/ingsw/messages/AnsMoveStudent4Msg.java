package it.polimi.ingsw.messages;

import it.polimi.ingsw.Client.ServerHandler;
import it.polimi.ingsw.Client.views.*;
import it.polimi.ingsw.Client.views.GUI.AskForMN3PlayersScene;
import it.polimi.ingsw.Model.CharacterCard;
import it.polimi.ingsw.Model.GeneralBoard;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class AnsMoveStudent4Msg extends AnswerMsg{
    private String name;
    private GeneralBoard generalBoard;
    private ArrayList<Player> players= new ArrayList<Player>();
    private ArrayList<CharacterCard> characterCards= new ArrayList<CharacterCard>();
    private boolean modexp;

    public AnsMoveStudent4Msg(CommandMsg parent, String name, GeneralBoard generalBoard,ArrayList<Player> players, ArrayList<CharacterCard> characterCards, boolean modexp){
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
            serverHandler.getClient().transitionToView(new PlayCC5View(this));
        }else{
            AskForMN3PlayersScene a= new AskForMN3PlayersScene(this);
            a.run();
            /*serverHandler.getClient().transitionToView(new AskForMN3PlayersView(this));*/
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
