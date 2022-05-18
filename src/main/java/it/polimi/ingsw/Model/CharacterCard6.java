package it.polimi.ingsw.Model;

/*@author Luigia Falasca*/


/** Tower doesn't influence
 * The player does not have to choose anything
 * The real effect is implemented in MoveMotherNature
 * **/
public class CharacterCard6 extends CharacterCard{

    public CharacterCard6(int name, int coins, int countUse) {
        super(name, coins, countUse);
    }

    @Override
    public void UseEffect(Player p) {
        p.setNameCharacterCard(6);
        p.setUsedCharacterCard(true);
    }

    @Override
    public void SetCard(Bag b, GeneralBoard gb) {
    }

}