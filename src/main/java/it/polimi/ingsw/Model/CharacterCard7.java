package it.polimi.ingsw.Model;

import java.util.*;

/*@author Luigia Falasca*/

public class CharacterCard7 extends CharacterCard{
    List<Color> StudentsInCard = new ArrayList<>();

    public CharacterCard7(int name, int coins, int countUse) {
        super(name, coins, countUse);
    }

    public void SetCard7(Bag b){
        for(int i=0; i<6; i++){
            StudentsInCard.add(b.CatchStudent());
        }
    }

    public void useEffect7( List<Color> sCard, List<Color> sEntrance, SchoolBoard SB){
        for(int i = 0; i < sEntrance.size(); i++ ){
            SB.RemoveStudent(sEntrance.get(i));
            StudentsInCard.remove(sCard.get(i));
            StudentsInCard.add(sEntrance.get(i));
            SB.AddStudent(sCard.get(i));
        }

    }

}
