package it.polimi.ingsw.Exception;

import it.polimi.ingsw.Model.CharacterCard;

public class CharacterCardNotInTableException extends Exception {
    public CharacterCardNotInTableException() {
        super("The card is not in table");
    }

    public CharacterCardNotInTableException(CharacterCard c) {
        super(" Card number " + c.getName() + "is not in table");
    }

}
