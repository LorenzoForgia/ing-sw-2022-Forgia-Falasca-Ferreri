package it.polimi.ingsw.Model;

import java.io.Serializable;

/**
 * @author Luigia Falasca
 * **/


public class CharacterCard6 extends CharacterCard implements Serializable {

    public CharacterCard6(int name, int coins, int countUse, String descriptionEffect) {
        super(name, coins, countUse, descriptionEffect);
    }
    /** Tower doesn't influence
     * The real effect is implemented in MoveMotherNature
     * **/
    @Override
    public void UseEffect(Player p) {
        p.setNameCharacterCard(6);
        p.setUsedCharacterCard(true);
    }

    @Override
    public void SetCard(Bag b, GeneralBoard gb) {
    }

}