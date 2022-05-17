package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Exception.CardAssistantNotAvailableException;
import it.polimi.ingsw.Model.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {
    GameController gameController = null;

    @BeforeEach
    public void setUp() {
        gameController = new GameController();
    }

    @AfterEach
    public void tearDown() {
        gameController = null;
    }

    @Test
    public void testCardAssistantInDeck() {
        List<Player> players = new ArrayList<>();
        SchoolBoard SB1 = new SchoolBoard(0, 9);
        SchoolBoard SB2 = new SchoolBoard(1, 9);
        SchoolBoard SB3 = new SchoolBoard(2, 9);
        DeckCardAssistant DCA1 = new DeckCardAssistant();
        DeckCardAssistant DCA2 = new DeckCardAssistant();
        DeckCardAssistant DCA3 = new DeckCardAssistant();
        Player p1 = new Player("A");
        p1.setMySchoolBoard(SB1);
        p1.setNumberCoins(1);
        p1.setMyDeck(DCA1);
        Player p2 = new Player("B");
        p2.setMySchoolBoard(SB2);
        p2.setNumberCoins(1);
        p2.setMyDeck(DCA2);
        Player p3 = new Player("C");
        p3.setMySchoolBoard(SB3);
        p3.setNumberCoins(1);
        p3.setMyDeck(DCA3);
        players.add(0, p1);
        players.add(1, p2);
        players.add(2, p3);
        try {
            gameController.CardAssistantInDeck(CardAssistant.Uno, p1);
        } catch (CardAssistantNotAvailableException e) {
            fail();
        }
        assertEquals(1,gameController.getPlayAssCard().GetAssCardPlayed().size());
        assertEquals(9, players.get(0).getMyDeck().GetDeck().size());
    }

    @Test
    public void testCardAssistantInDeck2() {
        List<Player> players = new ArrayList<>();
        SchoolBoard SB1 = new SchoolBoard(0, 9);
        SchoolBoard SB2 = new SchoolBoard(1, 9);
        SchoolBoard SB3 = new SchoolBoard(2, 9);
        DeckCardAssistant DCA1 = new DeckCardAssistant();
        DeckCardAssistant DCA2 = new DeckCardAssistant();
        DeckCardAssistant DCA3 = new DeckCardAssistant();
        boolean thrown= false;
        Player p1 = new Player("A");
        p1.setMySchoolBoard(SB1);
        p1.setNumberCoins(1);
        p1.setMyDeck(DCA1);
        Player p2 = new Player("B");
        p2.setMySchoolBoard(SB2);
        p2.setNumberCoins(1);
        p2.setMyDeck(DCA2);
        Player p3 = new Player("C");
        p3.setMySchoolBoard(SB3);
        p3.setNumberCoins(1);
        p3.setMyDeck(DCA3);
        players.add(0, p1);
        players.add(1, p2);
        players.add(2, p3);

        try {
            gameController.CardAssistantInDeck(CardAssistant.Uno, p1);
        } catch (CardAssistantNotAvailableException e) {
            fail();
        }

        try {
            gameController.CardAssistantInDeck(CardAssistant.Uno, p2);
        } catch (CardAssistantNotAvailableException e) {
            thrown = true;
        }
        assertEquals(1,gameController.getPlayAssCard().GetAssCardPlayed().size());
        assertEquals(9, players.get(0).getMyDeck().GetDeck().size());
        assertEquals(10, players.get(1).getMyDeck().GetDeck().size());
        assertTrue(thrown);
    }

    @Test
    public void testCardAssistantInDeck3() {
        List<Player> players = new ArrayList<>();
        SchoolBoard SB1 = new SchoolBoard(0, 9);
        SchoolBoard SB2 = new SchoolBoard(1, 9);
        SchoolBoard SB3 = new SchoolBoard(2, 9);
        DeckCardAssistant DCA1 = new DeckCardAssistant();
        DeckCardAssistant DCA2 = new DeckCardAssistant();
        DeckCardAssistant DCA3 = new DeckCardAssistant();
        Player p1 = new Player("A");
        p1.setMySchoolBoard(SB1);
        p1.setNumberCoins(1);
        p1.setMyDeck(DCA1);
        Player p2 = new Player("B");
        p2.setMySchoolBoard(SB2);
        p2.setNumberCoins(1);
        p2.setMyDeck(DCA2);
        Player p3 = new Player("C");
        p3.setMySchoolBoard(SB3);
        p3.setNumberCoins(1);
        p3.setMyDeck(DCA3);
        players.add(0, p1);
        players.add(1, p2);
        players.add(2, p3);

        try {
            gameController.CardAssistantInDeck(CardAssistant.Uno, p1);
            gameController.CardAssistantInDeck(CardAssistant.Due, p1);
            gameController.CardAssistantInDeck(CardAssistant.Tre, p1);
        } catch (CardAssistantNotAvailableException e) {
            fail();
        }

        gameController.getPlayAssCard().ResetCardPlayed();
        assertEquals(0,gameController.getPlayAssCard().GetAssCardPlayed().size());

        try {
            gameController.CardAssistantInDeck(CardAssistant.Quattro, p1);
            gameController.CardAssistantInDeck(CardAssistant.Cinque, p1);
            gameController.CardAssistantInDeck(CardAssistant.Sei, p1);
        } catch (CardAssistantNotAvailableException e) {
            fail();
        }
        assertEquals(3,gameController.getPlayAssCard().GetAssCardPlayed().size());
        gameController.getPlayAssCard().ResetCardPlayed();
        assertEquals(0,gameController.getPlayAssCard().GetAssCardPlayed().size());
        try {
            gameController.CardAssistantInDeck(CardAssistant.Sette, p1);
            gameController.CardAssistantInDeck(CardAssistant.Otto, p1);
            gameController.CardAssistantInDeck(CardAssistant.Nove, p1);
        } catch (CardAssistantNotAvailableException e) {
            fail();
        }
        assertEquals(3,gameController.getPlayAssCard().GetAssCardPlayed().size());
        gameController.getPlayAssCard().ResetCardPlayed();
        assertEquals(0,gameController.getPlayAssCard().GetAssCardPlayed().size());
        try {
            gameController.CardAssistantInDeck(CardAssistant.Dieci, p2);
        } catch (CardAssistantNotAvailableException e) {
            fail();
        }

        try {
            gameController.CardAssistantInDeck(CardAssistant.Dieci, p1);
        } catch (CardAssistantNotAvailableException e) {
            fail();
        }
        assertEquals(2,gameController.getPlayAssCard().GetAssCardPlayed().size());
        assertEquals(0, players.get(0).getMyDeck().GetDeck().size());
        assertEquals(9, players.get(1).getMyDeck().GetDeck().size());

    }


}