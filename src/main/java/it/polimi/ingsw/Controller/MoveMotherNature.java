package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.*;

import java.util.ArrayList;
import java.util.List;


public class MoveMotherNature {
    IslandTiles I1;
    ColorTower colorT;
    List<ColorTower> colorTowerList = new ArrayList<>();


    public void SetIslandWithMotherNature(IslandTiles I){
        I1 = I;
    }

    public void MoveMN(GeneralBoard GB, int n){
        I1 = GB.moveMotherNature(I1, n);
    }


    private int influenceTot(List<Color> student, IslandTiles I, ColorTower ct) {
        int influence = 0;
        int influenceT = 0;
        if (!I.isNoEntryTiles()) {                     /*Effect5*/
            if (I.isTower()) {
                if (ct.equals(I.getColTower())) {
                    influenceT = I.getSize();
                }
            }
            for (int i = 0; i < student.size(); i++) {
                influence = influence + I.CountInfluence(student.get(i));
            }
            influence = influence + influenceT;
        }

        return influence;
    }

    /*Overload*/
    private int influenceTot(List<Color> student, IslandTiles I, ColorTower ct, CharacterCard card, SchoolBoard SbPlayer) {
        int influence = 0;
        int influenceT = 0;
        if (!I.isNoEntryTiles()) {                     /*Effect5*/
            if (I.isTower()) {
                if (ct.equals(I.getColTower())) {
                    influenceT = I.getSize();
                }
            }
            for (int i = 0; i < student.size(); i++) {
                influence = influence + I.CountInfluence(student.get(i));
            }
            influence = influence + influenceT;

            if (card.getName() == 6) {     /*Effect6*/
                if(ct.equals(I.getColTower())) {
                    influence = ((CharacterCard6) card).useEffect6(I, influence);
                    card.setCountUse();
                }

            } else if (card.getName() == 8) {/*Effect8*/
                if(SbPlayer.ColorTower().equals(ct)) {
                    influence = ((CharacterCard8) card).useEffect8(I, influence);
                    card.setCountUse();
                }
            }
        }
        return influence;
    }

    /*Overload*/
    private int influenceTot(List<Color> professor, IslandTiles I, ColorTower ct, CharacterCard card , Color c) {
        int influence = 0;
        int influenceT = 0;
        if (!I.isNoEntryTiles()) {                     /*Effect5*/
            if (I.isTower()) {
                if (ct.equals(I.getColTower())) {
                    influenceT = I.getSize();
                }
            }
            for (int i = 0; i < professor.size(); i++) {
                if (!c.equals(professor.get(i))) {    /*Effect9*/
                    influence = influence + I.CountInfluence(professor.get(i));
                }else{
                    card.setCountUse();
                }
            }

            influence = influence + influenceT;


        }
        return influence;
    }

    private ArrayList<ArrayList<Color>> GetSquadIf4Players(GeneralBoard GB){
        ColorTower ct;
        boolean flag = true;
        List<SchoolBoard> lSB =new ArrayList<>();
        ArrayList<ArrayList<Color>> listProfessor = new ArrayList<>(2);

        for(int i =0; i < GB.getSchoolBoard().size(); i++) {
            lSB.add(i, GB.getSchoolBoard().get(i));
        }

        for(int i=0; i< 2; i ++){
            listProfessor.add(new ArrayList<>());
        }

        for(int i=0; i < 2; i ++){
            ct= lSB.get(i).ColorTower();
            listProfessor.get(i).addAll(lSB.get(i).getProfessorTable());
            colorTowerList.add(i,lSB.get(i).ColorTower());
            flag = true;
            for( int j= i + 1; j <lSB.size() && flag; j++){
                if(ct.equals(lSB.get(j).ColorTower())){
                    listProfessor.get(i).addAll(lSB.get(j).getProfessorTable());
                    lSB.remove(j);
                    flag= false;
                }
            }
        }
        return listProfessor;
    }

    private ArrayList<ArrayList<Color>> GetArrayForInfluence(GeneralBoard GB, int n){
        List<SchoolBoard> lSB =GB.getSchoolBoard();
        ArrayList<ArrayList<Color>> listProfessor = new ArrayList<>(n);

        for(int i= 0; i < n; i ++){
            listProfessor.add(new ArrayList<>());
        }

        for(int i=0; i < lSB.size(); i ++){
            listProfessor.get(i).addAll(lSB.get(i).getProfessorTable());
            colorTowerList.add(i, lSB.get(i).ColorTower());
        }
        return listProfessor;
    }


    public boolean CheckIfIslandGetControlled(int numberPlayer, GeneralBoard GB, IslandTiles I){
        ArrayList<Integer> listInfluence = new ArrayList<>();
        ArrayList<ArrayList<Color>> listProfessor;
        boolean flag = false;
        int max=0;
        ColorTower ct = colorT;

        if(numberPlayer==4) {
            listProfessor= GetSquadIf4Players(GB);
        }else{
            listProfessor = GetArrayForInfluence(GB, numberPlayer);
        }

        for(int i=0; i< listProfessor.size(); i++) {
            listInfluence.add(i, influenceTot(listProfessor.get(i), I, colorTowerList.get(i)));
        }

        for(int j=0; j < listInfluence.size(); j++){
            if(listInfluence.get(j)> max){
                max = listInfluence.get(j);
                ct = colorTowerList.get(j);
                flag = true;
            }else if(listInfluence.get(j)== max){
                ct = colorT;
                flag = false;
            }
        }

        if(I.isNoEntryTiles()){
            I.removeNET();
        }
        colorT = ct;
        return flag;
    }

    /*Overload*/
    public boolean CheckIfIslandGetControlled(int numberPlayer, GeneralBoard GB, IslandTiles I, CharacterCard c, SchoolBoard SbPlayer){
        ArrayList<Integer> listInfluence = new ArrayList<>();
        ArrayList<ArrayList<Color>> listProfessor;
        boolean flag = false;
        int max=0;
        ColorTower ct = colorT;

        if(numberPlayer==4) {
            listProfessor= GetSquadIf4Players(GB);
        }else{
           listProfessor = GetArrayForInfluence(GB, numberPlayer);
        }

        for(int i=0; i< listProfessor.size(); i++) {
            listInfluence.add(i, influenceTot(listProfessor.get(i), I, colorTowerList.get(i), c, SbPlayer));
        }

        for(int j=0; j < listInfluence.size(); j++){
            if(listInfluence.get(j)> max){
                 max = listInfluence.get(j);
                 ct = colorTowerList.get(j);
                 flag = true;
            }else if(listInfluence.get(j)== max){
                  ct = colorT;
                  flag = false;
            }
        }
        colorT = ct;
        return flag;
    }


    /*Overload*/

    public boolean CheckIfIslandGetControlled(int numberPlayer, GeneralBoard GB, IslandTiles I, CharacterCard c, Color color){
        ArrayList<Integer> listInfluence = new ArrayList<>();
        ArrayList<ArrayList<Color>> listProfessor;
        boolean flag = false;
        int max=0;
        ColorTower ct = colorT;

        if(numberPlayer==4) {
            listProfessor= GetSquadIf4Players(GB);
        }else{
            listProfessor = GetArrayForInfluence(GB, numberPlayer);
        }

        for(int i=0; i< listProfessor.size(); i++) {
                listInfluence.add(i, influenceTot(listProfessor.get(i), I, colorTowerList.get(i), c, color));
        }

        for(int j=0; j < listInfluence.size(); j++){
            if(listInfluence.get(j)> max){
                max = listInfluence.get(j);
                ct = colorTowerList.get(j);
                flag = true;
            }else if(listInfluence.get(j)== max){
                ct = colorT;
                flag = false;
            }
        }
        colorT = ct;
        return flag;
    }

    public void GetRightTowerOnIsland(GeneralBoard GB, IslandTiles I, List<SchoolBoard> SBWhitTower){
        ColorTower ct;
        boolean notFound = true;
        if(I.isTower()) {
            ct = I.getColTower();
            if (!colorT.equals(ct)) {
                for(int i =0; i < SBWhitTower.size() && notFound; i++){
                   if(SBWhitTower.get(i).ColorTower().equals(ct)){
                       for(int j= 0;  j< I.getSize(); j ++){
                           SBWhitTower.get(i).PutTower();
                       }
                       notFound = false;
                   }
                }
                notFound = true;
                for(int i =0; i < SBWhitTower.size() && notFound; i++){
                    if(SBWhitTower.get(i).ColorTower().equals(colorT)){
                        for(int j= 0;  j< I.getSize(); j ++){
                            SBWhitTower.get(i).RemoveTower();
                        }
                        notFound = false;

                    }
                }
            I.putTower(colorT);
            GB.CheckNearTower(I);
            }
        }else{
            notFound = true;
            for(int i =0; i < SBWhitTower.size() && notFound; i++) {
                if (SBWhitTower.get(i).ColorTower().equals(colorT)) {
                    SBWhitTower.get(i).RemoveTower();
                    notFound = false;
                }
            }
            I1.putTower(colorT);
            GB.CheckNearTower(I);
        }

    }
}
