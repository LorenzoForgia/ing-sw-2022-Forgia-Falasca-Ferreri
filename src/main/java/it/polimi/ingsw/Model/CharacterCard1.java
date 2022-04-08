package it.polimi.ingsw.Model;

import java.util.ArrayList;
import java.util.Random;

public class CharacterCard1 extends CharacterCard{
    private ArrayList<Color> choosenStudent= new ArrayList<Color>();

    public CharacterCard1(int name, int coins, int countUse) {
        super(name, coins, countUse);
    }

    public void DrawStudent(Bag bag) {
       for (int i = 0; i < 4; i++) {
           this.choosenStudent.add(bag.CatchStudent());
       }
   }
   public Color ChooseStudent(){
       Random random = new Random();
       int draftedindex = random.nextInt(this.choosenStudent.size());
       Color draftedcolor = this.choosenStudent.get(draftedindex);
       this.choosenStudent.remove(draftedindex);
       return draftedcolor;
   }










}
