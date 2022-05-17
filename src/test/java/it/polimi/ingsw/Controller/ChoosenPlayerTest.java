package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.Model.DeckCardAssistant;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.SchoolBoard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChoosenPlayerTest {
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
    ChoosenPlayer pl= null;
    List<Player> players = null;

    @BeforeEach
    public void setUp(){
        players = new ArrayList<>();
        SB1 = new SchoolBoard(0, 9);
        SB2 = new SchoolBoard(1, 9);
        SB3 = new SchoolBoard(2, 9);
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
        pl= new ChoosenPlayer();
        players.add(0, p1);
        players.add(1,p2);
        players.add(2,p3);

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
        p = null;
        pl = null;
        players = null;
    }

    @Test
    public void testChoosenTurnPlayerForCardAssistant(){
        pl.setFirstPlayer(p1);
        pl.ChooseTurnPlayerForCardAssistant(players);
        assertEquals(p1, pl.GetPlayerTurn());
        pl.incrementTurn();
        assertEquals(p2, pl.GetPlayerTurn());
        pl.incrementTurn();
        assertEquals(p3, pl.GetPlayerTurn());
        pl.incrementTurn();
        assertTrue(pl.EndOfAllTurn());
    }

    @Test
    public void testChoosenTurnPlayerForCardAssistant2(){
        pl.setFirstPlayer(p3);
        pl.ChooseTurnPlayerForCardAssistant(players);
        assertEquals(0,p3.getTurnToPlayCardAssistant());
        assertEquals(1,p1.getTurnToPlayCardAssistant());
        assertEquals(2,p2.getTurnToPlayCardAssistant());
        assertEquals(p3, pl.GetPlayerTurn());
        pl.incrementTurn();
        assertEquals(p1, pl.GetPlayerTurn());
        pl.incrementTurn();
        assertEquals(p2, pl.GetPlayerTurn());
        pl.incrementTurn();
        assertEquals(3, pl.getOrderPlayers().size());
        assertTrue(pl.EndOfAllTurn());
    }

    @Test
    public void testChoosenTurnPlayerForCardAssistant3(){
        pl.setFirstPlayer(p2);
        pl.ChooseTurnPlayerForCardAssistant(players);
        assertEquals(p2, pl.GetPlayerTurn());
        pl.incrementTurn();
        assertEquals(p3, pl.GetPlayerTurn());
        pl.incrementTurn();
        assertEquals(p1, pl.GetPlayerTurn());
        pl.incrementTurn();
        assertTrue(pl.EndOfAllTurn());
    }

    @Test
    public void testChoosenTurnPlayer(){
        pl.setFirstPlayer(p2);
        pl.ChooseTurnPlayerForCardAssistant(players);
        assertEquals(p2, pl.GetPlayerTurn());
        pl.incrementTurn();
        assertEquals(p3, pl.GetPlayerTurn());
        pl.incrementTurn();
        assertEquals(p1, pl.GetPlayerTurn());
        pl.incrementTurn();
        pl.EndOfAllTurn();
        p.GetAssCard(p2, CardAssistant.Due);
        p.GetAssCard(p1, CardAssistant.Tre);
        p.GetAssCard(p3, CardAssistant.Uno);
        assertEquals(CardAssistant.Uno, p3.getCA());
        assertEquals(CardAssistant.Due, p2.getCA());
        assertEquals(CardAssistant.Tre, p1.getCA());
        pl.ChooseTurnPlayer(players);
        assertEquals(1, p3.getCA().getCardValue());
        assertEquals(2, p2.getCA().getCardValue());
        assertEquals(3, p1.getCA().getCardValue());
       assertEquals(0, p3.GetNumTurn());
        assertEquals(1, p2.GetNumTurn() );
        assertEquals(2, p1.GetNumTurn());
        assertEquals(p3, pl.GetPlayerTurn());
        pl.incrementTurn();
        assertEquals(p2, pl.GetPlayerTurn());
        pl.incrementTurn();
        assertFalse(pl.EndOfAllTurn());
        assertEquals(p1, pl.GetPlayerTurn());
        pl.incrementTurn();

    }



    @Test
    public void testChoosenTurnPlayer2(){
        pl.setFirstPlayer(p1);
        pl.ChooseTurnPlayerForCardAssistant(players);
        assertEquals(p1, pl.GetPlayerTurn());
        pl.incrementTurn();
        assertEquals(p2, pl.GetPlayerTurn());
        pl.incrementTurn();
        assertEquals(p3, pl.GetPlayerTurn());
        pl.incrementTurn();
        assertTrue(pl.EndOfAllTurn());
        p.GetAssCard(p1, CardAssistant.Quattro);
        p.GetAssCard(p2, CardAssistant.Quattro);
        p.GetAssCard(p3, CardAssistant.Cinque);
        pl.ChooseTurnPlayer(players);
        assertEquals(0, p1.GetNumTurn());
        assertEquals(1, p2.GetNumTurn() );
        assertEquals(2, p3.GetNumTurn());
        assertEquals(p1, pl.GetPlayerTurn());
        pl.incrementTurn();
        assertEquals(p2, pl.GetPlayerTurn());
        pl.incrementTurn();
        assertEquals(p3, pl.GetPlayerTurn());
        pl.incrementTurn();
        assertEquals(3, pl.getOrderPlayers().size());
        assertTrue(pl.EndOfAllTurn());
    }



}