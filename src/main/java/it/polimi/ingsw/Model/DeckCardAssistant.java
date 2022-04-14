package it.polimi.ingsw.Model;

/*@author Luigia Falasca*/

import java.util.*;

public class DeckCardAssistant {
    List<CardAssistant> Cards = new ArrayList<>();

    public DeckCardAssistant(){
        CardAssistant[] cards = CardAssistant.values();
        for(int i= 0; i < 10; i++ ){
            Cards.add(cards[i]);
        }
    }

    public void RemoveCard( CardAssistant c){

        Cards.remove(Cards.indexOf(c));

    }

    public List<CardAssistant> GetDeck(){
        return Cards;
    }
}
