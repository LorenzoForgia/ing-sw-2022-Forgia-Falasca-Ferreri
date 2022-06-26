package it.polimi.ingsw.Model;

import javax.lang.model.element.Name;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Federico Angelo Luigi Ferreri
 */
public class DeckCC implements Serializable {
    private ArrayList<CharacterCard> characterCards= new ArrayList<CharacterCard>();

    public DeckCC() {
      characterCards.add(new CharacterCard1(1,1,0 ,"Prendi uno studente dalla carta e piazzalo su un'isola a tua scelta.Poi pesca uno studente dal sacchetto e mettilo su questa carta"));
      characterCards.add(new CharacterCard2(2,2,0 ,"Durante questo turno prendi il controllo dei professori anche se nella tua sala hai lo stesso numero di studenti del giocatore che li controlla in quel momento"));
      characterCards.add(new CharacterCard3(3,3,0 ,"Scegli un'isola e calcola la maggioranza come se madre natura avesse terminato il suo movimento lì.In questo turno madre natura si muoverà come di consueto e nell'isola dove terminerà il suo movimento la maggioranza verrà normalmente calcolata"));
      characterCards.add(new CharacterCard4(4,1,0 ,"Puoi muovere madre natura fino a due isole addizionali rispetto a quanto indicato sulla carta assistente che hai giocato"));
      characterCards.add(new CharacterCard5(5,2,0 ,"Piazza una tessera divieto su un'isola a tua scelta,la prima volta che madre natura termina il suo movimento lì, rimettete la tessera divieto sulla carta senza calcolare l'influenza su quell'isola nè piazzare torri"));
      characterCards.add(new CharacterCard6(6,3,0 ,"Durante il conteggio dell'influenza su un'isola le torri presenti non vengono calcolate."));
      characterCards.add(new CharacterCard7(7,1,0 ,"Puoi prendere fino a 3 studenti da questa carta e scambiarli con altrettanti studenti presenti nel tuo ingresso "));
      characterCards.add(new CharacterCard8(8,2,0 ,"in questo turno, durante il calcolo dell'influenza hai 2 punti di influenza addizionali"));
      characterCards.add(new CharacterCard9(9,3,0 ,"Scegli un colore di studente, in questo turno,durante il calcolo dell'influenza quel colore non fornisce influenza"));
      characterCards.add(new CharacterCard10(10,1,0 ,"puoi scambiare tra loro fino a 2 studenti presenti nella tua sala e nel tuo ingresso"));
      characterCards.add(new CharacterCard11(11,2,0 ,"Prendi uno studente dalla carta e piazzalo nella tua sala.Poi pesca uno studente dal sacchetto e mettilo su questa carta"));
      characterCards.add(new CharacterCard12(12,3,0 ,"Scegli un colore di studente,ogni giocatore incluso te deve rimettere nel sacchetto 3 studenti di quel colore presenti nella sua sala.Chi avesse meno di 3 studenti di quel colore,rimetterà tutti quelli che ha."));
    }

    /** draw random card
     * **/
    public CharacterCard DrawCard(){
        Random random = new Random();
        int draftedindex = random.nextInt(this.characterCards.size());
        CharacterCard draftedcard = this.characterCards.get(draftedindex);
        this.characterCards.remove(draftedindex);
        return draftedcard;
    }

    public ArrayList<CharacterCard> getCharacterCards() {
        return characterCards;
    }
}
