package it.polimi.ingsw.Model;
import java.util.*;

public class SchoolBoard {
    private int NumberId;
    private int Student;
    private List<Color> Entrance= new ArrayList<Color>();
    /*private DiningRoom= new DiningRoom();*/
    private List<Color> ProfessorTable= new ArrayList<Color>();
    private List<ColorTower> TowerRoom= new ArrayList<ColorTower>();

    public SchoolBoard(int numberId, int student){
        NumberId=numberId;
        Student=student;
    }
    public void GetId(int id){      /* giving an id to the school_board*/
        NumberId=id;
    }
    public void PutProfessor(Color p){    /* putting professor p in the professor table*/
        ProfessorTable.add(p);
    }
    public boolean ExistProfessor(Color p) {         /*saying if there is the professor p on the professor table or not*/
        if (ProfessorTable.get(p.getIndex()) != null) {
            return true;
        } else {
            return false;
        }
    }
    public void RemoveProfessor(Color p){      /*removing professor p from the professor table*/
        ProfessorTable.remove(p);
    }
    public int GetNumberTower(){     /*getting number of towers in the tower room*/
        return TowerRoom.size() ;
    }
    public void PutTower(ColorTower t){      /*putting tower t in the tower room*/
        TowerRoom.add(t);
    }
    public void PutStudent(Color s){     /*putting student s in the entrance*/
        Entrance.add(s);
    }
    public void RemoveStudent(Color s){     /*removing student s from the entrance*/
        Entrance.remove(s);
    }
    public int GetNumberStudent(){       /*getting number of students in the entrance*/
        return Entrance.size();
    }
}
