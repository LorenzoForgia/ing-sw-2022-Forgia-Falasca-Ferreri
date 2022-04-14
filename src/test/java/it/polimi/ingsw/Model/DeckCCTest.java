package it.polimi.ingsw.Model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeckCCTest {
    @Test
    public void testDrawCard(){
        DeckCC d=new DeckCC();
        assertEquals(12,d.getCharacterCards().size());
        d.DrawCard();
        d.DrawCard();
        d.DrawCard();
        d.DrawCard();
        assertEquals(8,d.getCharacterCards().size());
    }

}