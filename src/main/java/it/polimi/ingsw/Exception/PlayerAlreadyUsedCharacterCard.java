package it.polimi.ingsw.Exception;

import it.polimi.ingsw.Model.CharacterCard;

public class PlayerAlreadyUsedCharacterCard extends Exception{
    public PlayerAlreadyUsedCharacterCard() {
        super("Already used a special effect");
    }

}
