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

    @Test
    public void testSetCharacterCard10() {
        CharacterCard10 c10= new CharacterCard10(10,1,0,"");
        SchoolBoard SB1 = new SchoolBoard(0, 7);
        DeckCardAssistant DCA1 = new DeckCardAssistant();
        Player p1 = new Player("A");
        p1.setMySchoolBoard(SB1);
        p1.setNumberCoins(1);
        p1.setMyDeck(DCA1);
        SB1.AddStudent(Color.Pink);
        SB1.getDiningRoom().PutStudent(Color.Blue);
        ArrayList<Color> colorEntrance= new ArrayList<>();
        colorEntrance.add(Color.Pink);
        ArrayList<Color> colorDiningRoom= new ArrayList<>();
        colorDiningRoom.add(Color.Blue);
        assertTrue(gameController.SetCharacterCard10(c10, colorEntrance, colorDiningRoom, p1));
    }
    @Test
    public void testSetCharacterCard10noColorRight() {
        CharacterCard10 c10= new CharacterCard10(10,1,0,"");
        SchoolBoard SB1 = new SchoolBoard(0, 7);
        DeckCardAssistant DCA1 = new DeckCardAssistant();
        Player p1 = new Player("A");
        p1.setMySchoolBoard(SB1);
        p1.setNumberCoins(1);
        p1.setMyDeck(DCA1);
        SB1.AddStudent(Color.Pink);
        SB1.getDiningRoom().PutStudent(Color.Blue);
        ArrayList<Color> colorEntrance= new ArrayList<>();
        colorEntrance.add(Color.Pink);
        ArrayList<Color> colorDiningRoom= new ArrayList<>();
        colorDiningRoom.add(Color.Green);
        assertFalse(gameController.SetCharacterCard10(c10, colorEntrance, colorDiningRoom, p1));
    }

    @Test
    public void testSetCharacterCard7() {
        Bag b = new Bag();
        b.setStudents(120);
        GeneralBoard gb= new GeneralBoard(20);
        CharacterCard7 c7= new CharacterCard7(7,1,0,"");
        SchoolBoard SB1 = new SchoolBoard(0, 7);
        DeckCardAssistant DCA1 = new DeckCardAssistant();
        Player p1 = new Player("A");
        p1.setMySchoolBoard(SB1);
        p1.setNumberCoins(1);
        p1.setMyDeck(DCA1);
        SB1.AddStudent(Color.Pink);
        ArrayList<Color> colorEntrance= new ArrayList<>();
        colorEntrance.add(Color.Pink);
        c7.SetCard(b,gb);
        ArrayList<Color> colorCard= new ArrayList<>();
        colorCard.add(c7.getStudentOnCard().get(0));
        assertTrue(gameController.SetCharacterCard7(c7,colorEntrance,colorCard, p1));
    }

    @Test
    public void testSetCharacterCard7noCorrectColor() {
        Bag b = new Bag();
        b.setStudents(120);
        GeneralBoard gb= new GeneralBoard(20);
        CharacterCard7 c7= new CharacterCard7(7,1,0,"");
        SchoolBoard SB1 = new SchoolBoard(0, 7);
        DeckCardAssistant DCA1 = new DeckCardAssistant();
        Player p1 = new Player("A");
        p1.setMySchoolBoard(SB1);
        p1.setNumberCoins(1);
        p1.setMyDeck(DCA1);
        SB1.AddStudent(Color.Pink);
        ArrayList<Color> colorEntrance= new ArrayList<>();
        colorEntrance.add(Color.Green);
        c7.SetCard(b,gb);
        ArrayList<Color> colorCard= new ArrayList<>();
        colorCard.add(c7.getStudentOnCard().get(0));
        assertFalse(gameController.SetCharacterCard7(c7,colorEntrance,colorCard, p1));
    }
}