package it.polimi.ingsw.Model;
import java.io.Serializable;
import java.util.*;

/** @author Lorenzo Forgia and Luigia Falasca **/
public class CharacterCard10 extends CharacterCard implements Serializable {

    private ArrayList<Color> studentOnEntrance=new ArrayList<Color>();
    private ArrayList<Color> studentOnDiningRoom=new ArrayList<Color>();

    public CharacterCard10(int name, int coins, int countUse, String descriptionEffect) {
        super(name, coins, countUse, descriptionEffect);
    }

    /** Exchange up to 2 students between your Entrance and your DiningRoom
     * **/
    @Override
    public void UseEffect(Player p) {
        p.setNameCharacterCard(10);
        p.setUsedCharacterCard(true);
        for(int i=0;i<studentOnEntrance.size();i++){
            p.getMySchoolBoard().RemoveStudent(studentOnEntrance.get(i));
            p.getMySchoolBoard().AddStudent(studentOnDiningRoom.get(i));
            p.getMySchoolBoard().getDiningRoom().RemoveStudent(studentOnDiningRoom.get(i));
            p.getMySchoolBoard().getDiningRoom().PutStudent(studentOnEntrance.get(i));

        }
    }

    @Override
    public void SetCard(Bag b, GeneralBoard gb) {

    }

    public void setStudentOnEntrance(ArrayList<Color> studentOnEntrance) {
        this.studentOnEntrance = studentOnEntrance;
    }

    public void setStudentOnDiningRoom(ArrayList<Color> studentOnDiningRoom) {
        this.studentOnDiningRoom = studentOnDiningRoom;
    }
}
