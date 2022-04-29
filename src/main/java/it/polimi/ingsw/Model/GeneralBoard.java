package it.polimi.ingsw.Model;

import java.util.*;

/*@author Luigia Falasca*/

    public class GeneralBoard {
    private int Coins;
    private int NoEntryTiles;
    List<CloudTiles> Clouds = new ArrayList<>();
    List<IslandTiles> Islands = new ArrayList<>();
    List<SchoolBoard> AllBoards = new ArrayList<>();
    List <CharacterCard> ChoosenCards = new ArrayList<>();


    public GeneralBoard(int coins) {
            Coins = coins;
        }

    public void setChoosenCards(CharacterCard c){
        ChoosenCards.add(c);
    }

    public List <CharacterCard>  getChoosenCard(){
        return ChoosenCards;
    }
    public void setNoEntryTiles(int noEntryTiles) {
            NoEntryTiles = noEntryTiles;
        }
    public int getNET(){
        return NoEntryTiles;
        }

        /* create twelve islands for the beginning of the game  */
    public void CreateTwelveIslands() {
        for (int i = 0; i < 12; i++) {
            Islands.add(i, new IslandTiles(i, false, 1, false, 0,false));
        }
    }

    public List<IslandTiles> GetIslands(){
        return Islands;
    }

    /* create n clouds for the beginning of the game  */
    public void CreateClouds( int n){
        for(int i=0; i<n; i++){
            Clouds.add(i, new CloudTiles(i));
        }
    }

    public List<CloudTiles> getClouds(){
        return Clouds;
        }

    /* create n SchoolBoards for the beginning of the game  */
    public void CreateSchoolBoards( int n) {
        if (n == 2 || n == 4) {
            for (int i = 0; i < n; i++) {
                AllBoards.add(i, new SchoolBoard(i, 7));
            }
        }
        if (n == 3) {
            for (int i = 0; i < n; i++) {
                AllBoards.add(i, new SchoolBoard(i, 9));
            }
        }
    }

    public List<SchoolBoard> getSchoolBoard(){
        return AllBoards;
    }

    public void addCoin(int n){
        Coins = Coins +  n;
    }

    public void removeCoin( int n){
            Coins = Coins - n;
        }

    public int getCoin(){
        return Coins;
        }

    public void addNET(){
        NoEntryTiles = NoEntryTiles + 1;
    }

    public void removeNET(){
            NoEntryTiles = NoEntryTiles - 1;
        }

    private void SetNewGroup(IslandTiles I1, IslandTiles I2 ){
        boolean flag = false;
     /* put I2 students in I1*/
        for(int i=0; i < I2.getStudentsInIsland().size(); i++){
            I1.PutStudent(I2.GetStudent(i));
        }

        /* change I1 size */
        I1.setSize(I1.getSize() + I2.getSize());

        /* if MN is in I2, then put MN in I1*/
        if(I2.isMotherNature()){
            I1.putMotherNature();
        }
        /* If NET is in I2, then put it in I1*/
      if(I2.isNoEntryTiles()){
          I1.putNET(I2.getNumberOfNet());
      }
        /* remove I2 from List*/
        for(int i=0; i < Islands.size() && flag==false ; i++){
            if (I2.getNumberID() == Islands.get(i).getNumberID()) {
                Islands.remove(i);
                flag = true;
            }
        }

    }

    public int CheckNumberOfGroup(){
        return Islands.size();
    }


    public IslandTiles moveMotherNature(IslandTiles I, int n){

        int j = 0;
        j= Islands.indexOf(I);

        /* remove MN from I*/
        Islands.get(j).removeNM();

        /* get the new island*/
        while( n > 0  ){
            if(j< Islands.size()-1){
                j++;
            }else{
                j=0;
            }
            n= n-1;
        }

        /*put MN on the new Island*/
        Islands.get(j).putMotherNature();

        return Islands.get(j);
    }
    /* Check if there are near towers of the same color and create new group of islands*/
    public void CheckNearTower(IslandTiles I) {
        int j = 0;
        int k = 0;
        j = Islands.indexOf(I);

        if (j == Islands.size()-1) {
            k = 0;
        } else {
            k = j + 1;
        }
        if (Islands.get(k).isTower()) {
            if (Islands.get(j).getColTower().equals(Islands.get(k).getColTower())) {
                SetNewGroup(Islands.get(j), Islands.get(k));
            }
        }

        j= Islands.indexOf(I);

        if (j == 0) {
            k = Islands.size()-1;
        } else {
            k = j - 1;
        }

        if (Islands.get(k).isTower()) {
            if (Islands.get(j).getColTower() == Islands.get(k).getColTower()) {
                SetNewGroup(Islands.get(j), Islands.get(k));
            }

        }
    }
}
