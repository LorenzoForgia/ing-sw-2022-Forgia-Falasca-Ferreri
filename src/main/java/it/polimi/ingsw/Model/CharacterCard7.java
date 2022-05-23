package it.polimi.ingsw.Model;

import java.util.*;

/*@author Luigia Falasca*/

/** Take up to 3 students from this card and replace them with the same number of
 * students from your Entrance
 * **/

public class CharacterCard7 extends CharacterCard {
    private ArrayList<Color> studentOnCard = new ArrayList<Color>();
    private Bag bag;
    private ArrayList<Color> studentOnEntrance=new ArrayList<Color>();
    private ArrayList<Color> studentChoosen=new ArrayList<Color>();

    public CharacterCard7(int name, int coins, int countUse) {
        super(name, coins, countUse);
    }


    @Override
    public void UseEffect(Player p) {
        p.setNameCharacterCard(7);
        p.setUsedCharacterCard(true);
        for(int i=0; i< studentOnEntrance.size(); i++){
            studentOnCard.add(studentOnEntrance.get(i));
            p.getMySchoolBoard().RemoveStudent(studentOnEntrance.get(i));
            p.getMySchoolBoard().getEntrance().add(studentChoosen.get(i));
            studentOnCard.remove(studentChoosen.get(i));
        }
    }

    @Override
    public void SetCard(Bag b, GeneralBoard gb) {
        bag= b;
        for (int i = 0; i < 6; i++) {
            studentOnCard.add(bag.CatchStudent());
        }
    }

    public ArrayList<Color> getStudentOnCard() {
        return studentOnCard;
    }

    public void setStudentOnEntrance(ArrayList<Color> studentOnEntrance) {
        this.studentOnEntrance = studentOnEntrance;
    }

    public void setStudentChoosen(ArrayList<Color> studentChoosen) {
        this.studentChoosen = studentChoosen;
    }
}


