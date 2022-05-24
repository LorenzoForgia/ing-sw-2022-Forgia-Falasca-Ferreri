package it.polimi.ingsw.Model;

/*@author Luigia Falasca*/

/** There are 4 No Entry Tiles on this card
 * The player has to choose in which Island put the NET**/
public class CharacterCard5 extends CharacterCard{
    private int NET;
    private IslandTiles I1;

    public CharacterCard5(int name, int coins, int countUse, String descriptionEffect) {
        super(name, coins, countUse, descriptionEffect);
    }

    @Override
    public void SetCard(Bag b, GeneralBoard gb) {
        NET = 4;
    }

    @Override
    public void UseEffect(Player player) {
        player.setNameCharacterCard(5);
        player.setUsedCharacterCard(true);
        I1.putNET();
        NET = NET -1;

    }

    public void setI1(IslandTiles i1) {
        I1 = i1;
    }
}

