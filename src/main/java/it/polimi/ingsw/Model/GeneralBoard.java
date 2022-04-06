package it.polimi.ingsw.Model;

import java.util.*;

    public class GeneralBoard {
    private int Coins;
    private int NoEntryTiles;
    List<IslandTiles> Islands = new ArrayList<>();
    private IslandTiles Island1, Island2;

    public GeneralBoard(int coins, int noEntryTiles) {
        Coins = coins;
        NoEntryTiles = noEntryTiles;
    }
    /* create twelve island for the beginning of the game  */
    public void CreateTwelveIslands() {
        for (int i = 0; i < 12; i++) {
            Islands.add(i, new IslandTiles(i, false, 1, false));
        }
    }

    public void addCoin(){
        Coins = Coins + 1;
    }

    public void removeCoin(){
            Coins = Coins - 1;
        }

    public void addNET(){
        NoEntryTiles = NoEntryTiles + 1;
    }

    public void removeNET(){
            NoEntryTiles = NoEntryTiles - 1;
        }

    public void SetNewGroup(IslandTiles I1, IslandTiles I2 ){
        /*cerco I1 e I2 nella mia lista*/
        for(int i=0; i < Islands.size(); i++){
            if (I1.equals(Islands.get(i))){
                Island1=I1;
            }
            if (I2.equals(Islands.get(i))) {
                Island2 = I2;
            }
        }
        /* trasferisco gli studenti dell'isola 2 nell'isola 1*/
        for(int i=0; i < Island2.getStudentsInIsland().size(); i++){
            Island1.PutStudent(Island2.GetStudent(i));
        }

        /* setto la nuova size nell'isola I1 */

        Island1.setSize(Island1.getSize() + Island2.getSize());
        /* se c'è madre natura nell'siola 2 la metto nell'isola 1*/
        if(Island2.isMotherNature()){
            Island1.putMotherNature();
        }
        /* se c'è NET nell'isola 2 la metto nell'isola 1, devo gestire l'eccezione/
      /*  if(Island2.isNoEntryTiles()){

            Island1.putNET();
        }*/
        /* cancello l'isola 2 dalla lista*/

        for(int i=0; i < Islands.size(); i++){
            if (I2.equals(Islands.get(i))) {
                Islands.remove(i);
            }
        }

    }

    public int CheckNumberOfGroup(){
        return Islands.size();
    }


}
