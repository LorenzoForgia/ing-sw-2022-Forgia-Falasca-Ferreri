package it.polimi.ingsw.Model;
/** @author Lorenzo Forgia **/
public class CharacterCard9 extends CharacterCard {
    public CharacterCard9(int Name, int Coins, int CountUse) {
        super(Name, Coins, CountUse);
    }
    public int ColorNoEffect(IslandTiles island,Color c,int influencetot){
        int newinfluence=0;
        if(!island.isNoEntryTiles()){
            newinfluence= influencetot-island.CountInfluence(c);
        }
        return newinfluence;
    }

}
