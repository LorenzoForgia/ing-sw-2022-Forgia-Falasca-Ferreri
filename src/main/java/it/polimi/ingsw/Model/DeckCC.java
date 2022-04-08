package it.polimi.ingsw.Model;

import java.util.ArrayList;
import java.util.Random;

public class DeckCC {
    private ArrayList<CharacterCard> characterCards= new ArrayList<CharacterCard>();

    public DeckCC(ArrayList<CharacterCard> characterCards) {
        this.characterCards = characterCards;
    }
    public CharacterCard DrawCard(){
        Random random = new Random();
        int draftedindex = random.nextInt(this.characterCards.size());
        CharacterCard draftedcard = this.characterCards.get(draftedindex);
        this.characterCards.remove(draftedindex);
        return draftedcard;
    }
}
