package it.polimi.ingsw.Controller;
import it.polimi.ingsw.Model.*;

import java.util.*;
public class Setup {

    public void SetTowers(int numPlayers,List<SchoolBoard> sbperteam){ /**in case of 4 players sb must be only 2 sb of different squad**/
        int countTowers=8;
        if(numPlayers==3){
           countTowers=6;
        }
        for(int i=0;i<countTowers;i++) {
            sbperteam.get(i).PutTower();
        }
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

    public void SetMNto1Island(int MNposition,GeneralBoard gb){
        gb.GetIslands().get(MNposition).putMotherNature();
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



     public GeneralBoard getGeneralboard(ChooseSettingGame sg){
         if(sg.isModExpert()){
             return new GeneralBoard(20);
         }else{
             return new GeneralBoard(0);
         }
     }

     /**character card nel main **/
      



}
