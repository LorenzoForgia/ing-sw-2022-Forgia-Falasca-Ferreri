package it.polimi.ingsw.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCard8Test {
    CharacterCard8 CC8 = null;

    @BeforeEach
    public void setUp(){
        CC8= new CharacterCard8(8, 3,0);
    }

    @AfterEach
    public void tearDown(){
        CC8 = null;
    }

    @Test
    public void testUseEffect6(){
        IslandTiles I= new IslandTiles( 1, true, 2, false, 0,true);
        int influence = 8;
        int newInfluence;
        newInfluence= CC8.useEffect8(I,influence);
        assertEquals(10,newInfluence);
    }
}