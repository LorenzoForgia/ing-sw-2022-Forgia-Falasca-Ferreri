package it.polimi.ingsw.Model;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * @author Luigia Falasca and Federico Angelo Luigi Ferreri
 * **/

public class CharacterCard1 extends CharacterCard implements Serializable  {

    private ArrayList<Color> choosenStudent = new ArrayList<Color>();
    private Color choosenColor;
    private IslandTiles Ichosen;
    private Bag bag;

    public CharacterCard1(int name, int coins, int countUse, String descriptionEffect) {
        super(name, coins, countUse, descriptionEffect);
    }

    /**Set the card putting 4 students on it
     * **/
    @Override
    public void SetCard(Bag b, GeneralBoard gb) {
        bag = b;
            for (int i = 0; i < 4; i++) {
                if (!bag.BagIsEmpty()) {
                this.choosenStudent.add(bag.CatchStudent());
            }
        }
    }

     /** return the students on the card
     * **/
    public ArrayList<Color> GetchoosenStudent(){
        return choosenStudent;
    }

    /**
     * Move a student from this card to an Island
     * **/
    @Override
    public void UseEffect(Player p) {
        p.setUsedCharacterCard(true);
        p.setNameCharacterCard(1);
        Ichosen.PutStudent(choosenColor);
        choosenStudent.remove(choosenColor);
        if(!bag.BagIsEmpty()){
            this.choosenStudent.add(bag.CatchStudent());
        }
    }

    /** Set the chosen student from the card
     * **/
    public void setChoosenColor(Color choosenColor) {
        this.choosenColor = choosenColor;
    }

    /** Set the chosen Island
     * **/
    public void setIchosen(IslandTiles ichosen) {
        Ichosen = ichosen;
    }
}











