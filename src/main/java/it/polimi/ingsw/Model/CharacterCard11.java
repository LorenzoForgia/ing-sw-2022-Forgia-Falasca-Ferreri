package it.polimi.ingsw.Model;
import java.util.*;

public class CharacterCard11 extends CharacterCard{
    List<Color> students=new ArrayList<Color>();
    public CharacterCard11(int name, int coins, int countUse) {
        super(name, coins, countUse);
    }
    public void draft4students(Bag b){
        for(int i=0;i<4;i++){
            students.add(b.CatchStudent());
        }
    }
    public void useEffect11(Color c,SchoolBoard sb,Bag b){
        int flag=0;
        for(int i=0;flag==0 && i<4;i++){
            if(students.get(i).equals(c)){
                sb.getDiningRoom().PutStudent(students.get(i));
                students.remove(i);
                students.add(b.CatchStudent());
                flag=1;
            }
        }
    }

    public List<Color> getStudents() {  /** only for test**/
        return students;
    }
}
