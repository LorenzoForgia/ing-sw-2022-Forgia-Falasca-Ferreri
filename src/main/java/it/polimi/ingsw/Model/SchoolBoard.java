package it.polimi.ingsw.Model;
import java.util.*;

public class SchoolBoard {
    private int NumberId;
    private int Student;
    private List<Color> Entrance= new ArrayList<Color>();
    /*private DiningRoom= new DiningRoom();*/
    private List<Color> ProfessorTable= new ArrayList<Color>();
    /*private <ColorTower> TowerRoom= new ArrayList<ColorTower>();*/

    public SchoolBoard(){
        NumberId=0;
        Student=0;
    }
    public void GetId(int id){      /* giving an id to the school_board*/
        NumberId=id;
    }
    public void PutProfessor(Color p){    /* putting a professor in the professor table*/
        ProfessorTable.add(p);
    }
    /*public boolean ExistProfessor(Color p){         saying if there is the professor p on the professor table or not
        if(ProfessorTable.get(Color.GetIndex)==p){
                return true;
        }
        else{
            return false;
        }*/
    public void RemoveProfessor(Color p){      /*removing professor p from the professor table*/
        ProfessorTable.remove(p);
    }
    /*public int GetNumberTower(){     Getting the number of the towers in the tower room
        return TowerRoom.size() ;
    }*/
    /*public void PutTower(ColorTower t){      putting tower t in the tower room
        TowerRoom.add(t);
    }*/
}
