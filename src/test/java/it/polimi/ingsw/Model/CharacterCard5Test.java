package it.polimi.ingsw.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCard5Test {

    CharacterCard5 CC5 =null;
    @BeforeEach
    public void setUp(){
        CC5= new CharacterCard5(5, 2,0);
    }

    @AfterEach
    public void tearDown(){
        CC5 = null;
    }

    @Test
    public void testUseEffect5(){
        IslandTiles I= new IslandTiles( 1, false, 1, false, 0,false);
        CC5.useEffect5(I);
           assertTrue(I.isNoEntryTiles());
           assertEquals(1, I.getNumberOfNet());
    }


}