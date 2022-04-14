package it.polimi.ingsw.Model;

import javax.lang.model.element.Name;
import java.util.ArrayList;
import java.util.Random;

public class DeckCC {
    private ArrayList<CharacterCard> characterCards= new ArrayList<CharacterCard>();

    public DeckCC() {
      characterCards.add(new CharacterCard(1,1,0 ));
      characterCards.add(new CharacterCard(2,2,0 ));
      characterCards.add(new CharacterCard(3,3,0 ));
      characterCards.add(new CharacterCard(4,1,0 ));
      characterCards.add(new CharacterCard(5,2,0 ));
      characterCards.add(new CharacterCard(6,3,0 ));
      characterCards.add(new CharacterCard(7,1,0 ));
      characterCards.add(new CharacterCard(8,2,0 ));
      characterCards.add(new CharacterCard(9,3,0 ));
      characterCards.add(new CharacterCard(10,1,0 ));
      characterCards.add(new CharacterCard(11,2,0 ));
      characterCards.add(new CharacterCard(12,3,0 ));
    }
    public CharacterCard DrawCard(){
        Random random = new Random();
        int draftedindex = random.nextInt(this.characterCards.size());
        CharacterCard draftedcard = this.characterCards.get(draftedindex);
        this.characterCards.remove(draftedindex);
        return draftedcard;
    }

    public ArrayList<CharacterCard> getCharacterCards() {  /**only for test**/
        return characterCards;
    }
}
