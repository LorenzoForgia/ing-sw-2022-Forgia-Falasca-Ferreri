package it.polimi.ingsw.Model;

/** Adds two movements to MotherNature
 * The player doesn't have to choose anything**/
public class CharacterCard4 extends CharacterCard {
    public CharacterCard4(int name, int coins, int countUse) {
        super(name, coins, countUse);
    }

    @Override
    public void UseEffect(Player p) {

    }

    @Override
    public void SetCard(Bag b, GeneralBoard gb) {

    }

    public int AddTwoMvntMN(CardAssistant a){     /* player can move nature mother two more position*/
        return a.getMovementMN()+2;
    }
}

