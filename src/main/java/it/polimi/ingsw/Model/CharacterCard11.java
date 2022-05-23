package it.polimi.ingsw.Model;
import java.util.*;

/**Set the card putting 4 students on it
 * Move a student from this card to your DiningRoom
 * The Player should choose the color to pick
 * **/
public class CharacterCard11 extends CharacterCard{
    private ArrayList<Color> choosenStudent = new ArrayList<Color>();
    private Color choosenColor;
    private Bag bag;

    public CharacterCard11(int name, int coins, int countUse) {
        super(name, coins, countUse);
    }

    @Override
    public void SetCard(Bag b, GeneralBoard gb) {
        bag= b;
        for (int i = 0; i < 4; i++) {
            this.choosenStudent.add(bag.CatchStudent());
        }
    }

    public ArrayList<Color> GetchoosenStudent(){
        return choosenStudent;
    }


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

    public void setChoosenColor(Color choosenColor) {
        this.choosenColor = choosenColor;
    }

}