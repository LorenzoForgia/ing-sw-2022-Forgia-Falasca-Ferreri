package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.Model.DeckCardAssistant;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.SchoolBoard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayAssCardTest {
    Player p1 = null;
    Player p2 = null;
    Player p3 = null;
    SchoolBoard SB1 = null;
    SchoolBoard SB2 = null;
    SchoolBoard SB3 = null;
    DeckCardAssistant DCA1 = null;
    DeckCardAssistant DCA2 = null;
    DeckCardAssistant DCA3 = null;
    PlayAssCard p= null;

    @BeforeEach
    public void setUp(){
        SB1 = new SchoolBoard(0, 7);
        SB2 = new SchoolBoard(1, 7);
        SB3 = new SchoolBoard(2, 7);
        DCA1 = new DeckCardAssistant();
        DCA2 = new DeckCardAssistant();
        DCA3 = new DeckCardAssistant();
        p1=new Player("A");
        p1.setMySchoolBoard(SB1);
        p1.setNumberCoins(1);
        p1.setMyDeck(DCA1);
        p2=new Player("B");
        p2.setMySchoolBoard(SB2);
        p2.setNumberCoins(1);
        p2.setMyDeck(DCA2);
        p3=new Player("C");
        p3.setMySchoolBoard(SB3);
        p3.setNumberCoins(1);
        p3.setMyDeck(DCA3);
        p= new PlayAssCard();
    }

    @AfterEach
    public void tearDown() {
        p1 = null;
        p2 = null;
        p3 = null;
        SB1 = null;
        SB2 = null;
        SB3 = null;
        DCA1 = null;
        DCA2 = null;
        DCA3 = null;
        p= null;
    }

    @Test
    public void testPlayCard(){
        p.GetAssCard(p1, CardAssistant.Uno);
        p.GetAssCard(p2, CardAssistant.Due);
        p.GetAssCard(p3, CardAssistant.Tre);
        assertEquals(3, p.GetAssCardPlayed().size());
        assertEquals(9, p1.getMyDeck().GetDeck().size());
        assertEquals(9, p2.getMyDeck().GetDeck().size());
        assertEquals(9, p3.getMyDeck().GetDeck().size());
        assertEquals(CardAssistant.Uno, p1.getCA());
        assertEquals(CardAssistant.Due, p2.getCA());
        assertEquals(CardAssistant.Tre, p3.getCA());
    }

    @Test
    public void testIfLast(){
        p.GetAssCard(p1, CardAssistant.Uno);
        p.GetAssCard(p2, CardAssistant.Due);
        assertFalse(p.CheckIfLast(p3));
    }

    @Test
    public void testIfLast2(){
        p.GetAssCard(p1, CardAssistant.Uno);
        p.GetAssCard(p2, CardAssistant.Due);
        p3.getMyDeck().RemoveCard(CardAssistant.Tre);
        p3.getMyDeck().RemoveCard(CardAssistant.Quattro);
        p3.getMyDeck().RemoveCard(CardAssistant.Cinque);
        p3.getMyDeck().RemoveCard(CardAssistant.Sei);
        p3.getMyDeck().RemoveCard(CardAssistant.Sette);
        p3.getMyDeck().RemoveCard(CardAssistant.Otto);
        p3.getMyDeck().RemoveCard(CardAssistant.Nove);
        p3.getMyDeck().RemoveCard(CardAssistant.Dieci);

        assertTrue(p.CheckIfLast(p3));

    }

    @Test
    public void testResetCardsPlayed(){
        p.GetAssCard(p1, CardAssistant.Uno);
        p.GetAssCard(p2, CardAssistant.Due);
        p.ResetCardPlayed();
        assertEquals(0,p.GetAssCardPlayed().size());
    }
}