package it.polimi.ingsw.Model;

/*@author Luigia Falasca*/

public class CharacterCard5 extends CharacterCard {

    public CharacterCard5(int name, int coins, int countUse) {
        super(name, coins, countUse);
    }

    public void useEffect(IslandTiles IT) {
        try {
            IT.putNET();
        } catch (IllegalMoveException e) {

        }
    }
}
