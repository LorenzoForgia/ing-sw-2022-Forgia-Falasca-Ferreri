package it.polimi.ingsw.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCard5Test {
    CharacterCard5 CC5= null;
    Bag b=null;
    GeneralBoard gb=null;
    Player player= null;

    @BeforeEach
    public void setUp(){
        CC5= new CharacterCard5(5,1,0,"");
        b= new Bag();
        b.setStudents(20);
        gb= new GeneralBoard(20);
        gb.CreateTwelveIslands();
        player= new Player("a");
    }

    @AfterEach
    public void tearDown(){
        CC5 = null;
        b=null;
        gb= null;
        player= null;
    }

    @Test
    public void testUseEffect(){
        CC5.SetCard(b,gb);
        CC5.setI1(gb.GetIslands().get(0));
        CC5.UseEffect(player);
        assertTrue(player.isUsedCharacterCard());
        assertEquals(5,player.getNameCharacterCard());
        assertTrue(gb.GetIslands().get(0).isNoEntryTiles());
        assertEquals(1,gb.GetIslands().get(0).getNumberOfNet());
    }


}