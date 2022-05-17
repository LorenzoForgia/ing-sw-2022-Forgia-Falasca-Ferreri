package it.polimi.ingsw.Model;

import javax.lang.model.element.Name;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class DeckCC implements Serializable {
    private ArrayList<CharacterCard> characterCards= new ArrayList<CharacterCard>();

    public DeckCC() {
      characterCards.add(new CharacterCard1(1,1,0 ));
      characterCards.add(new CharacterCard2(2,2,0 ));
      characterCards.add(new CharacterCard3(3,3,0 ));
      characterCards.add(new CharacterCard4(4,1,0 ));
      characterCards.add(new CharacterCard5(5,2,0 ));
      characterCards.add(new CharacterCard6(6,3,0 ));
      characterCards.add(new CharacterCard7(7,1,0 ));
      characterCards.add(new CharacterCard8(8,2,0 ));
      characterCards.add(new CharacterCard9(9,3,0 ));
      characterCards.add(new CharacterCard10(10,1,0 ));
      characterCards.add(new CharacterCard11(11,2,0 ));
      characterCards.add(new CharacterCard12(12,3,0 ));
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
