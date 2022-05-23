package it.polimi.ingsw.Model;
import java.util.*;

/** Exchange up to 2 students between your Entrance and your DiningRoom
 * **/
public class CharacterCard10 extends CharacterCard {


    public CharacterCard10(int name, int coins, int countUse) {
        super(name, coins, countUse);
    }
    private ArrayList<Color> studentOnEntrance=new ArrayList<Color>();
    private ArrayList<Color> studentOnDiningRoom=new ArrayList<Color>();

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
