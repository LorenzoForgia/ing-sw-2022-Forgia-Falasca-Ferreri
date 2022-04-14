package it.polimi.ingsw.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckCardAssistantTest {
    DeckCardAssistant DCA =null;
    @BeforeEach
    public void setUp(){
        DCA= new DeckCardAssistant();
    }

    @AfterEach
    public void tearDown(){
        DCA =null;
    }

    @Test
    public void testRemoveCard(){
        boolean flag= true;
        DCA.RemoveCard(CardAssistant.Cinque);

        for(int i=0; i< DCA.GetDeck().size() && flag; i++){
            if(DCA.GetDeck().get(i).equals(CardAssistant.Cinque)){
                flag= false;
            }
        }
        assertTrue(flag);
    }
}