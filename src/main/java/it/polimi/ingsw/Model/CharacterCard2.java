package it.polimi.ingsw.Model;

public class CharacterCard2 extends CharacterCard{
    public CharacterCard2(int name, int coins, int countUse) {
        super(name, coins, countUse);
    }
    public boolean UseEffect(){         /* take control on professor in any case*/
        return true;
    }
}
