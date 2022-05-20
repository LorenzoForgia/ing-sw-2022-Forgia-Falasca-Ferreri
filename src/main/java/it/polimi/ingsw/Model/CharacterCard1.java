package it.polimi.ingsw.Model;

import java.util.ArrayList;

/** Set the card putting 4 students on it
 * Move a student from this card to an Island
 * The Player should choose the color to pick and the Island
 * **/

public class CharacterCard1 extends CharacterCard{

    private ArrayList<Color> choosenStudent = new ArrayList<Color>();
    Color choosenColor;
    IslandTiles Ichosen;
    Bag bag;

    public CharacterCard1(int name, int coins, int countUse) {
        super(name, coins, countUse);
    }

    @Override
    public void SetCard(Bag b, GeneralBoard gb) {
        bag = b;
        if (!bag.BagIsEmpty()) {
            for (int i = 0; i < 4; i++) {
                this.choosenStudent.add(bag.CatchStudent());
            }
        }
    }

    public ArrayList<Color> GetchoosenStudent(){
        return choosenStudent;
    }


    @Override
    public void UseEffect(Player p) {
        p.setUsedCharacterCard(true);
        p.setNameCharacterCard(1);
        Ichosen.PutStudent(choosenColor);
        if(!bag.BagIsEmpty()){
            this.choosenStudent.add(bag.CatchStudent());
        }
    }

    public void setChoosenColor(Color choosenColor) {
        this.choosenColor = choosenColor;
    }

    public void setIchosen(IslandTiles ichosen) {
        Ichosen = ichosen;
    }
}











