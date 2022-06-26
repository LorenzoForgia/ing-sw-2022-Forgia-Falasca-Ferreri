package it.polimi.ingsw.Model;



import java.io.Serializable;
import java.util.*;

/**
 * @author Luigia Falasca
 */
public class DeckCardAssistant implements Serializable {
    List<CardAssistant> Cards = new ArrayList<>();

    public DeckCardAssistant(){
        CardAssistant[] cards = CardAssistant.values();
        for(int i= 0; i < 10; i++ ){
            Cards.add(cards[i]);
        }
    }

    /** remove the card from the deck when the card is been used
     * **/
    public void RemoveCard( CardAssistant c){

        Cards.remove(Cards.indexOf(c));

    }

    public List<CardAssistant> GetDeck(){
        return Cards;
    }
}
