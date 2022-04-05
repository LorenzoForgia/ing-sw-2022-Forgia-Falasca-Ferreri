package it.polimi.ingsw.Model;

import java.util.ArrayList;

public class GeneralBoard {
    private int Coins;
    private int NoEntryTiles;
    ArrayList<IslandTiles> Islands = new ArrayList<>();

    public GeneralBoard(int coins, int noEntryTiles) {
        Coins = coins;
        NoEntryTiles = noEntryTiles;
    }

}
