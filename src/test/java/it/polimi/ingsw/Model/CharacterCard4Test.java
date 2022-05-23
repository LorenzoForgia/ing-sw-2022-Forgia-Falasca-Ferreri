package it.polimi.ingsw.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCard4Test {
    CharacterCard4 CC4= null;
    Bag b=null;
    GeneralBoard gb=null;
    Player player= null;


    @BeforeEach
    public void setUp(){
        CC4= new CharacterCard4(4,1,0);
        b= new Bag();
        b.setStudents(20);
        gb= new GeneralBoard(20);
        gb.CreateTwelveIslands();
        player= new Player("a");
    }

    @AfterEach
    public void tearDown(){
        CC4 = null;
        b=null;
        gb= null;
        player= null;
    }

    @Test
    public void testUseEffect(){
        CC4.SetCard(b,gb);
        CC4.UseEffect(player);
        assertTrue(player.isUsedCharacterCard());
        assertEquals(4,player.getNameCharacterCard());
        assertEquals(3,CC4.AddTwoMvntMN(CardAssistant.Due));
    }
}