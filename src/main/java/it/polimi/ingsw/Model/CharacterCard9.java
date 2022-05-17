package it.polimi.ingsw.Model;
/** @author Lorenzo Forgia **/
public class CharacterCard9  extends CharacterCard {


    public CharacterCard9(int name, int coins, int countUse) {
        super(name, coins, countUse);
    }

    @Override
    public void UseEffect(Player p) {

    }

    @Override
    public void SetCard(Bag b, GeneralBoard gb) {

    }
    public int ColorNoEffect(IslandTiles island,Color c,int influencetot){
        int newinfluence=0;
        if(!island.isNoEntryTiles()){
            newinfluence= influencetot-island.CountInfluence(c);
        }
        return newinfluence;
    }

}
