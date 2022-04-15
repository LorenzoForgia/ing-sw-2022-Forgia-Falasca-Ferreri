package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.*;
import jdk.dynalink.linker.support.CompositeTypeBasedGuardingDynamicLinker;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.XMLFormatter;

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

    private int influenceTot(List<Color> student, IslandTiles I, ColorTower ct ){
        int influence=0;
        int influenceT = 0;
        if(I.isTower()){
            colorT= I.getColTower();
            if(I.getColTower().equals(ct)){
                influenceT = 1 * I.getSize();
            }
        }
        for(int i =0 ; i < student.size(); i++){
            influence= influence +I.CountInfluence(student.get(i)) + influenceT;
        }
        return influence;
    }

    private ArrayList<ArrayList<Color>> GetSquadIf4Players(GeneralBoard GB){
        ColorTower ct;
        boolean flag = true;
        List<SchoolBoard> lSB =GB.getSchoolBoard();
        ArrayList<ArrayList<Color>> listProfessor = new ArrayList<>(2);

        for(int i=0; i< 2; i ++){
            listProfessor.add(new ArrayList<>());
        }

        for(int i=0; i < lSB.size(); i ++){
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


    public boolean CheckIfIslandGetControlled(int numberPlayer, GeneralBoard GB){
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
            listInfluence.add(i, influenceTot(listProfessor.get(i), I1, colorTowerList.get(i)));
        }

        for(int i=0; i< listInfluence.size(); i++){
            max= listInfluence.get(i);
            ct = colorTowerList.get(i);
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
        }
        colorT = ct;
        return flag;
    }

    public void GetRightTowerOnIsland(GeneralBoard GB, List<SchoolBoard> SBWhitTower){
        ColorTower ct = I1.getColTower();
        boolean notFound = true;
        if(I1.isTower()) {
            if (!colorT.equals(ct)) {
                for(int i =0; i < SBWhitTower.size() && notFound; i++){
                   if(SBWhitTower.get(i).ColorTower().equals(ct)){
                       SBWhitTower.get(i).PutTower(ct);
                       notFound = false;
                   }
                }
                notFound = true;
                for(int i =0; i < SBWhitTower.size() && notFound; i++){
                    if(SBWhitTower.get(i).ColorTower().equals(ct)){
                        SBWhitTower.get(i).RemoveTower(colorT);
                        notFound = false;
                    }
                }
            I1.putTower(colorT);
            }
        }else{
            notFound = true;
            for(int i =0; i < SBWhitTower.size() && notFound; i++) {
                if (SBWhitTower.get(i).ColorTower().equals(ct)) {
                    SBWhitTower.get(i).RemoveTower(colorT);
                    notFound = false;
                }
            }
            I1.putTower(colorT);
        }

    }
}
