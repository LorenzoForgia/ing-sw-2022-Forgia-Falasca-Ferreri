package it.polimi.ingsw.Model;
import java.io.Serializable;
import java.util.*;
import java.util.ArrayList;

/**
 * @author Federico Angelo Luigi Ferreri
 */
public class DiningRoom implements Location, Serializable {

    private ArrayList<ArrayList<Color>> DiningRoom=new ArrayList<ArrayList<Color>>(5);
    public DiningRoom(){
        for(int i=0;i<5;i++){
            DiningRoom.add(new ArrayList<>());
        }
    }
    public ArrayList<ArrayList<Color>> getDiningRoom() {
        return DiningRoom;
    }
    public void PutStudent(Color s){     /*putting student s in the dining room*/
        DiningRoom.get(s.getIndex()).add(s);
    }
    public void RemoveStudent(Color s) {     /*removing student s from the dining room*/
        DiningRoom.get(s.getIndex()).remove(s);
    }
    /**getting number of students in the dining room**/
    public int GetNumberStudent(){
        int numberStudentTOT=0;
        for(int i=0;i<5;i++){
            numberStudentTOT=numberStudentTOT+DiningRoom.get(i).size();
        }
        return numberStudentTOT;
    }
    /**getting number of students in the dining room by index**/
    public int GetNumberStudent(int i){
        return DiningRoom.get(i).size();
    }
    /**getting number of students in the dining room by color**/
    public int GetNumberStudent(Color c){
        return DiningRoom.get(c.getIndex()).size();
    }

    /** expert game: if student's place is the third, sixth or ninth the student has to get a coin**/
    public boolean GetCoin(Color s){
        if(DiningRoom.get(s.getIndex()).size()==3 || DiningRoom.get(s.getIndex()).size()==6 || DiningRoom.get(s.getIndex()).size()==9 ){
            return true;
        }else{
            return false;
        }
    }

}
