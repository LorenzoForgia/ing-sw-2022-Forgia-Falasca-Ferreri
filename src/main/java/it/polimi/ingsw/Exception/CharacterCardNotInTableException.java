package it.polimi.ingsw.Exception;

import it.polimi.ingsw.Model.CharacterCard;

public class CharacterCardNotInTableException extends Exception {
    public CharacterCardNotInTableException() {
        super("Color not in Entrance");
    }

    public CharacterCardNotInTableException(CharacterCard c) {
        super(" Card number " + c.getName() + "is not in your Deck");
    }

}
