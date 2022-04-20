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

    private int influenceTot(List<Color> student, IslandTiles I, ColorTower ct, boolean usedCard , CharacterCard card ) {
        int influence = 0;
        int influenceT = 0;
        CharacterCard6 c6;
        CharacterCard8 c8;
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

        if(usedCard) {
            if (card.getName() == 6) {     /*Effect6*/
                c6 = (CharacterCard6) card;
                influence = c6.useEffect6(I, influence);
                card.setCountUse();
                ;
            }else if(card.getName() == 8){                /*Effect8*/
                c8 = (CharacterCard8) card;
                influence = c8.useEffect8(I, influence);
                card.setCountUse();
            }else if(card.getName() == 9){                 /*Effect9*/

            }
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


    public boolean CheckIfIslandGetControlled(int numberPlayer, GeneralBoard GB, boolean usedCard, CharacterCard c){
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
            listInfluence.add(i, influenceTot(listProfessor.get(i), I1, colorTowerList.get(i), usedCard, c));
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

    public void GetRightTowerOnIsland(GeneralBoard GB, List<SchoolBoard> SBWhitTower){
        ColorTower ct;
        boolean notFound = true;
        if(I1.isTower()) {
            ct = I1.getColTower();
            if (!colorT.equals(ct)) {
                for(int i =0; i < SBWhitTower.size() && notFound; i++){
                   if(SBWhitTower.get(i).ColorTower().equals(ct)){
                       for(int j= 0;  j< I1.getSize(); j ++){
                           SBWhitTower.get(i).PutTower();
                       }
                       notFound = false;
                   }
                }
                notFound = true;
                for(int i =0; i < SBWhitTower.size() && notFound; i++){
                    if(SBWhitTower.get(i).ColorTower().equals(colorT)){
                        for(int j= 0;  j< I1.getSize(); j ++){
                            SBWhitTower.get(i).RemoveTower();
                        }
                        notFound = false;

                    }
                }
            I1.putTower(colorT);
            GB.CheckNearTower(I1);
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
            GB.CheckNearTower(I1);
        }

    }
}
