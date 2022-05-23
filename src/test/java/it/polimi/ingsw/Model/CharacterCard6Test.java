package it.polimi.ingsw.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCard6Test {
    CharacterCard6 CC6= null;
    Bag b=null;
    GeneralBoard gb=null;
    Player player= null;

    @BeforeEach
    public void setUp(){
        CC6= new CharacterCard6(6,1,0);
        b= new Bag();
        b.setStudents(20);
        gb= new GeneralBoard(20);
        gb.CreateTwelveIslands();
        player= new Player("a");
    }

    @AfterEach
    public void tearDown(){
        CC6 = null;
        b=null;
        gb= null;
    }

    @Test
    public void testUseEffect(){
        CC6.SetCard(b,gb);
        CC6.UseEffect(player);
        assertTrue(player.isUsedCharacterCard());
        assertEquals(6,player.getNameCharacterCard());
    }

}