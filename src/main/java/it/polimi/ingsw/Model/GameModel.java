package it.polimi.ingsw.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lorenzo Forgia
 */
public class GameModel implements Serializable {

    private Boolean modExpert;
    private int numplayers;
    private GeneralBoard gb;
    private Bag b;
    private ArrayList<Player> players = new ArrayList<>();

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player p) {
        players.add(p);
    }

    public GeneralBoard getGeneralBoard() {
        return gb;
    }

    public void setGeneralBoard(GeneralBoard gb) {
        this.gb = gb;
    }

    public Bag getBag() {
        return b;
    }

    public void setBag(Bag b) {
        this.b = b;
    }
    public Boolean getModExpert() {
        return modExpert;
    }
    public int getNumplayers() {
        return numplayers;
    }
    public void setModExpert(Boolean modExpert) {
        this.modExpert = modExpert;
    }



    public void setNumplayers(int numplayers) {
        this.numplayers = numplayers;
    }


}
