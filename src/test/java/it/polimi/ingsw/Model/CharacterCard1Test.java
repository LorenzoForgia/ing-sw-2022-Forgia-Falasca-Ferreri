package it.polimi.ingsw.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCard1Test {
    CharacterCard1 CC1= null;
    Bag b=null;
    GeneralBoard gb=null;
    Player player= null;

    @BeforeEach
    public void setUp(){
        CC1= new CharacterCard1(1,1,0,"");
        b= new Bag();
        b.setStudents(20);
        gb= new GeneralBoard(20);
        gb.CreateTwelveIslands();
        player= new Player("a");
    }

    @AfterEach
    public void tearDown(){
        CC1 = null;
        b=null;
        gb= null;
        player=null;
    }

    @Test
    public void testUseEffect(){
        CC1.SetCard(b,gb);
        assertEquals(4,CC1.GetchoosenStudent().size());
        CC1.setChoosenColor(CC1.GetchoosenStudent().get(1));
        CC1.setIchosen(gb.GetIslands().get(0));
        CC1.UseEffect(player);
        assertTrue(player.isUsedCharacterCard());
        assertEquals(1,player.getNameCharacterCard());
        assertEquals(1,gb.GetIslands().get(0).getStudentsInIsland().size());
    }
}