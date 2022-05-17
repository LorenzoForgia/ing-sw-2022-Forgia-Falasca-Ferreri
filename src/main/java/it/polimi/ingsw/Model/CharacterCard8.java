package it.polimi.ingsw.Model;

/*@author Luigia Falasca*/

public class CharacterCard8 extends CharacterCard {


    public CharacterCard8(int name, int coins, int countUse) {
        super(name, coins, countUse);
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

