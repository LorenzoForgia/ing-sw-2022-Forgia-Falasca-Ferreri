package it.polimi.ingsw.Model;

import java.io.Serializable;

/**
 * @author Luigia Falasca and Federico Angelo Luigi Ferreri
 * **/

public class CharacterCard4 extends CharacterCard implements Serializable {
    public CharacterCard4(int name, int coins, int countUse, String descriptionEffect) {
        super(name, coins, countUse, descriptionEffect);
    }

    @Override
    public void UseEffect(Player p) {
        p.setNameCharacterCard(4);
        p.setUsedCharacterCard(true);
    }

    @Override
    public void SetCard(Bag b, GeneralBoard gb) {

    }
    /** Adds two movements to MotherNature
     * **/
    public int AddTwoMvntMN(CardAssistant a){

        return a.getMovementMN()+2;
    }
}

