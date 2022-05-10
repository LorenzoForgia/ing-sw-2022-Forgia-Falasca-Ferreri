package it.polimi.ingsw.Exception;

import it.polimi.ingsw.Model.*;

public class CardAssistantNotInDeckException extends Exception {
    public CardAssistantNotInDeckException() {
        super("The card is not in your deck");
    }

    public CardAssistantNotInDeckException(CardAssistant c) {
        super(" Card number " + c.name() + "is not in your Deck");
    }
}
