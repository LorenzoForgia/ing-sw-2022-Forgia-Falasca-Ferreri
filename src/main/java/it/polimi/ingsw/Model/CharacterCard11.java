package it.polimi.ingsw.Model;
import java.io.Serializable;
import java.util.*;


/** @author Lorenzo Forgia and Luigia Falasca **/
public class CharacterCard11 extends CharacterCard implements Serializable {
    private ArrayList<Color> choosenStudent = new ArrayList<Color>();
    private Color choosenColor;
    private Bag bag;

    public CharacterCard11(int name, int coins, int countUse, String descriptionEffect) {
        super(name, coins, countUse, descriptionEffect);
    }

    /** Set the card putting 4 students on it
     * **/
    @Override
    public void SetCard(Bag b, GeneralBoard gb) {
        bag= b;
        for (int i = 0; i < 4; i++) {
            this.choosenStudent.add(bag.CatchStudent());
        }
    }
/** return the students on this card
 * **/
    public ArrayList<Color> GetchoosenStudent(){
        return choosenStudent;
    }

    /**
     * Move a student from this card to your DiningRoom **/
    @Override
    public void UseEffect(Player p) {
        p.setNameCharacterCard(11);
        p.setUsedCharacterCard(true);
        int flag=0;
        for(int i=0;flag==0 && i< choosenStudent.size();i++){
            if(choosenStudent.get(i).equals(choosenColor)){
                p.getMySchoolBoard().getDiningRoom().PutStudent(choosenStudent.get(i));
                choosenStudent.remove(i);
                if(!bag.BagIsEmpty()) {
                    choosenStudent.add(bag.CatchStudent());
                }
                flag = 1;
            }
        }
    }
/** Set the chosen color of student
 * **/
    public void setChoosenColor(Color choosenColor) {
        this.choosenColor = choosenColor;
    }

}