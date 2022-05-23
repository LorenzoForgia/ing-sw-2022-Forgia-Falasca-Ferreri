package it.polimi.ingsw.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCard8Test {
    CharacterCard8 CC8= null;
    Bag b=null;
    GeneralBoard gb=null;
    Player player= null;

    @BeforeEach
    public void setUp(){
        CC8= new CharacterCard8(8,1,0);
        b= new Bag();
        b.setStudents(20);
        gb= new GeneralBoard(20);
        gb.CreateTwelveIslands();
        player= new Player("a");
    }

    @AfterEach
    public void tearDown(){
        CC8 = null;
        b=null;
        gb= null;
    }

    @Test
    public void testUseEffect(){
        CC8.SetCard(b,gb);
        CC8.UseEffect(player);
        assertTrue(player.isUsedCharacterCard());
        assertEquals(8,player.getNameCharacterCard());
    }
}