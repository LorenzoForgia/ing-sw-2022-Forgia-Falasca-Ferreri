package it.polimi.ingsw.Model;
import java.util.*;

/**
 * @author Lorenzo Forgia
 */
public class Bag {
    private List<Color> students=new ArrayList<Color>();

/** setStudents: in the beginning of game 10 students,then 120 **/
    public void setStudents(int numstudents) {
        Color[] c=Color.values();
        for(Color colorstudent:c){
            for(int i=0;i<(numstudents/5);i++){
                students.add(colorstudent);
            }
        }
    }
/** method to draft students randomly**/
    public Color CatchStudent() {
        Random random = new Random();
        int draftedindex = random.nextInt(this.students.size());
        Color draftedcolor = this.students.get(draftedindex);
        this.students.remove(draftedindex);
        return draftedcolor;
    }

    /** method to insert student in bag ,for example when each player must remove 3 students from his
     * dining room
     */
    public void PutStudent(Color stud){
        this.students.add(stud);
    }

    /** method to check Bag is empty(called by Controller) **/
    public boolean BagIsEmpty(){
        if(this.students.size()==0){
            return true;
        }else{
            return false;
        }
    }

    /** only for test**/
    public List<Color> getStudents() {
        return students;
    }
}
