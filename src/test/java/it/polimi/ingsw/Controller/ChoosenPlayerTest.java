package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.CardAssistant;
import it.polimi.ingsw.Model.DeckCardAssistant;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.SchoolBoard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChoosenPlayerTest {
    Player player1 = null;
    Player player2 = null;
    Player player3 = null;
    SchoolBoard SB1 = null;
    SchoolBoard SB2 = null;
    SchoolBoard SB3 = null;
    DeckCardAssistant DCA1 = null;
    DeckCardAssistant DCA2 = null;
    DeckCardAssistant DCA3 = null;
    PlayAssCard p= null;
    ChoosenPlayer pl= null;

    @BeforeEach
    public void setUp(){
        SB1 = new SchoolBoard(0, 9);
        SB2 = new SchoolBoard(1, 9);
        SB3 = new SchoolBoard(2, 9);
        DCA1 = new DeckCardAssistant();
        DCA2 = new DeckCardAssistant();
        DCA3 = new DeckCardAssistant();
        player1 = new Player( "player1" , 1, SB1, DCA1);
        player2 = new Player( "player2" , 1, SB2, DCA2);
        player3 = new Player( "player3" , 1, SB3, DCA3);
        p= new PlayAssCard();
        pl= new ChoosenPlayer();
    }

    @AfterEach
    public void tearDown() {
        Player player1 = null;
        Player player2 = null;
        Player player3 = null;
        SchoolBoard SB1 = null;
        SchoolBoard SB2 = null;
        SchoolBoard SB3 = null;
        DeckCardAssistant DCA1 = null;
        DeckCardAssistant DCA2 = null;
        DeckCardAssistant DCA3 = null;
        p = null;
        pl = null;
    }

    @Test
    public void testChoosenTurnPlayer(){
        p.GetAssCard(player1, CardAssistant.Uno, 3);
        p.GetAssCard(player2, CardAssistant.Due, 3);
        p.GetAssCard(player3, CardAssistant.Tre, 3);
        pl.ChooseTurnPlayer(p.GetAssCardPlayed(), player1);
        pl.ChooseTurnPlayer(p.GetAssCardPlayed(), player2);
        pl.ChooseTurnPlayer(p.GetAssCardPlayed(), player3);
        assertEquals(0, player1.GetNumTurn());
        assertEquals(1, player2.GetNumTurn());
        assertEquals(2,player3.GetNumTurn());
        assertEquals(1, player1.getCA().getMovementMN());
        assertEquals(1, player2.getCA().getMovementMN());
        assertEquals(2, player3.getCA().getMovementMN());
    }

}