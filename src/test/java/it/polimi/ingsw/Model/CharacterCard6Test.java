package it.polimi.ingsw.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCard6Test {
  CharacterCard6 CC6 = null;

    @BeforeEach
    public void setUp(){
        CC6= new CharacterCard6(6, 3,0);
    }

    @AfterEach
    public void tearDown(){
        CC6 = null;
    }

    @Test
    public void testUseEffect6(){
        IslandTiles I= new IslandTiles( 1, true, 2, false, true);
        int influence = 8;
        int newInfluence;
        newInfluence= CC6.useEffect6(I,influence);
        assertEquals(6,newInfluence);
    }

    @Test
    public void testUseEffect62(){
        IslandTiles I= new IslandTiles( 1, true, 1, false, false);
        int influence = 8;
        int newInfluence;
        newInfluence= CC6.useEffect6(I,influence);
        assertEquals(8,newInfluence);
    }
}