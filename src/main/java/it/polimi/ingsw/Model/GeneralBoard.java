package it.polimi.ingsw.Model;

import java.util.*;

    public class GeneralBoard {
    private int Coins;
    private int NoEntryTiles;
    List<CloudTiles> Clouds = new ArrayList<>();
    List<IslandTiles> Islands = new ArrayList<>();
    List<SchoolBoard> AllBoards = new ArrayList<>();


    public GeneralBoard(int coins, int noEntryTiles) {
        Coins = coins;
        NoEntryTiles = noEntryTiles;
    }
    /* create twelve islands for the beginning of the game  */
    public void CreateTwelveIslands() {
        for (int i = 0; i < 12; i++) {
            Islands.add(i, new IslandTiles(i, false, 1, false, false));
        }
    }

    /* create n clouds for the beginning of the game  */
    public void CreateClouds( int n){
        for(int i=0; i<n; i++){
            Clouds.add(i, new CloudTiles(i));
        }
    }

    /* create n schoolboards for the beginning of the game  */
    public void CreateSchoolBoards( int n){
            for(int i=0; i<n; i++){
                AllBoards.add(i, new SchoolBoard());
            }
        }

    public CloudTiles getCloud(int i){
        return Clouds.get(i);
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
      if(!CheckifCanChangeNET(I1, I2)){
          addNET();
      }
        /* remove I2 from List*/

        for(int i=0; i < Islands.size() || flag ; i++){
            if (I2.equals(Islands.get(i))) {
                Islands.remove(i);
                flag = true;
            }
        }

    }

    public int CheckNumberOfGroup(){
        return Islands.size();
    }

    /* manage the exception*/
    private boolean CheckifCanChangeNET(IslandTiles I1, IslandTiles I2){
        if(I2.isNoEntryTiles()){
            try{ I1.putNET();
            } catch (IllegalMoveException c){
                return false;
            }
        }
        return true;
    }
    public IslandTiles moveMotherNature(IslandTiles I, int n){

        int j = 0;
        j= Islands.indexOf(I);

        /* tolgo madre natura da quell'isola, gestisci l'eccezione*/
        /*Islands.get(j).removeNM();*/

        /* trovo la nuova isola raggiunta */
        while( n>0  ){
            if(j<= Islands.size()){
                j++;
            }else{
                j=0;
            }
            n= n-1;
        }

        /*metti madre natura sulla nuova isola*/
        Islands.get(j).putMotherNature();

        return Islands.get(j);
    }
    /* vede se bisogna raggruppare delle isole*/
    public void CheckNearTower(IslandTiles I){
        int j=0;
        int k=0;
        j=Islands.indexOf(I);

        if(j == Islands.size()){
            k=0;
        }else{
            k=j+1;
        }
        if(Islands.get(j).getColTower() == Islands.get(k).getColTower()) {
            SetNewGroup(Islands.get(j),Islands.get(k));
        }

        if(j == 0){
            k= Islands.size();
        }else{
            k=j-1;
        }
        if(Islands.get(j).getColTower() == Islands.get(k).getColTower()) {
            SetNewGroup(Islands.get(j),Islands.get(k));
        }

    }
}
