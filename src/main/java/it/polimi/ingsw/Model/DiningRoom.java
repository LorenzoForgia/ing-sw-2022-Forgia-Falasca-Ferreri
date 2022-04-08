package it.polimi.ingsw.Model;
import java.util.*;
import java.util.ArrayList;

public class DiningRoom implements Location{
    private ArrayList<ArrayList<Color>> DiningRoom=new ArrayList<ArrayList<Color>>();

    public DiningRoom(ArrayList<ArrayList<Color>> diningRoom) {
        DiningRoom = diningRoom;
    }
    public void PutStudent(Color s){     /*putting student s in the dining room*/
        DiningRoom.get(s.getIndex()).add(s);
    }
    public void RemoveStudent(Color s) {     /*removing student s from the dining room*/
        DiningRoom.get(s.getIndex()).remove(s);
    }
    public int GetNumberStudent(){       /*getting number of students in the dining room*/
        return DiningRoom.size();
    }

    public int GetNumberStudent(Color c){       /*getting number of students in the dining room of one color*/
        return DiningRoom.get(c.getIndex()).size();
    }

    public boolean GetCoin(Color s){     /* expert game: if student's place is the third, sixth or ninth the student has to get a coin*/
        if(DiningRoom.get(s.getIndex()).indexOf(s)==3 || DiningRoom.get(s.getIndex()).indexOf(s)==6 || DiningRoom.get(s.getIndex()).indexOf(s)==9 ){
            return true;
        }else{
            return false;
        }
    }

}
