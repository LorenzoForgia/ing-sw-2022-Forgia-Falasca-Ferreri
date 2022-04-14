package it.polimi.ingsw.Model;

public class CharacterCard3 extends CharacterCard{
    public CharacterCard3(int name, int coins, int countUse) {
        super(name, coins, countUse);
    }
    public boolean UseEffect(){ /* player choose an island and calculate influence as mother nature was there*/
        return true;
    }
}
