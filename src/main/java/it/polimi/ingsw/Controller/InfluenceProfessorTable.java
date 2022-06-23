package it.polimi.ingsw.Controller;
import it.polimi.ingsw.Model.*;

import java.util.ArrayList;

/**
 *  @author Luigia Falasca
 *  **/

public class InfluenceProfessorTable {
    private boolean alreadyUsedEffect2= false;
    private ArrayList<ArrayList<Color>> oldProfessor= new ArrayList();

    /** Return the color from the index
     * **/
    private Color GetRightColor(int index ){
        if(index==0){
            return Color.Green;
        }else if(index==1){
            return Color.Red;
        }else if(index==2){
            return  Color.Yellow;
        }else if(index==3){
            return Color.Pink;
        }else {
            return  Color.Blue;
        }
    }

    /** Remove the professor if it was placed in SchoolBoard
     * **/
    private void RemoveProfessorFromTable(GeneralBoard gb, int numberOfPlayer, Color color){
        boolean notFound = true;
        for(int i=0; i< numberOfPlayer && notFound; i++){
            for(int j=0; j < gb.getSchoolBoard().get(i).getProfessorTable().size() && notFound; j++){
                if(gb.getSchoolBoard().get(i).getProfessorTable().get(j).equals(color)){
                    gb.getSchoolBoard().get(i).RemoveProfessor(color);
                    notFound = false;
                }
            }
        }
    }

    /** If the students in the dining room are zero but there is the professor,
     * this methods remove the professor
     * **/
    private void RemoveProfessorWhenNoStudentInDining(GeneralBoard GB, int numPlayer){

        for(int i=0; i <5; i++){
            for(int j=0; j< numPlayer; j++){
                if(GB.getSchoolBoard().get(j).getProfessorTable().contains(GetRightColor(i))){
                    if(GB.getSchoolBoard().get(j).getDiningRoom().GetNumberStudent(i)==0){
                        GB.getSchoolBoard().get(j).getProfessorTable().remove(GetRightColor(i));
                    }
                }
            }
        }
    }

    /** Calculates who has the control of the professor
     * **/
    public void RightProfessorTable(GeneralBoard GB, int numPlayer) {
        int max;
        int schoolBoardWithInfluence=0;
        boolean isInfluence = false;
        for (int j = 0; j < 5; j++) {
            max = 0;
            for (int i = 0; i < numPlayer; i++) {
                if (max < GB.getSchoolBoard().get(i).getDiningRoom().GetNumberStudent(j)) {
                    max = GB.getSchoolBoard().get(i).getDiningRoom().GetNumberStudent(j);
                    isInfluence = true;
                    schoolBoardWithInfluence = i;
                }else if(max == GB.getSchoolBoard().get(i).getDiningRoom().GetNumberStudent(j)){
                    isInfluence = false;
                }
            }
            if(isInfluence){

                    RemoveProfessorFromTable(GB, numPlayer, GetRightColor(j));
                    try {
                        GB.getSchoolBoard().get(schoolBoardWithInfluence).PutProfessor(GetRightColor(j));
                    } catch (IllegalMoveException e) {

                }
            }
        }

        RemoveProfessorWhenNoStudentInDining(GB, numPlayer);
    }

    /**Professor Table with the effect of CharacterCard2**/
    public void RightProfessorTable(GeneralBoard GB, int numPlayer, Player playerUseEffect) {
        int max;
        int schoolBoardWithInfluence=0;
        boolean isInfluence = false;
        if(!alreadyUsedEffect2){
            alreadyUsedEffect2= true;
            for(int i=0; i <numPlayer; i++){
                oldProfessor.add(GB.getSchoolBoard().get(i).getProfessorTable());
            }
        }

        for (int j = 0; j < 5; j++) {
            max = 0;
            for (int i = 0; i < numPlayer; i++) {
                if (playerUseEffect.getMySchoolBoard().equals(GB.getSchoolBoard().get(i))) {
                    if (max <= GB.getSchoolBoard().get(i).getDiningRoom().GetNumberStudent(j) && GB.getSchoolBoard().get(i).getDiningRoom().GetNumberStudent(j)!=0) {
                        max = GB.getSchoolBoard().get(i).getDiningRoom().GetNumberStudent(j);
                        isInfluence = true;
                        schoolBoardWithInfluence = i;
                    }
                } else {
                    if (max < GB.getSchoolBoard().get(i).getDiningRoom().GetNumberStudent(j)) {
                        max = GB.getSchoolBoard().get(i).getDiningRoom().GetNumberStudent(j);
                        isInfluence = true;
                        schoolBoardWithInfluence = i;
                    } else if (max == GB.getSchoolBoard().get(i).getDiningRoom().GetNumberStudent(j)) {
                        isInfluence = false;
                    }
                }
            }
            if(isInfluence){

                RemoveProfessorFromTable(GB, numPlayer, GetRightColor(j));
                try {
                    GB.getSchoolBoard().get(schoolBoardWithInfluence).PutProfessor(GetRightColor(j));
                } catch (IllegalMoveException e) {

                }
            }
        }
        RemoveProfessorWhenNoStudentInDining(GB, numPlayer);
    }

    public void comeBackAfterUsingCharacterCard2(GeneralBoard GB, int numPlayer){
        if(alreadyUsedEffect2){
            alreadyUsedEffect2= false;
            for(int i=0; i< 5; i++){
                RemoveProfessorFromTable(GB,numPlayer, GetRightColor(i));
            }
            for(int i=0; i< numPlayer; i++){
                for(int j=0; j< oldProfessor.get(i).size(); i++){
                    try{
                        GB.getSchoolBoard().get(i).PutProfessor(oldProfessor.get(i).get(j));
                    }catch(IllegalMoveException e){

                    }
                }
            }
        }
    }
}
