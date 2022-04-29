package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.*;

import java.util.List;

public class Move3Students {
    public void ChooseIsland(Color c, IslandTiles i, Player p) {
        p.getMySchoolBoard().getEntrance().remove(c);
        i.PutStudent(c);
    }

    public void ChooseDiningRoom(Color c, Player p) {
        p.getMySchoolBoard().getDiningRoom().PutStudent(c);
        p.getMySchoolBoard().getEntrance().remove(c);
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
                if(j == 0) {
                    try {
                        GB.getSchoolBoard().get(schoolBoardWithInfluence).PutProfessor(Color.Green);
                    } catch (IllegalMoveException e) {

                    }
                }
                if(j == 1){
                    try {
                        GB.getSchoolBoard().get(schoolBoardWithInfluence).PutProfessor(Color.Red);
                    } catch (IllegalMoveException e) {

                    }
                }

                if(j == 2) {
                    try {
                        GB.getSchoolBoard().get(schoolBoardWithInfluence).PutProfessor(Color.Yellow);
                    } catch (IllegalMoveException e) {

                    }
                }

                if(j == 3) {
                    try {
                        GB.getSchoolBoard().get(schoolBoardWithInfluence).PutProfessor(Color.Pink);
                    } catch (IllegalMoveException e) {

                    }
                }
                if(j == 4) {
                    try {
                        GB.getSchoolBoard().get(schoolBoardWithInfluence).PutProfessor(Color.Blue);
                    } catch (IllegalMoveException e) {

                    }
                }
            }
        }
    }
}
