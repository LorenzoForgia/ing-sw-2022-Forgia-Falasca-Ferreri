package it.polimi.ingsw.Exception;

import it.polimi.ingsw.Model.*;

public class CardAssistantNotAvailableException extends Exception {
    public CardAssistantNotAvailableException() {
        super("The card is already been used");
    }

    public CardAssistantNotAvailableException(CardAssistant c) {
        super(" Card number " + c.name() + "is already been used");
    }
}
