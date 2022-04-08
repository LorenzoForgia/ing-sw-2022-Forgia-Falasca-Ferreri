package it.polimi.ingsw.Model;

/*@author Luigia Falasca*/

public class CharacterCard8 extends CharacterCard{

    public CharacterCard8(int name, int coins, int countUse) {
        super(name, coins, countUse);
    }

    public int useEffect8(IslandTiles IT, int InfluenceTOT){
        int NewInfluence;
        NewInfluence = InfluenceTOT + 2;
        return NewInfluence;
    }
}

