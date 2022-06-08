package it.polimi.ingsw.Model;
import java.io.Serializable;


/**
 * @author Luigia Falasca
 * **/

public class CharacterCard8 extends CharacterCard implements Serializable {


    public CharacterCard8(int name, int coins, int countUse, String descriptionEffect) {
        super(name, coins, countUse, descriptionEffect);
    }
    /** Add two points at the influence
     * The real effect is implemented in MoveMotherNature
     * **/
    @Override
    public void UseEffect(Player p) {
        p.setNameCharacterCard(8);
        p.setUsedCharacterCard(true);
    }

    @Override
    public void SetCard(Bag b, GeneralBoard gb) {

    }
}

