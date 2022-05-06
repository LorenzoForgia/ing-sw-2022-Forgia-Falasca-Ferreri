package it.polimi.ingsw.Controller;
import it.polimi.ingsw.Model.*;

/*@author Luigia Falasca*/

public class InfluenceProfessorTable {


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
    }

    /*Professor Table with the effect of CharacterCard2*/
    public void RightProfessorTable(GeneralBoard GB, int numPlayer, CharacterCard c, Player playerUseEffect) {
        int max;
        int schoolBoardWithInfluence=0;
        boolean isInfluence = false;

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

        c.setCountUse();
    }
}
