package it.polimi.ingsw.Model;

/*@author Luigia Falasca*/

public class CharacterCard6 extends CharacterCard{

    public CharacterCard6(int name, int coins, int countUse) {
        super(name, coins, countUse);
    }

    public int useEffect6(IslandTiles IT, int InfluenceTOT){
        int NewInfluence;
        NewInfluence = InfluenceTOT - IT.getSize();
        return NewInfluence;
    }
}