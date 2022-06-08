package it.polimi.ingsw.Model;


import java.io.Serializable;

/**
 * @author Luigia Falasca
 * **/
public class CharacterCard5 extends CharacterCard implements Serializable {
    private int NET;
    private IslandTiles I1;

    public CharacterCard5(int name, int coins, int countUse, String descriptionEffect) {
        super(name, coins, countUse, descriptionEffect);
    }
/** There are 4 No Entry Tiles on this card
 * **/
    @Override
    public void SetCard(Bag b, GeneralBoard gb) {
        NET = 4;
    }

    /** Put the NET in the chosen Island
     * **/

    @Override
    public void UseEffect(Player player) {
        player.setNameCharacterCard(5);
        player.setUsedCharacterCard(true);
        I1.putNET();
        NET = NET -1;

    }
    /** Set the chosen Island
     * **/
    public void setI1(IslandTiles i1) {
        I1 = i1;
    }
}

