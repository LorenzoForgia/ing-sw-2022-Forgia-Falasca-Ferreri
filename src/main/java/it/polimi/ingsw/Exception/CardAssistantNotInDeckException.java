package it.polimi.ingsw.Exception;

import it.polimi.ingsw.Model.*;

public class CardAssistantNotInDeckException extends Exception {
    public CardAssistantNotInDeckException() {
        super("Color not in Entrance");
    }

    public CardAssistantNotInDeckException(CardAssistant c) {
        super(" Card number " + c.name() + "is not in your Deck");
    }
}
