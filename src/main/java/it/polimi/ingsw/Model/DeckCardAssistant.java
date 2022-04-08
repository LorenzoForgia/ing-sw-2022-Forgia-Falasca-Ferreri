package it.polimi.ingsw.Model;

/*@author Luigia Falasca*/

import java.util.*;

public class DeckCardAssistant {
    List<CardAssistant> Cards = new ArrayList<>();

    public List<CardAssistant> CreateNewDeck(){
        CardAssistant[] cards = CardAssistant.values();
        for(int i= 0; i < 10; i++ ){
            Cards.add(cards[i]);
        }
        return Cards;
    }

    public void RemoveCard( CardAssistant c){

        Cards.remove(Cards.indexOf(c));

    }
}
