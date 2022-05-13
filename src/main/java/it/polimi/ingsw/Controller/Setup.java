package it.polimi.ingsw.Controller;
import it.polimi.ingsw.Model.*;

import java.util.*;
public class Setup {
    private List<SchoolBoard> SBWithTowers = new ArrayList<>();

    public List<SchoolBoard> ChooseSchoolBoardWithTowers(GeneralBoard GB, int numOfPlayer){
        boolean squadBlack = true;
        boolean squadWhite= true;
        if(numOfPlayer == 4){
           for(int i=0; i< GB.getSchoolBoard().size() && (squadBlack || squadWhite); i++ ) {
            if (GB.getSchoolBoard().get(i).ColorTower().equals(ColorTower.Black)) {
                SBWithTowers.add(GB.getSchoolBoard().get(i));
                squadBlack= false;
             }
            if(GB.getSchoolBoard().get(i).ColorTower().equals(ColorTower.White)){
                SBWithTowers.add(GB.getSchoolBoard().get(i));
                squadWhite= false;
               }
           }
        }else{
            SBWithTowers = GB.getSchoolBoard();
        }
        return SBWithTowers;
    }

    public List<SchoolBoard> getSBWithTowers() {
        return SBWithTowers;
    }

    public void SetTowers(int numPlayers, List<SchoolBoard> sbperteam){ /**in case of 4 players sb must be only 2 sb of different squad**/
        int countTowers=8;
        if(numPlayers==3){
           countTowers=6;
        }
        for(int i=0;i<sbperteam.size();i++){
            for(int j=0;j<countTowers;j++) {
                sbperteam.get(i).PutTower();
            }
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
        int counter=MNposition+1;
        int infrontofMN=(MNposition+6)%12;
        if(MNposition==11){
            counter=0;
        }
        for(int i=0;i<12;i++,counter++){
            if(counter!=MNposition && counter!=infrontofMN){
                is.get(counter).PutStudent(b.CatchStudent());
            }
            if(counter==11){
                counter=-1;
            }
        }
    }



     public GeneralBoard CreateGeneralboard(Boolean modExpert,int numPlayers){
        GeneralBoard gb;
        DeckCC DC= new DeckCC();
        if(modExpert){
             gb= new GeneralBoard(20);
             for(int i=0; i < 3; i++){
                 gb.getChoosenCard().add(DC.DrawCard());
             }
         }else{
             gb=new GeneralBoard(0);
         }
        gb.CreateTwelveIslands();
        gb.CreateClouds(numPlayers);
        gb.CreateSchoolBoards(numPlayers);

        return gb;
     }

     /**character card nel main **/




}
