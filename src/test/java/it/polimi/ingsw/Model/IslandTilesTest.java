package it.polimi.ingsw.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class IslandTilesTest {

    IslandTiles Island = null;
    @BeforeEach
    public void setUp(){
        Island = new IslandTiles(1, false, 1, false, 0, false);
    }

    @AfterEach
    public void tearDown(){
        Island = null;
    }

    @Test
    public void testPutMN() {
        Island.putMotherNature();
        assertTrue(Island.isMotherNature());
    }

    @Test
    public void testPutNET() {

        Island.putNET();
        assertTrue(Island.isNoEntryTiles());
        assertEquals(1, Island.getNumberOfNet());

    }


    @Test
    public void testRemoveMN() {
        Island.putMotherNature();
        Island.removeNM();
        assertFalse(Island.isMotherNature());
    }

    @Test
    public void testRemoveNET() {
            Island.putNET();
            Island.removeNET();

        assertFalse(Island.isNoEntryTiles());
        assertEquals(0, Island.getNumberOfNet());

    }



    @Test
    public void tesPutTower() {
        Island.putTower(ColorTower.Black);
        assertTrue(Island.isTower());
        assertEquals(ColorTower.Black, Island.getColTower());
    }


    @Test
    public void tesSetStudent() {
        Island.PutStudent(Color.Blue);
        Island.PutStudent(Color.Pink);

        assertEquals(2 , Island.getStudentsInIsland().size());
    }

    @Test
    public void testCountInfluence(){
        int count;
        Island.PutStudent(Color.Blue);
        Island.PutStudent(Color.Pink);

        count=Island.CountInfluence(Color.Blue);
        assertEquals(1, count);
    }
    @Test
    public void testPutStudent(){
        Island.PutStudent(Color.Green);
        Island.PutStudent(Color.Yellow);
        assertEquals(2, Island.getStudentsInIsland().size());
        assertEquals(Color.Yellow, Island.GetStudent(1));
    }

}

