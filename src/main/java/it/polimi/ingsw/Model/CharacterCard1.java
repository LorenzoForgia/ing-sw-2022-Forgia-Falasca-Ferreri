package it.polimi.ingsw.Model;

import java.util.ArrayList;
import java.util.Random;

public class CharacterCard1 extends CharacterCard {
    private ArrayList<Color> choosenStudent = new ArrayList<Color>();

    public CharacterCard1(int name, int coins, int countUse) {
        super(name, coins, countUse);
    }

    public void DrawStudent(Bag bag) {              /*draw four student from the bag and putting them on the card*/
        for (int i = 0; i < 4; i++) {
            this.choosenStudent.add(bag.CatchStudent());
        }
    }
    public ArrayList<Color> GetchoosenStudent(){    /*method only for tests*/
        return choosenStudent;
    }
    public void PutOnIsland(IslandTiles i, Color c) {      /* player choose student from the card and island and put him on the island*/
        i.PutStudent(c);
    }
    public void AddStudFromBag(Bag bag){         /*add a student draw from the bag on tne card*/
        this.choosenStudent.add(bag.CatchStudent());
    }
}











