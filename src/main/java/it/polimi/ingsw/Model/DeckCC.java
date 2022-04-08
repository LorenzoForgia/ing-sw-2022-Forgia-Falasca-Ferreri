package it.polimi.ingsw.Model;

import java.util.ArrayList;

public class DeckCC {
    private ArrayList<CharacterCard> characterCards= new ArrayList<CharacterCard>();

    public DeckCC(ArrayList<CharacterCard> characterCards) {
        this.characterCards = characterCards;
    }
    public CharacterCard DrawCard(){
        return characterCards.get(1) ;
    }
}
