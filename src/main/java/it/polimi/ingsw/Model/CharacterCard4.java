package it.polimi.ingsw.Model;

public class CharacterCard4 extends CharacterCard{
    public CharacterCard4(int name, int coins, int countUse) {
        super(name, coins, countUse);
    }

    public int AddTwoMvntMN(CardAssistant a){     /* player can move nature mother two more position*/
        return a.getMovementMN()+2;
    }
}
