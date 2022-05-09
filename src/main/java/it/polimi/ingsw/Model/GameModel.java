package it.polimi.ingsw.Model;

import java.util.ArrayList;
import java.util.List;

public class GameModel {
    private GeneralBoard gb;
    private Bag b;
    private List<Player> players = new ArrayList<>();

    public List<Player> getPlayers() {
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



}
