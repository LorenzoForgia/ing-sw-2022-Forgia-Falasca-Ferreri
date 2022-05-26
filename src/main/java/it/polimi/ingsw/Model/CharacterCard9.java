package it.polimi.ingsw.Model;
/** @author Lorenzo Forgia **/

import java.io.Serializable;

/** The chosen Color doesn't count for the influence
 * The real effect is implemented in MoveMotherNature
 * **/
public class CharacterCard9  extends CharacterCard implements Serializable {



    private Color chosenColor;

    public CharacterCard9(int name, int coins, int countUse, String descriptionEffect) {
        super(name, coins, countUse, descriptionEffect);
    }

    @Override
    public void UseEffect(Player p) {
        p.setNameCharacterCard(9);
        p.setUsedCharacterCard(true);
    }

    @Override
    public void SetCard(Bag b, GeneralBoard gb) {

    }

    public Color getChosenColor() {
        return chosenColor;
    }

    public void setChosenColor(Color chosenColor) {
        this.chosenColor = chosenColor;
    }
}
