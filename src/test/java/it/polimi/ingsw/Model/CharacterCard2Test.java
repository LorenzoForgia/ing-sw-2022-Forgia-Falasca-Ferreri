package it.polimi.ingsw.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCard2Test {
    CharacterCard2 CC2= null;
    Bag b=null;
    GeneralBoard gb=null;
    Player player= null;

    @BeforeEach
    public void setUp(){
        CC2= new CharacterCard2(2,1,0,"");
        b= new Bag();
        b.setStudents(20);
        gb= new GeneralBoard(20);
        gb.CreateTwelveIslands();
        player= new Player("a");
    }

    @AfterEach
    public void tearDown(){
        CC2 = null;
        b=null;
        gb= null;
        player= null;
    }

    @Test
    public void testUseEffect(){
        CC2.SetCard(b,gb);
        CC2.UseEffect(player);
        assertTrue(player.isUsedCharacterCard());
    }
}