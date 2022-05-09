package it.polimi.ingsw.Exception;

import it.polimi.ingsw.Model.CharacterCard;

public class NotEnoughCoinException extends Exception{
    public NotEnoughCoinException() {
        super("Not enough coins");
    }

    public NotEnoughCoinException(int n, CharacterCard c) {
        super("You have " + n + "coins, the card costs" + c.getCost());
    }
}
