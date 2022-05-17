package it.polimi.ingsw.Model;

/** Take the control of the professor even if you have the same number of students in the dining room
 * The player doesn't have to choose anything
 * **/

public class CharacterCard2 extends CharacterCard {


    public CharacterCard2(int name, int coins, int countUse) {
        super(name, coins, countUse);
    }

    @Override
    public void UseEffect(Player p) {

    }

    @Override
    public void SetCard(Bag b, GeneralBoard gb) {

    }
}
