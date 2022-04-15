package it.polimi.ingsw.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player player = null;
    SchoolBoard SB = null;
    DeckCardAssistant DCA = null;

    @BeforeEach
    public void setUp(){
    SB = new SchoolBoard(1, 7);
    DCA = new DeckCardAssistant();
    player = new Player( "player1" , 1, SB, DCA);
    }

    @AfterEach
    public void tearDown(){
        player = null;
        SB = null;
        DCA = null;
    }

    @Test
    public void testRemoveCoin(){
        try{
            player.removeCoin(1);
            assertEquals( 0, player.getNumberCoins());
        }catch( IllegalMoveException e){
            fail();
        }
    }

    @Test
    public void testRemoveCoin2(){
        boolean thrown= false;
        try{
            player.removeCoin(2);

        }catch( IllegalMoveException e){
            thrown= true;
        }

        assertTrue(thrown);
    }

    @Test
    public void testAddCoin(){
        player.AddCoin(3);
        assertEquals(4, player.getNumberCoins());
    }

    @Test
    public void testChooseSquad(){
        player.ChooseSquad(ColorTower.Black);
        assertEquals( ColorTower.Black, player.GetSquad());
    }

    @Test
    public void testUseCardAssistant(){
        boolean flag = true;
        List<CardAssistant> deckCardAssistant;
        player.usedCard(CardAssistant.Cinque);
        deckCardAssistant = player.getMyDeck().GetDeck();
        for(int i =0; i< deckCardAssistant.size() && flag; i++){
            if(deckCardAssistant.get(i).equals(CardAssistant.Cinque)){
                flag = false;
            }
        }

        assertTrue(flag);
    }
}