package it.polimi.ingsw.Model;
import java.util.*;

public class SchoolBoard {
    private int NumberId;
    private int Student;
    private ColorTower colorTower;
    private List<Color> Entrance= new ArrayList<Color>();
    private DiningRoom diningRoom= new DiningRoom();
    private List<Color> ProfessorTable= new ArrayList<Color>();
    private List<ColorTower> TowerRoom= new ArrayList<ColorTower>();

    public SchoolBoard(int numberId, int student){
        NumberId=numberId;
        Student= student;
    }
    public int GetId(){      /* giving an id to the school_board*/
        return NumberId;
    }
    public void PutProfessor(Color p){    /* putting professor p in the professor table*/
        ProfessorTable.add(p);
    }
    public List<Color> getProfessorTable() {  /* getting professor table to calculate influence*/
        return ProfessorTable;
    }
    public void RemoveProfessor(Color p){      /*removing professor p from the professor table*/
        ProfessorTable.remove(p);
    }
    /*towerroom è da settare nel controller*/
    public int GetNumberTower(){     /*getting number of towers in the tower room*/
        return TowerRoom.size() ;
    }
    public void PutTower(ColorTower t){      /*putting tower t in the tower room*/
        TowerRoom.add(t);
    }
    public void RemoveTower(ColorTower t){
        TowerRoom.remove(t);
    }
    public ColorTower ColorTower(){      /* color towers in the school board*/
        return colorTower;
    }

    public void setColorTower(ColorTower colorTower) {  /* set color tower in the school board*/
        this.colorTower = colorTower;
    }

    public void PutStudent(int NumPlayers, Bag bag){     /*putting students in the entrance from the bag*/
        if(NumPlayers==3){
            for(int i=0;i<9;i++){       /* case 3 players*/
                this.Entrance.add(bag.CatchStudent());
            }
        }else{
            for(int i=0;i<7;i++){      /*case 2 or 4 players*/
                this.Entrance.add(bag.CatchStudent());
            }
        }
    }
    public void RemoveStudent(Color s){     /*removing student s from the entrance*/
        Entrance.remove(s);
    }
    public int GetNumberStudent(){       /*getting number of students in the entrance*/
        return Entrance.size();
    }
    public void AddStudent(Color s){     /* add student s in the entrance*/
        Entrance.add(s);
    }
    public DiningRoom getDiningRoom() {
        return this.diningRoom;
    }

    public List<Color> getEntrance(){
        return Entrance;
    }


    /**the next method is only for tests**/
    public int GetNumberStudent(Color c){
        int countercolorstud=0;
        for(int i=0;i<Entrance.size();i++){
            if(Entrance.get(i).equals(c)){
                countercolorstud++;
            }
        }
        return countercolorstud;
    }
}
