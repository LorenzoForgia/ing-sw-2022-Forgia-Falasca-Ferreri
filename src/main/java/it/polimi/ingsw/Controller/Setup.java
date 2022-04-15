package it.polimi.ingsw.Controller;
import it.polimi.ingsw.Model.*;

import java.util.*;
public class Setup {
    /** DA FINIRE **/
    public List<ColorTower> getTowers(ColorTower ct){
        List<ColorTower> towers=new ArrayList<>();
        int limit=8;
        if(ct.equals(ColorTower.Grey)){
           limit=6;
        }
        for(int i=0;i<limit;i++){
            towers.add(ct);
        }
        return towers;
    }


    public Bag CreateBag(){
        Bag b=new Bag();
        return b;
    }
    public void SetBag(Bag b,int numsetbag){    /** setStudents in 2 phases:between 1 and 2 phase there's SetupStudentsInIslands**/
        if(numsetbag==1) {
            b.setStudents(10);
        }else{
            b.setStudents(120);
        }
    }

    public List<IslandTiles> CreateIslandTiles(int MNposition){
        List<IslandTiles> it =new ArrayList<IslandTiles>();
        Boolean MotherNature=false;
        for(int i=0;i<12;i++){
            if(i==MNposition){
                MotherNature=true;
            }
              it.add(new IslandTiles(i,MotherNature,1,false,false));
              MotherNature=false;
        }
        return it;
    }
    public void SetupStudentsInIslands(Bag b,int MNposition,List<IslandTiles> is){
        int starter=MNposition;
        int infrontofMN=(MNposition+6)%12;
        if(MNposition==11){
            starter=0;
        }
        for(int i=0;i<12;i++){
            if(i!=MNposition && i!=infrontofMN){
                is.get(i).PutStudent(b.CatchStudent());
            }
        }
    }
    public List<CloudTiles> CreateCloudTiles(int numPlayers){
        List<CloudTiles> c=new ArrayList<CloudTiles>();
        for(int i=0;i<numPlayers;i++){
            c.add(new CloudTiles(i));
        }
        return c;
    }

     public GeneralBoard getGeneralboard(ChooseSettingGame sg){
         if(sg.isModExpert()){
             return new GeneralBoard(20);
         }else{
             return new GeneralBoard(0);
         }
     }




   /**public List<ColorTower> setupTowers(ChooseSettingGame sg){

   }**/
 /*  public void SetGame(ChooseSettingGame settingsgame, List<SchoolBoard> sb, List<ColorTower> ColorTow){
      if(settingsgame.getNumPlayers()==2){
          for(int i=0;i<2;i++){
              ColorTower ct=ColorTow.get(i);
              sb.get(i).setColorTower(ct);

          }
      }
   }*/
}
