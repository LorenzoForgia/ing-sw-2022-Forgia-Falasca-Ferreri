package it.polimi.ingsw.Model;
import java.io.Serializable;
import java.util.*;

/**
 * @author Lorenzo Forgia
 */
public class CloudTiles implements Serializable {
    private int Numid;
    private List<Color> stud=new ArrayList<>();

    public CloudTiles(int numid) {
        this.Numid = numid;
    }

    public int getNumid() {
        return this.Numid;
    }


   /** method used to take students from cloudtiles**/
    public List<Color> CatchStudent() {
        List<Color> studentstoreturn=stud;
        this.stud=new ArrayList<>();
        return studentstoreturn;
    }

    /**insert student into CloudTiles drafted from bag **/
    public void PutStudents(int Numplayers,Bag bag) {
        int numstudents=3;
        if(Numplayers==3){
            numstudents=4;
        }
        for(int i=0;i<numstudents;i++) {
            if (!bag.BagIsEmpty()) {
                this.stud.add(bag.CatchStudent());
            }
        }
    }

    /** only for the tests**/
    public List<Color> getStud() {
        return stud;
    }
}
