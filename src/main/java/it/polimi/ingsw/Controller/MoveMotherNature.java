package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.*;
import jdk.dynalink.linker.support.CompositeTypeBasedGuardingDynamicLinker;

import java.util.ArrayList;
import java.util.List;

public class MoveMotherNature {
    IslandTiles I1;
    List<List<Color>> listProfessor = new ArrayList<>();
    ColorTower colorT;
    List<ColorTower> colorTowerList = new ArrayList<>();


    public void SetIslandWithMotherNature(IslandTiles I){
        I1 = I;
    }

    public void MoveMN(GeneralBoard GB, int n){
        I1 = GB.moveMotherNature(I1, n);
    }

    private int influenceTot(List<Color> student, IslandTiles I ){
        int influence=0;
        for(int i =0 ; i < student.size(); i++){
            influence= influence +I.CountInfluence(student.get(i));
        }
        return influence;
    }

    private void GetSquadIf4Players(GeneralBoard GB){
        ColorTower ct;
        boolean flag = true;
        List<SchoolBoard> lSB =GB.getSchoolBoard();
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
    }

    private void GetArrayForInfluence(GeneralBoard GB){
        List<SchoolBoard> lSB =GB.getSchoolBoard();
        for(int i=0; i < lSB.size(); i ++){
            listProfessor.get(i).addAll(lSB.get(i).getProfessorTable());
            colorTowerList.add(i, lSB.get(i).ColorTower());
        }
    }

    public boolean CheckIfIslandGetControlled(int numberPlayer, GeneralBoard GB){
        int influenceTower=0;
        List<Integer> listInfluence = new ArrayList<>();

        boolean flag = false;
        if(I1.isTower()){
            colorT = I1.getColTower();
            influenceTower= 1;
            flag= true;
        }

        if(numberPlayer==4) {
            GetSquadIf4Players(GB);
        }else{
            GetArrayForInfluence(GB);
        }
        for(int i=0; i< listProfessor.size(); i++){
          /*  listInfluence.add(i) = influenceTot(listProfessor.get(i), I1);*/
        }
        return flag;
    }
}
