package it.polimi.ingsw.Model;

/*@author Luigia Falasca*/

/** Add two points at the influence
 * The real effect is implemented in MoveMotherNature
 * **/

public class CharacterCard8 extends CharacterCard {


    public CharacterCard8(int name, int coins, int countUse, String descriptionEffect) {
        super(name, coins, countUse, descriptionEffect);
    }

    @Override
    public void UseEffect(Player p) {
        p.setNameCharacterCard(8);
        p.setUsedCharacterCard(true);
    }

    @Override
    public void SetCard(Bag b, GeneralBoard gb) {

    }
}

